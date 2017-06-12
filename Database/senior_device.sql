-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: 171.101.237.226    Database: senior
-- ------------------------------------------------------
-- Server version	5.5.52-0+deb8u1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `device`
--

DROP TABLE IF EXISTS `device`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `device` (
  `device_id` int(11) NOT NULL AUTO_INCREMENT,
  `device_name` varchar(45) DEFAULT NULL,
  `status` varchar(3) DEFAULT NULL,
  `room_id` int(11) DEFAULT NULL,
  `mac_address` varchar(45) DEFAULT NULL,
  `CMD` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`device_id`),
  KEY `device_room_FK_idx` (`room_id`),
  CONSTRAINT `device_room_FK` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `device`
--

LOCK TABLES `device` WRITE;
/*!40000 ALTER TABLE `device` DISABLE KEYS */;
INSERT INTO `device` VALUES (1,'Power_Bar_Teacher','OFF',1,NULL,'SIT/TRAIN1/PWBAR/1/CMD'),(2,'Teacher_Computer','OFF',1,NULL,'SIT/TRAIN1/COM/1/CMD'),(3,'Projector','OFF',1,NULL,'SIT/TRAIN1/PROJ/1/CMD'),(4,'Air_Condition_1','OFF',1,NULL,'SIT/TRAIN1/AIR/1/CMD'),(5,'Air_Condition_2','OFF',1,NULL,'SIT/TRAIN1/AIR/2/CMD'),(6,'Light_1','OFF',1,NULL,'SIT/TRAIN1/LIGHT/1/CMD'),(7,'Light_2','OFF',1,NULL,'SIT/TRAIN1/LIGHT/2/CMD'),(8,'Light_3','OFF',1,NULL,'SIT/TRAIN1/LIGHT/3/CMD'),(9,'Light_4','OFF',1,NULL,'SIT/TRAIN1/LIGHT/4/CMD'),(10,'Light_5','OFF',1,NULL,'SIT/TRAIN1/LIGHT/5/CMD'),(11,'Light_6','OFF',1,NULL,'SIT/TRAIN1/LIGHT/6/CMD'),(12,'Light_7','OFF',1,NULL,'SIT/TRAIN1/LIGHT/7/CMD'),(13,'Light_8','OFF',1,NULL,'SIT/TRAIN1/LIGHT/8/CMD'),(15,'Light_9','OFF',1,NULL,'SIT/TRAIN1/LIGHT/9/CMD'),(16,'Light_10','OFF',1,NULL,'SIT/TRAIN1/LIGHT/10/CMD'),(17,'Light_11','OFF',1,NULL,'SIT/TRAIN1/LIGHT/11/CMD'),(18,'Light_12','OFF',1,NULL,'SIT/TRAIN1/LIGHT/12/CMD');
/*!40000 ALTER TABLE `device` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-04 23:51:21
