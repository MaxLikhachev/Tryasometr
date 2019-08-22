-- MySQL dump 10.13  Distrib 8.0.16, for macos10.14 (x86_64)
--
-- Host: localhost    Database: tryasometr
-- ------------------------------------------------------
-- Server version	5.7.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `brands`
--

DROP TABLE IF EXISTS `brands`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `brands` (
                          `id` bigint(20) NOT NULL AUTO_INCREMENT,
                          `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brands`
--

LOCK TABLES `brands` WRITE;
/*!40000 ALTER TABLE `brands` DISABLE KEYS */;
/*!40000 ALTER TABLE `brands` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brands_models`
--

DROP TABLE IF EXISTS `brands_models`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `brands_models` (
                                 `brand_id` bigint(20) NOT NULL,
                                 `models_id` bigint(20) NOT NULL,
                                 UNIQUE KEY `UK_adikx9s3ch75lrtpwo1j5opxu` (`models_id`),
                                 KEY `FKqouigfp87xnktdwg4lldesn3e` (`brand_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brands_models`
--

LOCK TABLES `brands_models` WRITE;
/*!40000 ALTER TABLE `brands_models` DISABLE KEYS */;
/*!40000 ALTER TABLE `brands_models` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cars`
--

DROP TABLE IF EXISTS `cars`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `cars` (
                        `id` bigint(20) NOT NULL AUTO_INCREMENT,
                        `min` float DEFAULT NULL,
                        `year` int(11) DEFAULT NULL,
                        `model_id` bigint(20) DEFAULT NULL,
                        PRIMARY KEY (`id`),
                        KEY `FKrwe6b2vd08hb4gnst223xsna4` (`model_id`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cars`
--

LOCK TABLES `cars` WRITE;
/*!40000 ALTER TABLE `cars` DISABLE KEYS */;
/*!40000 ALTER TABLE `cars` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `hibernate_sequence` (
    `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `holes`
--

DROP TABLE IF EXISTS `holes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `holes` (
                         `id` bigint(20) NOT NULL AUTO_INCREMENT,
                         `factor` float DEFAULT NULL,
                         `latitude` float DEFAULT NULL,
                         `longitude` float DEFAULT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `holes`
--

LOCK TABLES `holes` WRITE;
/*!40000 ALTER TABLE `holes` DISABLE KEYS */;
/*!40000 ALTER TABLE `holes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `models`
--

DROP TABLE IF EXISTS `models`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `models` (
                          `id` bigint(20) NOT NULL,
                          `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
                          `year_from` int(11) DEFAULT NULL,
                          `year_to` int(11) DEFAULT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `models`
--

LOCK TABLES `models` WRITE;
/*!40000 ALTER TABLE `models` DISABLE KEYS */;
/*!40000 ALTER TABLE `models` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sections`
--

DROP TABLE IF EXISTS `sections`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `sections` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT,
                            `factor` float DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sections`
--

LOCK TABLES `sections` WRITE;
/*!40000 ALTER TABLE `sections` DISABLE KEYS */;
/*!40000 ALTER TABLE `sections` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sections_holes`
--

DROP TABLE IF EXISTS `sections_holes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `sections_holes` (
                                  `section_id` bigint(20) NOT NULL,
                                  `holes_id` bigint(20) NOT NULL,
                                  UNIQUE KEY `UK_iu4osbu4bma4da0xagulpr8ac` (`holes_id`),
                                  KEY `FK8kcoewpprdbaj2vdq603fid4c` (`section_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sections_holes`
--

LOCK TABLES `sections_holes` WRITE;
/*!40000 ALTER TABLE `sections_holes` DISABLE KEYS */;
/*!40000 ALTER TABLE `sections_holes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
                         `id` bigint(20) NOT NULL AUTO_INCREMENT,
                         `authorities` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
                         `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
                         `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
                         `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
                         `phone` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
                         `second_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
                         `surname` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
                         `username` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_cars`
--

DROP TABLE IF EXISTS `users_cars`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `users_cars` (
                              `user_data_id` bigint(20) NOT NULL,
                              `cars_id` bigint(20) NOT NULL,
                              UNIQUE KEY `UK_55xrpivj2yxbnadh9kv55t37n` (`cars_id`),
                              KEY `FKksnotn4oijenkmy02ai7nwhoc` (`user_data_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_cars`
--

LOCK TABLES `users_cars` WRITE;
/*!40000 ALTER TABLE `users_cars` DISABLE KEYS */;
/*!40000 ALTER TABLE `users_cars` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vibration`
--

DROP TABLE IF EXISTS `vibration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `vibration` (
                             `id` bigint(20) NOT NULL AUTO_INCREMENT,
                             `factor` float DEFAULT NULL,
                             `latitude` float DEFAULT NULL,
                             `longitude` float DEFAULT NULL,
                             `section_id` bigint(20) DEFAULT NULL,
                             PRIMARY KEY (`id`),
                             KEY `FKp6luqngu8rgwgoirkx0p1wdje` (`section_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vibration`
--

LOCK TABLES `vibration` WRITE;
/*!40000 ALTER TABLE `vibration` DISABLE KEYS */;
/*!40000 ALTER TABLE `vibration` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-12 14:48:36
