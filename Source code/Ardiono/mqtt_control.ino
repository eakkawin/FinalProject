#include <PubSubClient.h>
#include <SPI.h>
#include <Ethernet.h>
#include <Udp.h>
#include <SoftwareSerial.h>
#include <IRremote.h>

IRsend irsend;
#define MQTT_SERVER "171.101.237.226"

//Digital I/O Register
int pin22 = 22;
int pin23 = 23;
int pin24 = 24;
int pin25 = 25;
int pin26 = 26;
int pin27 = 27;
int pin28 = 28;
int pin29 = 29;
int pin30 = 30;
int pin31 = 31;
int pin32 = 32;
int pin33 = 33;
int pin34 = 34;
int pin35 = 35;
int pin36 = 36;



int localPort = 8888;


//Network Register
byte mac[]    = { 0xDE, 0xED, 0xBA, 0xFE, 0xFE, 0xED };

//Server Address

//IPAddress server(192, 168, 1, 41);
//Wake On lan Traget (MAC address)
byte wolMac[] = {0xE8, 0x9A, 0x8F, 0x1E, 0xD7, 0x68};
IPAddress targetIp(255, 255, 255, 255);
int targetPort = 9;

// An EthernetUDP instance to let us send and receive packets over UDP
EthernetUDP Udp;

//Other

String toString(byte* payload, unsigned int length);
String msg;

void callback(char* topic, byte* payload, unsigned int length) {
  Serial.print("Message arrived [");
  Serial.print(topic);
  msg = toString(payload, length);
  Serial.print("] ");

  //Check Payload in Byte
  // for (int i = 0; i < length; i++) {
  //  Serial.print((char)payload[i]);
  // }

  msg = toString(payload, length);
  Serial.println("message is " + msg + " ");
  Serial.println(msg);
  deviceCMD(topic);
  Serial.println();
  
}

EthernetClient ethClient;
PubSubClient client(ethClient);

void reconnect() {
  while (!client.connected()) {
    Serial.print("Attempting MQTT connection...");
    if (client.connect("arduinoClient")) {
      Serial.println("connected");
      //Public Setup
      IPAddress ipAddress = Ethernet.localIP();
      char buf[16];
      sprintf(buf, "%d.%d.%d.%d", ipAddress[0], ipAddress[1], ipAddress[2], ipAddress[3]);
      client.publish("SIT/TRAIN1/Arduino/IP", (char*)buf);

      //Subscribe Setup
      //Light
      client.subscribe("SIT/TRAIN1/LIGHT/1/CMD");
      client.subscribe("SIT/TRAIN1/LIGHT/2/CMD");
      client.subscribe("SIT/TRAIN1/LIGHT/3/CMD");
      client.subscribe("SIT/TRAIN1/LIGHT/4/CMD");
      client.subscribe("SIT/TRAIN1/LIGHT/5/CMD");
      client.subscribe("SIT/TRAIN1/LIGHT/6/CMD");
      client.subscribe("SIT/TRAIN1/LIGHT/7/CMD");
      client.subscribe("SIT/TRAIN1/LIGHT/8/CMD");
      client.subscribe("SIT/TRAIN1/LIGHT/9/CMD");
      client.subscribe("SIT/TRAIN1/LIGHT/10/CMD");
      client.subscribe("SIT/TRAIN1/LIGHT/11/CMD");
      client.subscribe("SIT/TRAIN1/LIGHT/12/CMD");
      client.subscribe("SIT/TRAIN1/LIGHT/1-12/CMD");

      //Computer
      client.subscribe("SIT/TRAIN1/COM/1/CMD");
      //Power bar
      client.subscribe("SIT/TRAIN1/PROJ/1/CMD");
      //Air Condition
      client.subscribe("SIT/TRAIN1/AIR/1/CMD");
      client.subscribe("SIT/TRAIN1/AIR/2/CMD");
    } else {
      Serial.print("failed, rc=");
      Serial.print(client.state());
      Serial.println(" try again in 2 seconds");
      delay(2000);
    }
  }
}

