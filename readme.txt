Basic  Software Install - Web Controller and Automate Controller

-	Apache tomcat - Webserver Service
-	MySQL - Database Service
-	MQTT broker server - MQTT exchange message service

������������������������������������������

�Դ��� Server OS

-	raspberry pi 
-	windows server

������������������������������������������

Raspberry Pi ,Windows Server

�ӡ�äԴ��� MQTT broker , MySQL , Apache Tomcat
��� IP ����� Server

port ����ͧ���� 
3306 - MySQL
1883 - MQTT message
80 , 8080 - HTTP

������������������������������������������

�ӡ�� Install MQTT Broker �����繵�ǡ�ҧ㹡���š����¹��ͤ��������ҧ�ػ�ó�

- Windows Server

	��ǹ���Ŵ file installer ���
	http://mosquitto.org/download/

- Raspberry Pi

	sudo apt-get update
	sudo apt-get upgrade
	sudo apt-get install mosquitto

������������������������������������������

�ӡ�� Install MySQL ���ͷ� �ҹ�������红����Ţͧ�ػ�ó� ,Log �����ŵ�ҧ���

- Windows Server

	��ǹ���Ŵ file installer ���
	https://dev.mysql.com/downloads/windows/

- Raspberry Pi

	sudo apt-get update
	sudo apt-get upgrade
	sudo apt-get install mysql-server �fix-missing  //�ӡ�кǹ��õ���������㹨��ʴ���
��èѴ����� file .war ��͹��� deploy �� web server (Tomcat)
 - ���ӡ������¹ user, password ��� ip address �����ҵ�駤����麹 server ���¡���Դ��ਤ���� netbean ���Ƿӡ��������� config  Database ������ MQTT server IP ���ç�Ѻ�����ҵ�駤�����͹��
	- Database ����¹����� Path : ../src/java/hibernate.cfg.xml
	- MQTT ����¹��� sender.java

 �ҡ��鹷ӡ�� Build Project �������ҧ��� .WAR

������������������������������������������

�ӡ�� Install Apache Tomcat �������ҹ�� Web Server

- Windows Server

	��ǹ���Ŵ file installer ���
	http://tomcat.apache.org/download-80.cgi

- Raspberry Pi

	sudo apt-get update
	sudo apt-get upgrade
	sudo apt-get install oracle-java7-jdk   //���ͷӡ�õԴ��� Java � Raspberry Pi
	sudo apt-get install apache2 //���ͷӡ�õԴ��� Apache tomcat �ҡ��鹷ӡ�õ�� User ��� Password � File Config ���������ҹ�� Web interface

�������������������������������������������

����� install apache tomcat ���� ����� .war upload ŧ������������ҹ web controller


���������������� End Basic Software Install ���������������

Basic Hardware Install 

-	Arduino

�������������������������������������������

�Դ��� Arduino IDE ���ͷӡ����� Code 

��ǹ���Ŵ Software ���� https://www.arduino.cc/en/main/software
 
�Դ��� ../Arduino/mqtt_control.ino

�ӡ����� IP ���ç�Ѻ Server ��������ӡ�õ������ҧ��
�ҡ��鹷ӡ�õ�� Arduino MEGA ��ҡѺ�������������Ƿӡ�� Upload Code ŧ��ѧ Board
