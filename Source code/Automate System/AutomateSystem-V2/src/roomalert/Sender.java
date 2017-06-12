/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roomalert;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 *
 * @author Mo
 */
public class Sender {

    String topic;
    String content;
    int qos = 2;
    String broker = "tcp://171.101.237.226:1883";
    String clientId = "JavaSample";
    MemoryPersistence persistence = new MemoryPersistence();

    boolean status = true;

    MqttClient sampleClient;
    MqttConnectOptions connOpts;

    public Sender() {
        
        try {            
            sampleClient = new MqttClient(broker, clientId, persistence);
            connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            
            System.out.println("[MQTT] Connecting to broker: " + broker);
            
            sampleClient.connect(connOpts);
            
            if(sampleClient.isConnected()){
                System.out.println("[MQTT] Connected");
            }else{
                System.err.println("[MQTT] Connected Fail");
            }
        } catch (MqttException ex) {
            Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public String topic() {
        return topic;
    }

    public void topic(String topic) {
        this.topic = topic;
    }

    public String content() {
        return content;
    }

    public void content(String content) {
        this.content = content;
    }

    public boolean send(String topic, String content) throws MqttException {
        System.out.println("[MQTT] Publishing message: " + content + " to " + topic);
        MqttMessage message = new MqttMessage(content.getBytes());
        message.setQos(qos);
        sampleClient.publish(topic, message);
        System.out.print(" [OK]");
        return status;
    }
    
    public void disconnect(){
        try {
            sampleClient.disconnect();
        } catch (MqttException ex) {
            Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*    public static Customer findById(int id) {
        Customer cust = null ;
        Connection conn = BuildConnection.getConnection();
        String sqlCmd = "select * from customer where customer_id=?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sqlCmd) ;
            pstm.setInt(1, id) ;
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                cust = new Customer();
                getRow(cust, rs) ;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return cust;
    }
     */
}