void setup() {
  Serial.begin(57600);
  Ethernet.begin(mac);
  client.setServer(MQTT_SERVER, 1883);
  client.setCallback(callback);
  Serial.print("IP : ");
  Serial.println(Ethernet.localIP());
  delay(100);
  pinMode(pin22, OUTPUT);
  delay(10);
  pinMode(pin23, OUTPUT);
  delay(10);
  pinMode(pin24, OUTPUT);
  delay(10);
  pinMode(pin25, OUTPUT);
  delay(10);
  pinMode(pin26, OUTPUT);
  delay(10);
  pinMode(pin27, OUTPUT);
  delay(10);
  pinMode(pin28, OUTPUT);
  delay(10);
  pinMode(pin29, OUTPUT);
  delay(10);
  pinMode(pin30, OUTPUT);
  delay(10);
  pinMode(pin31, OUTPUT);
  delay(10);
  pinMode(pin32, OUTPUT);
  delay(10);
  pinMode(pin33, OUTPUT);
  delay(10);
  pinMode(pin34, OUTPUT);
  delay(10);
  pinMode(pin35, OUTPUT);
  delay(10);
  pinMode(pin36, OUTPUT);
  delay(10);
  
  delay(100);
  Udp.begin(localPort);
  attachInterrupt(0, sendPkt, RISING);
}

void loop()
{
  if (!client.connected()) {
    reconnect();
  }
  client.loop();
}

