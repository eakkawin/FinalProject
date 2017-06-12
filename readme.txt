Basic  Software Install - Web Controller and Automate Controller

-	Apache tomcat - Webserver Service
-	MySQL - Database Service
-	MQTT broker server - MQTT exchange message service

——————————————————————————————————————————

ติดตั้ง Server OS

-	raspberry pi 
-	windows server

——————————————————————————————————————————

Raspberry Pi ,Windows Server

ทำการคิดตั้ง MQTT broker , MySQL , Apache Tomcat
ตั้ง IP ให้แก่ Server

port ที่ต้องใช้คือ 
3306 - MySQL
1883 - MQTT message
80 , 8080 - HTTP

——————————————————————————————————————————

ทำการ Install MQTT Broker เพื่อเป็นตัวกลางในการแลกเปลี่ยนข้อความระหว่างอุปกรณ์

- Windows Server

	ดาวน์โหลด file installer ที่
	http://mosquitto.org/download/

- Raspberry Pi

	sudo apt-get update
	sudo apt-get upgrade
	sudo apt-get install mosquitto

——————————————————————————————————————————

ทำการ Install MySQL เพื่อทำ ฐานข้อมูลเก็บข้อมูลของอุปกรณ์ ,Log ข้อมูลต่างๆตั้ง

- Windows Server

	ดาวน์โหลด file installer ที่
	https://dev.mysql.com/downloads/windows/

- Raspberry Pi

	sudo apt-get update
	sudo apt-get upgrade
	sudo apt-get install mysql-server —fix-missing  //ทำกระบวนการตามที่ขึ้นมาในจอแสดงผล
การจัดเตรียม file .war ก่อนนำไป deploy บน web server (Tomcat)
 - ให้ทำการเปลี่ยน user, password และ ip address ที่เราตั้งค่าไว้บน server ด้วยการเปิดโปรเจคด้วย netbean แล้วทำการแก้ไขในไฟล์ config  Database และแก้ไข MQTT server IP ให้ตรงกับที่เราตั้งค่าไว้ตอนต้น
	- Database เปลี่ยนในไฟล์ใน Path : ../src/java/hibernate.cfg.xml
	- MQTT เปลี่ยนที่ sender.java

 จากนั้นทำการ Build Project เพื่อสร้างไฟล์ .WAR

——————————————————————————————————————————

ทำการ Install Apache Tomcat เพื่อให้งานเป็น Web Server

- Windows Server

	ดาวน์โหลด file installer ที่
	http://tomcat.apache.org/download-80.cgi

- Raspberry Pi

	sudo apt-get update
	sudo apt-get upgrade
	sudo apt-get install oracle-java7-jdk   //เพื่อทำการติดตั้ง Java ใน Raspberry Pi
	sudo apt-get install apache2 //เพื่อทำการติดตั้ง Apache tomcat ตากนั้นทำการตั้ง User และ Password ใน File Config เพื่อเข้าใช้งานบน Web interface

———————————————————————————————————————————

เมื่อ install apache tomcat แล้ว นำไฟล์ .war upload ลงไปเพื่อเริ่มใช้งาน web controller


———————————————— End Basic Software Install ———————————————

Basic Hardware Install 

-	Arduino

———————————————————————————————————————————

ติดตั้ง Arduino IDE เพื่อทำการแก้ไข Code 

ดาวน์โหลด Software ได้ที่ https://www.arduino.cc/en/main/software
 
เปิดไฟล์ ../Arduino/mqtt_control.ino

ทำการแก้ไข IP ให้ตรงกับ Server ที่เราได้ทำการตั้งไว้ข้างต้น
จากนั้นทำการต่อ Arduino MEGA เข้ากับคอมพิวเตอร์แล้วทำการ Upload Code ลงไปยัง Board
