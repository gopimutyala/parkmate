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
INSERT INTO `client` VALUES (_binary '\�mm�KL��|p�\�m',1,'1234567890','https://mouriteh.com',6),(_binary '(�\�މC+���\��FF',1,'1234567890','https://mouriteh.com',4),(_binary 'j��|@���6WEh',1,'1234567890','https://mouriteh.com',6),(_binary '�Kɏ6Mi����\�<',1,'1234567890','https://mouriteh.com',5),(_binary '\�x\�\�K�X�\�J͖',1,'1234567890','https://mouriteh.com',6),(_binary '\�o\"�\�Cm�~a(�4�',1,'1234567890','https://mouriteh.com',6),(_binary '\�E��IG�LV껙U�',1,'1234567890','https://mouriteh.com',6),(_binary 'g�h+�\�G����v\�J\�F',1,'1234567890','https://mouriteh.com',6),(_binary 'tn\�V\�At�P\�\�+U',1,'1234567890','https://mouriteh.com',6),(_binary '�\����D\\����0',1,'1234567890','https://mouriteh.com',6),(_binary '����)M���-�',1,'1234567890','https://mouriteh.com',6),(_binary '�]\�1�\nH&�s\�MBc',1,'1234567890','https://mouriteh.com',3),(_binary '�\�D��\�@w�ͩz��',1,'1234567890','https://mouriteh.com',6),(_binary '®m_\�@\��\�\�^w[\�',1,'1234567890','https://mouriteh.com',5),(_binary '\�*�\�jN������O\�',1,'456789456789','https://mouriteh.com',2),(_binary '\�2��EG��E\�ӹ�\�;',1,'1234567890','https://mouriteh.com',1);
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
INSERT INTO `client_branding` VALUES (_binary '`Y\�\�0\�K��$`v\\�^\�','123',_binary '\�E��IG�LV껙U�'),(_binary 'v~ƃ&�E��ɥ@�[\��','123',_binary 'tn\�V\�At�P\�\�+U'),(_binary '���V}?I��**\�\��\�','123',_binary '����)M���-�'),(_binary '\�\�7Z\nE|��w,\n%\�','123',_binary 'j��|@���6WEh'),(_binary '\�1!\�8DM���\�\r\'<\�','123',_binary '\�x\�\�K�X�\�J͖'),(_binary '�,\�\�O$��)�\�V�','123',_binary 'g�h+�\�G����v\�J\�F');
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
INSERT INTO `client_image` VALUES (_binary '��\�k\�DS��h\�7A7\�','logo1',_binary '(�\�މC+���\��FF'),(_binary '�It<,}K{�\n�EQ��6','logo2',_binary '(�\�މC+���\��FF');
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
INSERT INTO `organization` VALUES (_binary '+\�Ԯ�H8�\�=�B',1,1,100,_binary '(�\�މC+���\��FF');
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
INSERT INTO `parker_profile` VALUES (_binary '�A8\�PI[����h�1',1,'test_adc1c4c19cf4','123','test_e5e97def6756','test_1d8547116a00',_binary '(�\�މC+���\��FF',_binary '+\�Ԯ�H8�\�=�B');
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
INSERT INTO `product` VALUES (_binary '�E��F����p�\n: ',1,'QUARTERLY',5.63,1,_binary '(�\�މC+���\��FF');
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
