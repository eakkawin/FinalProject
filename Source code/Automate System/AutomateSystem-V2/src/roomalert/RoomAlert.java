/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roomalert;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author user
 */
public class RoomAlert {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Version 3.0");
        boolean status = false;
        while (true) {
            try {
                System.out.println("New Day : " + new Date(116, 9, 21, 8, 0));
                //System.out.println(Ztime);
                String[] parameter = Subdate.subDate(); // return array size 3 วัน เดือน ปี ต่ำแหน่งที่ 0 คือวัน ต่ำแหน่งที่ 1 คือ เดือน ต่ำแหน่งที่ 3 คือปี 
                /*  String url = "https://webapp1.sit.kmutt.ac.th/booking/web/day.php?day=" + parameter[0] + "&month=" + parameter[1] + 
                "&year=" + parameter[2]+"&area="+1; // area 1 = sit floor 1 , area 2 = cb 2 */
                parameter[2] += 543;
                String search = "https://webapp1.sit.kmutt.ac.th/booking/web/report.php?"
                        + "From_day=" + parameter[0]
                        + "&From_month=" + parameter[1]
                        + "&From_year=" + parameter[2]
                        + "&To_day=" + parameter[0]
                        + "&To_month=" + parameter[1]
                        + "&To_year=" + parameter[2]
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

                System.out.println(search);
                Document doc = Jsoup.connect(search).post();
                // System.out.println(doc.toString());
                Elements time = doc.getElementsByClass("BR");
                Elements desc = doc.getElementsByClass("BL");
                ArrayList<String> timers = new ArrayList<String>();

                for (Element e : time) {
                    String k = e + "";
                    timers.add(k.substring(k.indexOf(parameter[2]) + parameter[2].length() + 1, k.indexOf(" -") + 1).trim());
                    // timers.add(k);
                }
                ArrayList<String> end = new ArrayList<String>();
                //  int count = 0 ;
                for (Element ee : time) {
                    String k = ee + "";
                    end.add(k.substring(k.lastIndexOf(parameter[2]) + parameter[2].length() + 1, k.indexOf("</td>")).trim());
                    //   count++;
                    //end.add(k);
                }

                ArrayList<Date> startTime = new ArrayList<>();
                for (String k : timers) {
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                    startTime.add(sdf.parse(k));
                }
                ArrayList<Date> endTime = new ArrayList<>();
                for (String w : end) {
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                    endTime.add(sdf.parse(w));
                }
                List<String> CMD = Device.getCMD(1);
                /*  for(Date d : endTime){
               System.out.println(d);
           }*/
                //     System.out.println(turntoDate(getNowHours()));
                //   System.out.println(startTime.get(0));

                boolean isStudy = false;
                //System.out.println("Now :"+getNow().getTime());
                for (int i = 0; i <= startTime.size() - 1; i++) {

                    if (turntoDate(getNowHours()).after(startTime.get(i))) {
                        System.out.println(turntoDate(getNowHours()).before(startTime.get(i)));
                        if (turntoDate(getNowHours()).before(endTime.get(i))) {

                            if (i == 0) {
                                if (isStudy == false) {
                                    isStudy = true;
                                }
                                for (String c : CMD) {
                                    Sender s = new Sender();
                                    s.send(c, "ON");
                                }
                                Device.upDateStatus(1, isStudy);
                                Device.insertTransaction(1, isStudy);

                                System.out.println("In Class");
                            } else {
                                System.out.println("Class Continues : " + new Date());
                            }
                            do {
                                Thread.sleep(1000 * 3);
                            } while (!(turntoDate(getNowHours()).equals(endTime.get(i)) || turntoDate(getNowHours()).after(endTime.get(i))));
                            //   Thread.sleep(Math.abs(endTime.get(i).getTime()-turntoDate(getNowHours()).getTime()));
                            System.out.println("Class End : " + new Date());
                        } else {
                            // if(turntoDate(getNowHours()).after(startTime.get(i)) && turntoDate(getNowHours()).before(endTime.get(i))){
                            //do{
                            //      Thread.sleep(1000*10);
                            //   }while( !(turntoDate(getNowHours()).equals(endTime.get(i))  || turntoDate(getNowHours()).after(endTime.get(i))));
                            //  System.out.println("Class End : "+new Date());
                            //  }else{
                            continue;
                            //   }
                            //System.out.println(turntoDate(getNowHours()));
                            //System.out.println(endTime.get(i));
                        }
                    } else if (turntoDate(getNowHours()).before(startTime.get(i))) {
                        if (isStudy == true) {
                            isStudy = false;
                        }
                        for (String c : CMD) {
                            Sender s = new Sender();
                            s.send(c, "OFF");
                        }
                        System.out.println("Now OFF :" + turntoDate(getNowHours()));
                        System.out.println("startTime : " + startTime.get(i));
                        Device.upDateStatus(1, isStudy);
                        Device.insertTransaction(1, isStudy);

                        System.out.println("waiting for class");
                        do {
                            Thread.sleep(1000 * 3);
                        } while (!(turntoDate(getNowHours()).equals(startTime.get(i)) || turntoDate(getNowHours()).after(startTime.get(i))));
                        //Thread.sleep(Math.abs(startTime.get(i).getTime()-turntoDate(getNowHours()).getTime())); 

                        System.out.println("Class Begin : " + new Date());
                        if (isStudy == false) {
                            isStudy = true;
                        }
                        for (String c : CMD) {
                            Sender s = new Sender();
                            s.send(c, "ON");
                        }
                        Device.upDateStatus(1, isStudy);
                        Device.insertTransaction(1, isStudy);

                        do {
                            Thread.sleep(1000 * 3);
                        } while (!(turntoDate(getNowHours()).equals(endTime.get(i)) || turntoDate(getNowHours()).after(endTime.get(i))));

                        //Thread.sleep(Math.abs(endTime.get(i).getTime()-turntoDate(getNowHours()).getTime()));
                        System.out.println("Class End : " + new Date());

                    }

                }
                System.out.println("End of Today");
                do {
                    Thread.sleep(1000 * 3);
                } while (!turntoDate(getNowHours()).after(turntoDate("22:00:00")));
                System.out.println("Before next day : " + new Date());
                Thread.sleep(1000 * 60 * 60 * 3);

                /*
                        System.out.println(Math.abs(convertToTime(end.get(0)).getTime()-convertToTime(timers.get(0)).getTime()));
                System.out.println("Test Begin at :: "+new Date());
                //System.out.println(convertToTime(timers.get(0)));
                      
               for(int i = 0 ; i <= timers.size()-1;i++ ){
                   if(getNow().getTime() > (convertToTime(timers.get(i))).getTime()){
                       continue;
                   }else{
                       Thread.sleep(Math.abs(convertToTime(timers.get(i)).getTime()-getMillisecondNow()));
                       System.out.println("class begin at :"+new Date());
                       Thread.sleep(Math.abs(convertToTime(end.get(i)).getTime()-convertToTime(timers.get(i)).getTime()));
                       System.out.println("class end at :"+new Date());
                   }
               }
                System.out.println("End of Today");
                Thread.sleep(Math.abs(Ztime-getMillisecondNow()));
                //-------------------------------------------------//
            } catch (IOException e) {
                System.out.println(e);
                 */
 /*
            } catch (InterruptedException ex) {
                System.out.println(ex);
                 */
            } catch (ParseException ex) {
                System.out.println(ex);
            } catch (IOException ex) {
                System.out.println(ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(RoomAlert.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MqttException ex) {
                Logger.getLogger(RoomAlert.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public static String getNowHours() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(new Date());

    }

    public static java.util.Date convertToTime(String time) {
        try {

            SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss"); //if 24 hour format
            java.util.Date d1 = (java.util.Date) format.parse(time);
            return d1;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static Date turntoDate(String pattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.parse(pattern);
    }

    public static long getZeroTime() throws ParseException {
        try {

            SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss"); //if 24 hour format
            java.util.Date d1 = (java.util.Date) format.parse("24:00:00");
            return d1.getTime();
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public static long getMillisecondNow() throws ParseException {

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return ((java.util.Date) sdf.parse(sdf.format(cal.getTime()) + "")).getTime();

    }

    public static java.util.Date getNow() throws ParseException {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return (java.util.Date) sdf.parse(sdf.format(cal.getTime()));
    }

}
