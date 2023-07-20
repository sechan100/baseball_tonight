CREATE DATABASE  IF NOT EXISTS `baseball_tonight` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `baseball_tonight`;
-- MySQL dump 10.13  Distrib 8.0.33, for macos13 (x86_64)
--
-- Host: localhost    Database: baseball_tonight
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
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `regDate` date NOT NULL,
  `title` char(100) COLLATE utf8mb4_general_ci NOT NULL,
  `body` char(100) COLLATE utf8mb4_general_ci NOT NULL,
  `memberId` int unsigned NOT NULL,
  `hit` int(1) unsigned zerofill NOT NULL,
  `recommend` int(1) unsigned zerofill NOT NULL,
  `parkId` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `parId` (`parkId`),
  CONSTRAINT `article_ibfk_2` FOREIGN KEY (`parkId`) REFERENCES `park_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (9,'2023-07-18','제목4','내용4',1,12,0,1);
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article_reply`
--

DROP TABLE IF EXISTS `article_reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article_reply` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `regDate` date NOT NULL,
  `body` char(100) COLLATE utf8mb4_general_ci NOT NULL,
  `memberId` int unsigned NOT NULL,
  `articleId` int unsigned NOT NULL,
  `recommend` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `articleId` (`articleId`),
  CONSTRAINT `article_reply_ibfk_1` FOREIGN KEY (`articleId`) REFERENCES `article` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article_reply`
--

LOCK TABLES `article_reply` WRITE;
/*!40000 ALTER TABLE `article_reply` DISABLE KEYS */;
/*!40000 ALTER TABLE `article_reply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `park_info`
--

DROP TABLE IF EXISTS `park_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `park_info` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `address` tinytext NOT NULL,
  `food` longtext NOT NULL,
  `traffic_busstop` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `traffic_bus` longtext,
  `traffic_sub` longtext,
  `traffic_parking` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `park_info`
--

LOCK TABLES `park_info` WRITE;
/*!40000 ALTER TABLE `park_info` DISABLE KEYS */;
INSERT INTO `park_info` VALUES (1,'한화생명 이글스파크','대전 중구 대종로 373 (지번) 대사동84-4','빅찹핫도그,\r\n친절한스낵바,\r\n세븐일레븐,\r\n멕시카나치킨,\r\n스트릿츄러스,\r\n허니빈스,\r\n농심가락,\r\n이글스 브루어리,\r\n세븐일레븐,\r\n이글스 브루어리,\r\n스테프핫도그,\r\n스테이인터뷰,\r\n세븐일레븐,\r\n멕시카나치킨,\r\n오수리,\r\n신전떡볶이,\r\n이글스 브루어리,\r\n멕시카나치킨,\r\n세븐일레븐,\r\n장충동왕족발,\r\n푸드공감,\r\n멕시카나치킨,\r\n수리마카롱','한화생명이글스파크(23300), \r\n한화생명이글스파크(21050), \r\n한밭종합운동장(21090)','(일반)809,\r\n(일반)119,\r\n(일반)802,\r\n(일반)513,\r\n(일반)604,\r\n(급행)2,\r\n(외곽)52','',''),(2,'광주 - 기아 챔피언스 필드','광주 북구 서림로 10','CU,\r\n교촌치킨,\r\nXOXO핫도그, \r\n비스트로펍,\r\n마성떡볶이,\r\n스테이크펍,\r\n광주제일햄버고,\r\n빅토리펍','광주 -기아 챔피언스 필드 정류소','풍암16,\r\n일곡38,\r\n운림51,\r\n금남58,\r\n임곡89,\r\n첨단95,\r\n송정98,\r\n지원151','광주 - 기아 챔피언스 필드 정류소','');
/*!40000 ALTER TABLE `park_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-20  9:31:39
