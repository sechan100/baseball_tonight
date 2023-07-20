CREATE DATABASE  IF NOT EXISTS `reservation` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `reservation`;
-- MySQL dump 10.13  Distrib 8.0.33, for macos13 (x86_64)
--
-- Host: localhost    Database: reservation
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `games`
--

DROP TABLE IF EXISTS `games`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `games` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `stadium` varchar(45) NOT NULL,
  `dateAndTime` datetime NOT NULL,
  `premium` int DEFAULT '264',
  `table` int DEFAULT '502',
  `blue` int DEFAULT '2373',
  `red` int DEFAULT '6399',
  `navy` int DEFAULT '10112',
  `green` int DEFAULT '5813',
  `opponent_club_num` int DEFAULT NULL,
  `home_club_num` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `games`
--

LOCK TABLES `games` WRITE;
/*!40000 ALTER TABLE `games` DISABLE KEYS */;
INSERT INTO `games` VALUES (10,'두산 베어스 vs 한화 이글스','대전 한화생명 이글스파크','2023-08-01 18:30:00',264,502,2373,6399,10112,5813,9,10),(11,'두산 베어스 vs 한화 이글스','대전 한화생명 이글스파크','2023-08-02 18:30:00',264,502,2373,6399,10112,5813,9,10),(12,'두산 베어스 vs 한화 이글스','대전 한화생명 이글스파크','2023-08-03 18:30:00',264,502,2373,6399,10112,5813,9,10),(13,'한화 이글스 vs KIA 타이거즈','KIA 챔피언스필드','2023-08-04 18:30:00',264,502,2373,6399,10112,5813,10,5),(14,'한화 이글스 vs KIA 타이거즈','KIA 챔피언스필드','2023-08-05 18:00:00',264,502,2373,6399,10112,5813,10,5),(15,'한화 이글스 vs KIA 타이거즈','KIA 챔피언스필드','2023-08-06 17:00:00',264,502,2373,6399,10112,5813,10,5),(16,'한화 이글스 vs KT wiz','수원 케이티 위즈 파크','2023-08-08 18:30:00',264,502,2373,6399,10112,5813,10,4),(17,'한화 이글스 vs KT wiz','수원 케이티 위즈 파크','2023-08-09 18:30:00',264,502,2373,6399,10112,5813,10,4),(18,'한화 이글스 vs KT wiz','수원 케이티 위즈 파크','2023-08-10 18:30:00',264,502,2373,6399,10112,5813,10,4),(19,'두산 베어스 vs 한화 이글스','대전 한화생명 이글스파크','2023-08-11 18:30:00',264,502,2373,6399,10112,5813,9,10),(20,'두산 베어스 vs 한화 이글스','대전 한화생명 이글스파크','2023-08-12 18:00:00',264,502,2373,6399,10112,5813,9,10),(21,'두산 베어스 vs 한화 이글스','대전 한화생명 이글스파크','2023-08-13 17:00:00',264,502,2373,6399,10112,5813,9,10),(22,'한화 이글스 vs NC 다이노스','창원 NC 파크','2023-08-15 17:00:00',264,502,2373,6399,10112,5813,10,6),(23,'한화 이글스 vs NC 다이노스','창원 NC 파크','2023-08-16 18:30:00',264,502,2373,6399,10112,5813,10,6),(24,'한화 이글스 vs NC 다이노스','창원 NC 파크','2023-08-17 18:30:00',264,502,2373,6399,10112,5813,10,6),(25,'KT wiz vs 한화 이글스','대전 한화생명 이글스파크','2023-08-18 18:30:00',264,502,2373,6399,10112,5812,4,10),(26,'KT wiz vs 한화 이글스','대전 한화생명 이글스파크','2023-08-19 18:00:00',264,502,2373,6399,10112,5813,4,10),(27,'KT wiz vs 한화 이글스','대전 한화생명 이글스파크','2023-08-20 17:00:00',264,502,2373,6399,10112,5813,4,10),(28,'삼성 라이온즈 vs 한화 이글스','대전 한화생명 이글스파크','2023-08-22 18:30:00',264,502,2373,6399,10112,5813,7,10),(29,'삼성 라이온즈 vs 한화 이글스','대전 한화생명 이글스파크','2023-08-23 18:30:00',264,502,2373,6399,10112,5813,7,10),(30,'삼성 라이온즈 vs 한화 이글스','대전 한화생명 이글스파크','2023-08-24 18:30:00',264,502,2373,6399,10112,5813,7,10),(31,'한화 이글스 vs KIA 타이거즈','KIA 챔피언스필드','2023-08-25 18:30:00',264,502,2373,6399,10112,5813,10,5),(32,'한화 이글스 vs KIA 타이거즈','KIA 챔피언스필드','2023-08-26 18:00:00',264,502,2373,6399,10112,5813,10,5),(33,'한화 이글스 vs KIA 타이거즈','KIA 챔피언스필드','2023-08-27 17:00:00',264,502,2373,6399,10112,5813,10,5),(34,'롯데 자이언츠 vs 한화 이글스','대전 한화생명 이글스파크','2023-08-29 18:30:00',264,502,2373,6399,10112,5813,8,10),(35,'롯데 자이언츠 vs 한화 이글스','대전 한화생명 이글스파크','2023-08-30 18:30:00',264,502,2373,6399,10112,5813,8,10),(36,'롯데 자이언츠 vs 한화 이글스','대전 한화생명 이글스파크','2023-08-31 18:30:00',264,502,2373,6399,10111,5813,8,10);
/*!40000 ALTER TABLE `games` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservations`
--

DROP TABLE IF EXISTS `reservations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservations` (
  `reservationID` int NOT NULL AUTO_INCREMENT,
  `gameID` int NOT NULL,
  `seatType` char(7) DEFAULT NULL,
  `seatBlock` int DEFAULT NULL,
  `userID` int DEFAULT NULL,
  PRIMARY KEY (`reservationID`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservations`
--

LOCK TABLES `reservations` WRITE;
/*!40000 ALTER TABLE `reservations` DISABLE KEYS */;
INSERT INTO `reservations` VALUES (2,1,'blue',220,34),(4,1,'green',401,1),(6,1,'premium',0,344),(7,1,'red',219,2),(9,1,'blue',216,304),(10,1,'navy',320,453),(11,1,'table',213,233),(12,1,'navy',304,24),(13,1,'navy',302,3),(14,1,'red',220,1),(16,1,'green',401,1),(17,1,'table',110,2),(18,1,'blue',107,1),(19,1,'blue',107,1),(20,1,'premium',0,1),(21,5,'table',112,2),(23,2,'premium',0,1),(24,2,'table',100,1),(26,3,'red',101,1),(27,2,'navy',334,1),(28,3,'red',101,1),(29,5,'table',110,6),(31,1,'red',101,1),(32,4,'blue',107,1),(33,1,'green',401,1),(35,36,'navy',301,1);
/*!40000 ALTER TABLE `reservations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seats`
--

DROP TABLE IF EXISTS `seats`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seats` (
  `seatType` char(10) NOT NULL,
  `seatBlockScope` varchar(100) DEFAULT NULL,
  `weekdayPrice` int NOT NULL,
  `weekendPrice` int NOT NULL,
  PRIMARY KEY (`seatType`),
  UNIQUE KEY `seatBlockScope_UNIQUE` (`seatBlockScope`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seats`
--

LOCK TABLES `seats` WRITE;
/*!40000 ALTER TABLE `seats` DISABLE KEYS */;
INSERT INTO `seats` VALUES ('blue','107~109, 114~116, 209~211, 216~218',15000,17000),('green','401~422',7000,8000),('navy','301 ~ 334',10000,12000),('premium',NULL,70000,70000),('red','101~106, 117~122, 201~208, 219~226',12000,14000),('table','110~112, 212~215',40000,45000);
/*!40000 ALTER TABLE `seats` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-20  9:32:31