void deviceCMD(String n) {
  //Light1

  if (n == "SIT/TRAIN1/LIGHT/1/CMD") {
    if (msg.equals("ON") ) {
      digitalWrite(pin22, HIGH);
      client.publish("SIT/TRAIN1/LIGHT/1/STATUS", "Success");
      delay(100);
      client.loop();
    } else {
      if (msg.equals("OFF")) {
        digitalWrite(pin22, LOW);
        client.publish("SIT/TRAIN1/LIGHT/1/STATUS", "Success");
        delay(100);
        client.loop();
      }
    }
  }

  //Light2

  if (n == "SIT/TRAIN1/LIGHT/2/CMD") {
    if (msg.equals("ON") ) {
      digitalWrite(pin23, HIGH);
      client.publish("SIT/TRAIN1/LIGHT/2/STATUS", "Success");
      delay(100);
      client.loop();
    } else {
      if (msg.equals("OFF")) {
        digitalWrite(pin23, LOW);
        client.publish("SIT/TRAIN1/LIGHT/2/STATUS", "Success");
        delay(100);
        client.loop();
      }
    }
  }

  //Light3

  if (n == "SIT/TRAIN1/LIGHT/3/CMD") {
    if (msg.equals("ON") ) {
      digitalWrite(pin24, HIGH);
      client.publish("SIT/TRAIN1/LIGHT/3/STATUS", "Success");
      delay(100);
      client.loop();
    } else {
      if (msg.equals("OFF")) {
        digitalWrite(pin24, LOW);
        client.publish("SIT/TRAIN1/LIGHT/3/STATUS", "Success");
        delay(100);
        client.loop();
      }
    }
  }

  //Light4

  if (n == "SIT/TRAIN1/LIGHT/4/CMD") {
    if (msg.equals("ON") ) {
      digitalWrite(pin25, HIGH);
      client.publish("SIT/TRAIN1/LIGHT/4/STATUS", "Success");
      delay(100);
      client.loop();
    } else {
      if (msg.equals("OFF")) {
        digitalWrite(pin25, LOW);
        client.publish("SIT/TRAIN1/LIGHT/4/STATUS", "Success");
        delay(100);
        client.loop();
      }
    }
  }

  //Light5

  if (n == "SIT/TRAIN1/LIGHT/5/CMD") {
    if (msg.equals("ON") ) {
      digitalWrite(pin26, HIGH);
      client.publish("SIT/TRAIN1/LIGHT/5/STATUS", "Success");
      delay(100);
      client.loop();
    } else {
      if (msg.equals("OFF")) {
        digitalWrite(pin26, LOW);
        client.publish("SIT/TRAIN1/LIGHT/5/STATUS", "Success");
        delay(100);
        client.loop();
      }
    }
  }

  //Light6

  if (n == "SIT/TRAIN1/LIGHT/6/CMD") {
    if (msg.equals("ON") ) {
      digitalWrite(pin27, HIGH);
      client.publish("SIT/TRAIN1/LIGHT/6/STATUS", "Success");
      delay(100);
      client.loop();
    } else {
      if (msg.equals("OFF")) {
        digitalWrite(pin27, LOW);
        client.publish("SIT/TRAIN1/LIGHT/6/STATUS", "Success");
        delay(100);
        client.loop();
      }
    }
  }

  //Light7

  if (n == "SIT/TRAIN1/LIGHT/7/CMD") {
    if (msg.equals("ON") ) {
      digitalWrite(pin28, HIGH);
      client.publish("SIT/TRAIN1/LIGHT/7/STATUS", "Success");
      delay(100);
      client.loop();
    } else {
      if (msg.equals("OFF")) {
        digitalWrite(pin28, LOW);
        client.publish("SIT/TRAIN1/LIGHT/7/STATUS", "Success");
        delay(100);
        client.loop();
      }
    }
  }

  //Light8

  if (n == "SIT/TRAIN1/LIGHT/8/CMD") {
    if (msg.equals("ON") ) {
      digitalWrite(pin29, HIGH);
      client.publish("SIT/TRAIN1/LIGHT/8/STATUS", "Success");
      delay(100);
      client.loop();
    } else {
      if (msg.equals("OFF")) {
        digitalWrite(pin29, LOW);
        client.publish("SIT/TRAIN1/LIGHT/8/STATUS", "Success");
        delay(100);
        client.loop();
      }
    }
  }

  //Light9

  if (n == "SIT/TRAIN1/LIGHT/9/CMD") {
    if (msg.equals("ON") ) {
      digitalWrite(pin30, HIGH);
      client.publish("SIT/TRAIN1/LIGHT/9/STATUS", "Success");
      delay(100);
      client.loop();
    } else {
      if (msg.equals("OFF")) {
        digitalWrite(pin30, LOW);
        client.publish("SIT/TRAIN1/LIGHT/9/STATUS", "Success");
        delay(100);
        client.loop();
      }
    }
  }

  //Light10

  if (n == "SIT/TRAIN1/LIGHT/10/CMD") {
    if (msg.equals("ON") ) {
      digitalWrite(pin31, HIGH);
      client.publish("SIT/TRAIN1/LIGHT/10/STATUS", "Success");
      delay(100);
      client.loop();
    } else {
      if (msg.equals("OFF")) {
        digitalWrite(pin31, LOW);
        client.publish("SIT/TRAIN1/LIGHT/10/STATUS", "Success");
        delay(100);
        client.loop();
      }
    }
  }

  //Light11

  if (n == "SIT/TRAIN1/LIGHT/11/CMD") {
    if (msg.equals("ON") ) {
      digitalWrite(pin32, HIGH);
      client.publish("SIT/TRAIN1/LIGHT/11/STATUS", "Success");
      delay(100);
      client.loop();
    } else {
      if (msg.equals("OFF")) {
        digitalWrite(pin32, LOW);
        client.publish("SIT/TRAIN1/LIGHT/11/STATUS", "Success");
        delay(100);
        client.loop();
      }
    }
  }

  //Light12

  if (n == "SIT/TRAIN1/LIGHT/12/CMD") {
    if (msg.equals("ON") ) {
      digitalWrite(pin33, HIGH);
      client.publish("SIT/TRAIN1/LIGHT/12/STATUS", "Success");
      delay(100);
      client.loop();
    } else {
      if (msg.equals("OFF")) {
        digitalWrite(pin33, LOW);
        client.publish("SIT/TRAIN1/LIGHT/12/STATUS", "Success");
        delay(100);
        client.loop();
      }
    }
  }



  if (n == "SIT/TRAIN1/LIGHT/1-12/CMD") {
    if (msg.equals("ON") ) {
      digitalWrite(pin22, HIGH);
      delay( 100);
      digitalWrite(pin23, HIGH);
      delay( 100);
      digitalWrite(pin24, HIGH);
      delay( 100);
      digitalWrite(pin25, HIGH);
      delay( 100);
      digitalWrite(pin26, HIGH);
      delay( 100);
      digitalWrite(pin27, HIGH);
      delay( 100);
      digitalWrite(pin28, HIGH);
      delay( 100);
      digitalWrite(pin29, HIGH);
      delay( 100);
      digitalWrite(pin30, HIGH);
      delay( 100);
      digitalWrite(pin31, HIGH);
      delay( 100);
      digitalWrite(pin32, HIGH);
      delay( 100);
      digitalWrite(pin33, HIGH);
      delay( 1000);
      client.publish("SIT/TRAIN1/LIGHT/ALL/STATUS", "Success");
      client.loop();
    } else {
      if (msg.equals("OFF")) {
        digitalWrite(pin22, LOW);
        delay( 1000);
        digitalWrite(pin23, LOW);
        delay( 100);
        digitalWrite(pin24, LOW);
        delay( 100);
        digitalWrite(pin25, LOW);
        delay( 100);
        digitalWrite(pin26, LOW);
        delay( 100);
        digitalWrite(pin27, LOW);
        delay( 100);
        digitalWrite(pin28, LOW);
        delay( 100);
        digitalWrite(pin29, LOW);
        delay( 100);
        digitalWrite(pin30, LOW);
        delay( 100);
        digitalWrite(pin31, LOW);
        delay( 100);
        digitalWrite(pin32, LOW);
        delay( 100);
        digitalWrite(pin33, LOW);
        delay( 100);
         client.publish("SIT/TRAIN1/LIGHT/ALL/STATUS", "Success");
        client.loop();
      }
    }
  }

  
 if (n == "SIT/TRAIN1/PROJ/1/CMD") { 
      projector();
      delay(100);
      client.loop();
  }





  if (n == "SIT/TRAIN1/AIR/1/CMD") {
    if (msg.equals("ON") ) {
      digitalWrite(pin34, HIGH);
      client.publish("SIT/TRAIN1/AIR/1/STATUS", "Success");
      delay( 100);
      client.loop();
    } else {
      if (msg.equals("OFF")) {
        digitalWrite(pin34, LOW);
        client.publish("SIT/TRAIN1/AIR/1/STATUS", "Success");
        delay(100);
        client.loop();
      }
    }
  }

  if (n == "SIT/TRAIN1/AIR/2/CMD") {
    if (msg.equals("ON") ) {
      digitalWrite(pin35, HIGH);
      client.publish("SIT/TRAIN1/AIR/2/STATUS", "Success");
      delay(100);
      client.loop();
    } else {
      if (msg.equals("OFF")) {
        digitalWrite(pin35, LOW);
        client.publish("SIT/TRAIN1/AIR/2/STATUS", "Success");
        delay(100);
        client.loop();
      }
    }
  }

  if (n == "SIT/TRAIN1/AIR/ALL/CMD") {
    if (msg.equals("ON") ) {
      digitalWrite(pin34, HIGH);
      delay(10);
      digitalWrite(pin35, HIGH);
      client.publish("SIT/TRAIN1/AIR/ALL/STATUS", "Success");
      delay(100);
      client.loop();
    } else {
      if (msg.equals("OFF")) {
        digitalWrite(pin34, LOW);
        delay(10);
        digitalWrite(pin35, LOW);
        client.publish("SIT/TRAIN1/AIR/ALL/STATUS", "Success");
        delay(100);
        client.loop();
      }
    }
  }


  //Power Bar

  if (n == "SIT/TRAIN1/PWBAR/1/CMD") {
    if (msg.equals("ON") ) {
      digitalWrite(pin36, HIGH);
      client.publish("SIT/TRAIN1/PWBAR/1/STATUS", "Success");
      delay(100);
      client.loop();
    } else {
      if (msg.equals("OFF")) {
        digitalWrite(pin36, LOW);
        client.publish("SIT/TRAIN1/PWBAR/1/STATUS", "Success");
        delay(100);
        client.loop();
      }
    }
  }

  // WOL

  if (n == "SIT/TRAIN1/COM/1/CMD") {
    if (msg.equals("ON")) {
      Serial.println("Starting Computer");
      Serial.print("MAC : ");
      sendPkt();
      delay(200);
      sendPkt();
      Serial.println("Started Computer");
      client.publish("SIT/TRAIN1/COM/1/STATUS", "Success");
      client.loop();
    }
  }



}//END

