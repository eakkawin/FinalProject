package roomalert;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static java.time.Instant.now;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import static java.time.Instant.now;

public class RoomAlertRunner {

    static DateFormat dateFormat = new SimpleDateFormat("EEEE dd MMM yyyy HH:mm:ss");    

    static Timer deviceTimer = new Timer();
    static Timer loadTimeTimer = new Timer();

    static List<String> mqttCmd = Device.getCMD(1);

    public static void main(String args[]) {
        System.out.println("Ready | V.2");
        
        scheduleLoadTimeTask();
    }
    
    // Schedule web load task at 00:00 everyday
    private static void scheduleLoadTimeTask() {
        Calendar scheduleTime = Calendar.getInstance();
        scheduleTime.set(Calendar.HOUR_OF_DAY, 0);
        scheduleTime.set(Calendar.MINUTE, 0);
        scheduleTime.set(Calendar.SECOND, 0);

        loadTimeTimer.schedule(new LoadTimeTask(), scheduleTime.getTime(), TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS));
    }

    // Schedule device command task at specific period
    private static void scheduleDeviceTask(int periodIndex, String startTime, String endTime) {

        Date now = new Date();

        try {

            Date startDate = dateFormat.parse(startTime);
            Date endDate = dateFormat.parse(endTime);

            if (startDate.after(now) && startDate.before(endDate)) {
                deviceTimer.schedule(new DeviceTimeTask(DeviceTimeTask.TURN_ON, startTime), startDate);
            } else {
                System.err.println(startDate.toString() + " is past");
            }

            if (endDate.after(now)) {
                deviceTimer.schedule(new DeviceTimeTask(DeviceTimeTask.TURN_OFF, endTime), endDate);
            } else {
                System.err.println(endDate.toString() + " is past");
            }

            System.out.println("Schedule for Period " + periodIndex + " " + startDate.toString() + " to " + endDate.toString());

        } catch (ParseException ex) {
            Logger.getLogger(RoomAlertRunner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Load web content
    private static void getBookedRoom() throws IOException {

        System.out.println("Getting data ...");

        Calendar now = Calendar.getInstance();

        String search = "https://webapp1.sit.kmutt.ac.th/booking/web/report.php?"
                + "From_day=" + now.get(Calendar.DATE)
                + "&From_month=" + (now.get(Calendar.MONTH) + 1)
                + "&From_year=" + now.get(Calendar.YEAR)
                + "&To_day=" + now.get(Calendar.DATE)
                + "&To_month=" + (now.get(Calendar.MONTH) + 1)
                + "&To_year=" + now.get(Calendar.YEAR)
                + "&areamatch=1"
                + "&roommatch=1%2F1" // train 1/1  = 1%2F1 < %2F แทน / >
                + "&typematch%5B%5D=A"
                + "&namematch="
                + "&descrmatch="
                + "&creatormatch="
                + "&summarize=1"
                + "&sortby=r"
                + "&display=e"
                + "&sumby=d";

        Document doc = Jsoup.connect(search).post();
        Elements time = doc.getElementsByClass("BR");

        System.out.println("Getting data Done");

        if (!time.isEmpty()) {
            getTimeFromDoc(time);
        } else {
            System.err.println("No class for today.");
        }
    }

    // Read <tr> tag find date-time
    private static void getTimeFromDoc(Elements time) {

        ArrayList<String[]> periodList = new ArrayList();

        Pattern tagPattern = Pattern.compile("<\\s*?td\\b[^>]*>(.*?)<\\/td\\b[^>]*>");
        Matcher m;

        for (int i = 0; i < time.size(); i++) {
            Element t = time.get(i);
            m = tagPattern.matcher(t.toString().trim());
            if (m.find()) {
                System.out.println("Period " + (i + 1) + " : " + m.group(1));
                String[] period = m.group(1).split(" - ");
                periodList.add(period);
            }
        }

        periodList = mergeContinuePeriod(periodList);

        System.out.println("Load Period Done");
        System.out.println("Scheduling Task ...");

        for (int i = 0; i < periodList.size(); i++) {
            scheduleDeviceTask((i + 1), periodList.get(i)[0], periodList.get(i)[1]);
        }

        System.out.println("Scheduling Task Done");
    }

    // Merge 2 continue period
    private static ArrayList mergeContinuePeriod(ArrayList<String[]> list) {

        for (int i = 0; i < list.size(); i++) {
            if (i + 1 < list.size()) {
                if (list.get(i)[1].equals(list.get(i + 1)[0])) {
                    String[] newPeriod = {list.get(i)[0], list.get(i + 1)[1]};
                    list.set(i, newPeriod);
                    list.remove(i + 1);

                    System.out.println("Merge period " + (i + 1) + " & " + (i + 2));
                    System.out.println("New period : " + newPeriod[0] + " - " + newPeriod[1]);
                }
            }
        }
        return list;
    }

    // Load web content Schedule Task Class    
    private static class LoadTimeTask extends TimerTask {

        public LoadTimeTask() {
            System.out.println("Scheduled Load content");
        }

        @Override
        public void run() {
            try {
                getBookedRoom();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Device command Schedule Task Class    
    private static class DeviceTimeTask extends TimerTask {
        
        static Sender s;

        static boolean TURN_ON = true;
        static boolean TURN_OFF = false;

        boolean action = TURN_OFF;

        String time;

        public DeviceTimeTask(boolean action, String time) {
            this.action = action;
            this.time = time;
            System.out.println("Scheduled device cmd to " + (action ? "ON" : "OFF") + " at " + time);
        }

        @Override
        public void run() {
            s = new Sender();
            setStatus(action);
            s.disconnect();
        }

        private void setStatus(boolean action) {
            try {
                for (String c : mqttCmd) {
                    s.send(c, (action ? "ON" : "OFF"));
                }
                Device.upDateStatus(1, action);
                Device.insertTransaction(1, action);
                System.out.println("Turn " + (action ? "ON" : "OFF") + " at " + time + " success");
            } catch (MqttException ex) {
                Logger.getLogger(RoomAlertRunner.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
