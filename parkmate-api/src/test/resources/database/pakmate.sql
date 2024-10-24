CREATE DATABASE IF NOT EXISTS parkmate;

-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: parkmate
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `client_id` binary(16) NOT NULL,
  `active` int NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `portalurl` varchar(255) DEFAULT NULL,
  `version` int NOT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (_binary '\’mm§KLöå|pª\÷m',1,'1234567890','https://mouriteh.com',6),(_binary '(ß\ÏﬁâC+Ñ∫¥\ÿÒFF',1,'1234567890','https://mouriteh.com',4),(_binary 'já˝|@ì°ö6WEh',1,'1234567890','https://mouriteh.com',6),(_binary 'ßK…è6Mi©îûò\»<',1,'1234567890','https://mouriteh.com',5),(_binary '\Íx\÷\—KëX≠\·JÕñ',1,'1234567890','https://mouriteh.com',6),(_binary '\ƒo\"¿\≈Cm≤~a(˛4å',1,'1234567890','https://mouriteh.com',6),(_binary '\ÁEûÖIGéLVÍªôUÅ',1,'1234567890','https://mouriteh.com',6),(_binary 'gÚh+ì\ GØõΩÅv\‚J\ËF',1,'1234567890','https://mouriteh.com',6),(_binary 'tn\ŸV\ÀAtøP\·\œ+U',1,'1234567890','https://mouriteh.com',6),(_binary 'Ö\È¿ñÒD\\ûÅ≤ó0',1,'1234567890','https://mouriteh.com',6),(_binary '±Ñô±)Mñπõ-•',1,'1234567890','https://mouriteh.com',6),(_binary '¥]\Â1í\nH&És\ﬂMBc',1,'1234567890','https://mouriteh.com',3),(_binary 'æ\’D∫•\ƒ@w≠Õ©zõ¢',1,'1234567890','https://mouriteh.com',6),(_binary '¬Æm_\Í@\Îä˛\ﬁ\√^w[\‚',1,'1234567890','https://mouriteh.com',5),(_binary '\Õ*ˆ\ÈjNº≥˝∑ñòO\Œ',1,'456789456789','https://mouriteh.com',2),(_binary '\’2ıÚßEG≠∏E\È”πò\Ì;',1,'1234567890','https://mouriteh.com',1);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client_branding`
--

DROP TABLE IF EXISTS `client_branding`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client_branding` (
  `client_branding_id` binary(16) NOT NULL,
  `value` varchar(255) DEFAULT NULL,
  `client_id` binary(16) NOT NULL,
  PRIMARY KEY (`client_branding_id`),
  KEY `FKd85lth61sggwluuaqgp5t9m5n` (`client_id`),
  CONSTRAINT `FKd85lth61sggwluuaqgp5t9m5n` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_branding`
--

LOCK TABLES `client_branding` WRITE;
/*!40000 ALTER TABLE `client_branding` DISABLE KEYS */;
INSERT INTO `client_branding` VALUES (_binary '`Y\—\Ó0\ﬁKµ≥$`v\\˜^\ÿ','123',_binary '\ÁEûÖIGéLVÍªôUÅ'),(_binary 'v~∆É&®EÆ°…•@å[\Ì˜','123',_binary 'tn\ŸV\ÀAtøP\·\œ+U'),(_binary 'ôÇíV}?I¿É**\Í\œú\∆','123',_binary '±Ñô±)Mñπõ-•'),(_binary '\Œ\‰ú7Z\nE|é´w,\n%\Œ','123',_binary 'já˝|@ì°ö6WEh'),(_binary '\›1!\Ÿ8DMÖìá\ \r\'<\≈','123',_binary '\Íx\÷\—KëX≠\·JÕñ'),(_binary 'Ò,\…\Ì∞O$æ¨)≥\ƒVæ','123',_binary 'gÚh+ì\ GØõΩÅv\‚J\ËF');
/*!40000 ALTER TABLE `client_branding` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client_image`
--

DROP TABLE IF EXISTS `client_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client_image` (
  `client_image_id` binary(16) NOT NULL,
  `image_name` varchar(255) DEFAULT NULL,
  `client_id` binary(16) NOT NULL,
  PRIMARY KEY (`client_image_id`),
  KEY `FKsqwmjetmppi466a894pv5ewlb` (`client_id`),
  CONSTRAINT `FKsqwmjetmppi466a894pv5ewlb` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_image`
--

LOCK TABLES `client_image` WRITE;
/*!40000 ALTER TABLE `client_image` DISABLE KEYS */;
INSERT INTO `client_image` VALUES (_binary '•¨\Èk\ÀDS∞Òh\ﬂ7A7\Î','logo1',_binary '(ß\ÏﬁâC+Ñ∫¥\ÿÒFF'),(_binary 'ºIt<,}K{ã\nßEQΩÑ6','logo2',_binary '(ß\ÏﬁâC+Ñ∫¥\ÿÒFF');
/*!40000 ALTER TABLE `client_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organization`
--

DROP TABLE IF EXISTS `organization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `organization` (
  `organization_id` binary(16) NOT NULL,
  `active` int NOT NULL,
  `parker_profile_approval_required` int NOT NULL,
  `version` int NOT NULL,
  `client_id` binary(16) NOT NULL,
  PRIMARY KEY (`organization_id`),
  KEY `FKmn6y2ox5l6fqt8jmwl57b04wc` (`client_id`),
  CONSTRAINT `FKmn6y2ox5l6fqt8jmwl57b04wc` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organization`
--

LOCK TABLES `organization` WRITE;
/*!40000 ALTER TABLE `organization` DISABLE KEYS */;
INSERT INTO `organization` VALUES (_binary '+\÷‘Æ≤H8ß\Ïò=îB',1,1,100,_binary '(ß\ÏﬁâC+Ñ∫¥\ÿÒFF');
/*!40000 ALTER TABLE `organization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parker_profile`
--

DROP TABLE IF EXISTS `parker_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parker_profile` (
  `parker_profile_id` binary(16) NOT NULL,
  `active` int NOT NULL,
  `contact_email` varchar(255) DEFAULT NULL,
  `contact_phone` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `client_id` binary(16) NOT NULL,
  `organization_id` binary(16) NOT NULL,
  PRIMARY KEY (`parker_profile_id`),
  KEY `FKnalsesw2to7i8f1258mgwrqeb` (`client_id`),
  KEY `FK3xcxqadrybkw5rqc6hin8fliw` (`organization_id`),
  CONSTRAINT `FK3xcxqadrybkw5rqc6hin8fliw` FOREIGN KEY (`organization_id`) REFERENCES `organization` (`organization_id`),
  CONSTRAINT `FKnalsesw2to7i8f1258mgwrqeb` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parker_profile`
--

LOCK TABLES `parker_profile` WRITE;
/*!40000 ALTER TABLE `parker_profile` DISABLE KEYS */;
INSERT INTO `parker_profile` VALUES (_binary 'ùA8\ÔPI[á¢®¢hÇ1',1,'test_adc1c4c19cf4','123','test_e5e97def6756','test_1d8547116a00',_binary '(ß\ÏﬁâC+Ñ∫¥\ÿÒFF',_binary '+\÷‘Æ≤H8ß\Ïò=îB');
/*!40000 ALTER TABLE `parker_profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `product_id` binary(16) NOT NULL,
  `active` int NOT NULL,
  `billing_frequency` enum('HALF_YEARLY','MONTHLY','QUARTERLY','YEARLY') DEFAULT NULL,
  `cost` double NOT NULL,
  `online_purchase` int NOT NULL,
  `client_id` binary(16) NOT NULL,
  PRIMARY KEY (`product_id`),
  KEY `FK3g8nmhhbt7mwbf9r0g5qon8m0` (`client_id`),
  CONSTRAINT `FK3g8nmhhbt7mwbf9r0g5qon8m0` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (_binary 'ìEùÒ¶Fïßπêpô\n: ',1,'QUARTERLY',5.63,1,_binary '(ß\ÏﬁâC+Ñ∫¥\ÿÒFF');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-24 16:14:46