String toString(byte* payload, unsigned int length) {
  int i = 0;
  char buff[length + 1];
  for (i = 0; i < length; i++) {
    buff[i] = payload[i];
  }
  buff[i] = '\0';
  String msg = String(buff);
  return msg;
}


void sendPkt() {
  // The 'magic packet' consists of 6 times 0xFF followed by 16 times
  // the hardware address (MAC).

  byte all[102];
  int i, c1, j = 0;

  for (i = 0; i < 6; i++, j++) {
    all[j] = 0xFF;
  }
  for (i = 0; i < 16; i++) {
    for ( c1 = 0; c1 < 6; c1++, j++)
      all[j] = wolMac[c1];
  }

  for ( c1 = 0; c1 < 6; c1++) {
    Serial.print(wolMac[c1], HEX);
    if (c1 < 5) {
      Serial.print(":");
    }
  }

  Serial.println();

  Udp.beginPacket(targetIp, targetPort);
  byte result = Udp.write(all, 102);
  Udp.endPacket();
  // Serial.println(result);
}

void projector() {
  
    irsend.sendNEC(0xC40BF, 32); // Device
      delay(2000);
      irsend.sendNEC(0xC40BF, 32); 
      client.publish("SIT/TRAIN1/PROJ/1/STATUS", "Success");
}








