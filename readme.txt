Basic  Software Install - Web Controller and Automate Controller

-	Apache tomcat - Webserver Service
-	MySQL - Database Service
-	MQTT broker server - MQTT exchange message service

覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧

ｵﾔｴｵﾑ鬧 Server OS

-	raspberry pi 
-	windows server

覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧

Raspberry Pi ,Windows Server

ｷﾓ｡ﾒﾃ､ﾔｴｵﾑ鬧 MQTT broker , MySQL , Apache Tomcat
ｵﾑ鬧 IP 耆鱆｡� Server

port ｷﾕ襍鯱ｧ罨鬢ﾗﾍ 
3306 - MySQL
1883 - MQTT message
80 , 8080 - HTTP

覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧

ｷﾓ｡ﾒﾃ Install MQTT Broker 狎ﾗ靉狃郢ｵﾑﾇ｡ﾅﾒｧ羯｡ﾒﾃ眷｡狃ﾅﾕ霙ｹ｢鯱､ﾇﾒﾁﾃﾐﾋﾇ靨ｧﾍﾘｻ｡ﾃｳ�

- Windows Server

	ｴﾒﾇｹ�簍ﾅｴ file installer ｷﾕ�
	http://mosquitto.org/download/

- Raspberry Pi

	sudo apt-get update
	sudo apt-get upgrade
	sudo apt-get install mosquitto

覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧

ｷﾓ｡ﾒﾃ Install MySQL 狎ﾗ靉ｷﾓ ｰﾒｹ｢鯱ﾁﾙﾅ爍郤｢鯱ﾁﾙﾅ｢ﾍｧﾍﾘｻ｡ﾃｳ� ,Log ｢鯱ﾁﾙﾅｵ靨ｧ豬ﾑ鬧

- Windows Server

	ｴﾒﾇｹ�簍ﾅｴ file installer ｷﾕ�
	https://dev.mysql.com/downloads/windows/

- Raspberry Pi

	sudo apt-get update
	sudo apt-get upgrade
	sudo apt-get install mysql-server 庸ix-missing  //ｷﾓ｡ﾃﾐｺﾇｹ｡ﾒﾃｵﾒﾁｷﾕ陲ﾖ鮖ﾁﾒ羯ｨﾍ睫ｴｧｼﾅ
｡ﾒﾃｨﾑｴ犒ﾃﾕﾂﾁ file .war ｡靉ｹｹﾓ莉 deploy ｺｹ web server (Tomcat)
 - 耆鮃ﾓ｡ﾒﾃ狃ﾅﾕ霙ｹ user, password 眷ﾐ ip address ｷﾕ鞨ﾃﾒｵﾑ鬧､靨萇鮗ｹ server ｴ鯢ﾂ｡ﾒﾃ狃ﾔｴ篏ﾃ爲､ｴ鯢ﾂ netbean 眷鯢ｷﾓ｡ﾒﾃ癸鱠｢羯菫ﾅ� config  Database 眷ﾐ癸鱠｢ MQTT server IP 耆魴ﾃｧ｡ﾑｺｷﾕ鞨ﾃﾒｵﾑ鬧､靨萇魴ﾍｹｵ鮖
	- Database 狃ﾅﾕ霙ｹ羯菫ﾅ�羯 Path : ../src/java/hibernate.cfg.xml
	- MQTT 狃ﾅﾕ霙ｹｷﾕ� sender.java

 ｨﾒ｡ｹﾑ鮖ｷﾓ｡ﾒﾃ Build Project 狎ﾗ靉ﾊﾃ鰓ｧ菫ﾅ� .WAR

覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧

ｷﾓ｡ﾒﾃ Install Apache Tomcat 狎ﾗ靉耆鬧ﾒｹ狃郢 Web Server

- Windows Server

	ｴﾒﾇｹ�簍ﾅｴ file installer ｷﾕ�
	http://tomcat.apache.org/download-80.cgi

- Raspberry Pi

	sudo apt-get update
	sudo apt-get upgrade
	sudo apt-get install oracle-java7-jdk   //狎ﾗ靉ｷﾓ｡ﾒﾃｵﾔｴｵﾑ鬧 Java 羯 Raspberry Pi
	sudo apt-get install apache2 //狎ﾗ靉ｷﾓ｡ﾒﾃｵﾔｴｵﾑ鬧 Apache tomcat ｵﾒ｡ｹﾑ鮖ｷﾓ｡ﾒﾃｵﾑ鬧 User 眷ﾐ Password 羯 File Config 狎ﾗ靉爐鰓罨鬧ﾒｹｺｹ Web interface

覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧�

狠ﾗ靉 install apache tomcat 眷鯢 ｹﾓ菫ﾅ� .war upload ﾅｧ莉狎ﾗ靉狹ﾔ霖罨鬧ﾒｹ web controller


覧覧覧覧覧覧覧覧 End Basic Software Install 覧覧覧覧覧覧覧�

Basic Hardware Install 

-	Arduino

覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧�

ｵﾔｴｵﾑ鬧 Arduino IDE 狎ﾗ靉ｷﾓ｡ﾒﾃ癸鱠｢ Code 

ｴﾒﾇｹ�簍ﾅｴ Software 莇鮃ﾕ� https://www.arduino.cc/en/main/software
 
狃ﾔｴ菫ﾅ� ../Arduino/mqtt_control.ino

ｷﾓ｡ﾒﾃ癸鱠｢ IP 耆魴ﾃｧ｡ﾑｺ Server ｷﾕ鞨ﾃﾒ莇鮃ﾓ｡ﾒﾃｵﾑ鬧萇鬚鰓ｧｵ鮖
ｨﾒ｡ｹﾑ鮖ｷﾓ｡ﾒﾃｵ靉 Arduino MEGA 爐鰓｡ﾑｺ､ﾍﾁｾﾔﾇ犒ﾍﾃ�眷鯢ｷﾓ｡ﾒﾃ Upload Code ﾅｧ莉ﾂﾑｧ Board
