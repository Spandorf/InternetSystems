CREATE DATABASE  IF NOT EXISTS `aprokop` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `aprokop`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: cse.unl.edu    Database: aprokop
-- ------------------------------------------------------
-- Server version	5.5.46-MariaDB

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
-- Table structure for table `Amenities`
--

DROP TABLE IF EXISTS `Amenities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Amenities` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(1024) NOT NULL,
  `Description` longtext,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Id_UNIQUE` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Amenities`
--

LOCK TABLES `Amenities` WRITE;
/*!40000 ALTER TABLE `Amenities` DISABLE KEYS */;
INSERT INTO `Amenities` VALUES (1,'Fitness Studio','Workout here.'),(2,'Billiards Table','Come to the clubhouse to play some pool!'),(3,'Tanning Bed','Get ready for summer with a tan.'),(4,'Pool','Cool off in the pool.');
/*!40000 ALTER TABLE `Amenities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ApartmentAmenities`
--

DROP TABLE IF EXISTS `ApartmentAmenities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ApartmentAmenities` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `ApartmentId` int(11) DEFAULT NULL,
  `AmenityId` int(11) DEFAULT NULL,
  `Availability` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Id_UNIQUE` (`Id`),
  KEY `FK_ApartmentAmenities_Amenities_idx` (`AmenityId`),
  KEY `FK_ApartmentAmenities_Apartments_idx` (`ApartmentId`),
  CONSTRAINT `FK_ApartmentAmenities_Amenities` FOREIGN KEY (`AmenityId`) REFERENCES `Amenities` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ApartmentAmenities_Apartments` FOREIGN KEY (`ApartmentId`) REFERENCES `Apartments` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ApartmentAmenities`
--

LOCK TABLES `ApartmentAmenities` WRITE;
/*!40000 ALTER TABLE `ApartmentAmenities` DISABLE KEYS */;
INSERT INTO `ApartmentAmenities` VALUES (1,1,1,1),(2,1,2,1),(3,1,3,1);
/*!40000 ALTER TABLE `ApartmentAmenities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ApartmentCommunityFeatures`
--

DROP TABLE IF EXISTS `ApartmentCommunityFeatures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ApartmentCommunityFeatures` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `ApartmentId` int(11) DEFAULT NULL,
  `CommunityFeatureId` int(11) DEFAULT NULL,
  `Availability` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Id_UNIQUE` (`Id`),
  KEY `FK_ApartmentCommunityFeatures_CommunityFeatures_idx` (`CommunityFeatureId`),
  KEY `FK_ApartmentCommunityFeatures_Apartments_idx` (`ApartmentId`),
  CONSTRAINT `FK_ApartmentCommunityFeatures_Apartments` FOREIGN KEY (`ApartmentId`) REFERENCES `Apartments` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ApartmentCommunityFeatures_CommunityFeatures` FOREIGN KEY (`CommunityFeatureId`) REFERENCES `CommunityFeatures` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ApartmentCommunityFeatures`
--

LOCK TABLES `ApartmentCommunityFeatures` WRITE;
/*!40000 ALTER TABLE `ApartmentCommunityFeatures` DISABLE KEYS */;
INSERT INTO `ApartmentCommunityFeatures` VALUES (1,1,1,NULL),(2,1,2,NULL);
/*!40000 ALTER TABLE `ApartmentCommunityFeatures` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Apartments`
--

DROP TABLE IF EXISTS `Apartments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Apartments` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Landlord` varchar(1024) DEFAULT NULL,
  `AptNumber` varchar(10) DEFAULT NULL,
  `AptType` varchar(10) DEFAULT NULL,
  `Address` mediumtext,
  `City` varchar(1024) DEFAULT NULL,
  `State` varchar(20) DEFAULT NULL,
  `Area` varchar(10) DEFAULT NULL,
  `Bathrooms` varchar(2) DEFAULT NULL,
  `PricePerMonth` decimal(8,2) DEFAULT NULL,
  `ApplicationFee` decimal(4,2) DEFAULT NULL,
  `DamageDeposit` decimal(8,2) DEFAULT NULL,
  `Description` longtext,
  `Availability` tinyint(1) DEFAULT NULL,
  `AvailableDate` date DEFAULT NULL,
  `AgentId` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Id_UNIQUE` (`Id`),
  KEY `FK_Apartments_Users_idx` (`AgentId`),
  CONSTRAINT `FK_Apartments_Users` FOREIGN KEY (`AgentId`) REFERENCES `Users` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Apartments`
--

LOCK TABLES `Apartments` WRITE;
/*!40000 ALTER TABLE `Apartments` DISABLE KEYS */;
INSERT INTO `Apartments` VALUES (1,'John Doe','93','3bd','2820 Fletcher Ave.','Lincoln','Nebraska','100','2',900.00,50.00,600.00,'This is a great apartment in North Lincoln',1,'2016-11-06',2),(2,'John Doe','11','2bd','1122 F St.','Lincoln ','Nebraska','100','1',500.00,20.00,200.00,'This is an apartment',1,NULL,2),(3,'John Doe','12','1bd','1600 Penn','Lincoln ','Nebraska','100','2',1000.00,20.00,200.00,'White house',1,NULL,2),(4,'John John','331','studio','1408 Widow','Lincoln','Nebraska','100','2',800.00,10.00,100.00,'This is a great house!',1,'2016-11-06',2),(5,'John John','332','1bd','1408 Widow','Lincoln','Nebraska','100','2',800.00,10.00,100.00,'This is a great house!',1,'2016-11-06',2),(6,'John John','333','2bd','1408 Widow','Lincoln','Nebraska','100','2',800.00,10.00,100.00,'This is a great house!',1,'2016-11-06',2),(7,'John John','334','3bd','1408 Widow','Lincoln','Nebraska','100','2',800.00,10.00,100.00,'This is a great house!',1,'2016-11-06',2),(8,'John John','335','studio','1408 Widow','Lincoln','Nebraska','100','2',800.00,10.00,100.00,'This is a great house!',1,'2016-11-06',2);
/*!40000 ALTER TABLE `Apartments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Applications`
--

DROP TABLE IF EXISTS `Applications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Applications` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `ApartmentId` int(11) DEFAULT NULL,
  `Status` int(11) DEFAULT NULL COMMENT 'Use this column to check the status of an application (cancelled or activated).',
  `ApplicationNumber` char(12) DEFAULT '000000000000',
  `ApplyingDate` date DEFAULT NULL,
  `ApplicantId` int(11) NOT NULL,
  `MoveInDate` date DEFAULT NULL,
  `LeaseTerm` int(11) DEFAULT NULL,
  `Cost` decimal(8,2) DEFAULT NULL,
  `Notes` longtext COMMENT 'Use this column to put some notes if you need (it is optional).',
  `AgentId` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Id_UNIQUE` (`Id`),
  KEY `FK_Applications_Apartments_idx` (`ApartmentId`),
  KEY `FK_Applications_Users_idx` (`AgentId`),
  CONSTRAINT `FK_Applications_Apartments` FOREIGN KEY (`ApartmentId`) REFERENCES `Apartments` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Applications_Users` FOREIGN KEY (`AgentId`) REFERENCES `Users` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Applications`
--

LOCK TABLES `Applications` WRITE;
/*!40000 ALTER TABLE `Applications` DISABLE KEYS */;
INSERT INTO `Applications` VALUES (11,1,0,'1-1','2016-07-01',1,'2016-07-01',6,50.00,'',1),(14,1,0,'1-2','2016-07-05',5,'2016-07-05',6,650.00,'',1),(15,7,0,'7-1','2016-07-05',1,'2016-07-05',6,110.00,'',1),(16,1,0,'1-3','2016-07-05',1,'2016-07-05',6,650.00,'',1);
/*!40000 ALTER TABLE `Applications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CartItems`
--

DROP TABLE IF EXISTS `CartItems`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CartItems` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `ApartmentId` int(11) NOT NULL,
  `CartId` int(11) NOT NULL,
  `LeaseTerm` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `Id_idx` (`ApartmentId`),
  KEY `CartId_idx` (`CartId`),
  CONSTRAINT `ApartmentId` FOREIGN KEY (`ApartmentId`) REFERENCES `Apartments` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `CartId` FOREIGN KEY (`CartId`) REFERENCES `Carts` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CartItems`
--

LOCK TABLES `CartItems` WRITE;
/*!40000 ALTER TABLE `CartItems` DISABLE KEYS */;
/*!40000 ALTER TABLE `CartItems` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Carts`
--

DROP TABLE IF EXISTS `Carts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Carts` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `UserId` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `Id_idx` (`UserId`),
  CONSTRAINT `Id` FOREIGN KEY (`UserId`) REFERENCES `Users` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Carts`
--

LOCK TABLES `Carts` WRITE;
/*!40000 ALTER TABLE `Carts` DISABLE KEYS */;
INSERT INTO `Carts` VALUES (3,1),(1,5),(2,5);
/*!40000 ALTER TABLE `Carts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CommunityFeatures`
--

DROP TABLE IF EXISTS `CommunityFeatures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CommunityFeatures` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(1024) NOT NULL,
  `Description` longtext,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Id_UNIQUE` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CommunityFeatures`
--

LOCK TABLES `CommunityFeatures` WRITE;
/*!40000 ALTER TABLE `CommunityFeatures` DISABLE KEYS */;
INSERT INTO `CommunityFeatures` VALUES (1,'WIFI','Free WIFI'),(2,'Location','The location is awesome');
/*!40000 ALTER TABLE `CommunityFeatures` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CreditCards`
--

DROP TABLE IF EXISTS `CreditCards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CreditCards` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `CardholderName` varchar(255) NOT NULL,
  `CreditCardNumber` char(20) DEFAULT NULL,
  `Balance` decimal(16,2) DEFAULT NULL,
  `CardType` varchar(45) DEFAULT NULL,
  `UserId` int(11) DEFAULT NULL,
  `CVV` char(3) DEFAULT NULL,
  `ExpirationDate` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Id_UNIQUE` (`Id`),
  KEY `FK_Accounts_Users_idx` (`UserId`),
  CONSTRAINT `FK_Accounts_Users` FOREIGN KEY (`UserId`) REFERENCES `Users` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CreditCards`
--

LOCK TABLES `CreditCards` WRITE;
/*!40000 ALTER TABLE `CreditCards` DISABLE KEYS */;
INSERT INTO `CreditCards` VALUES (1,'steve','steve',1200.00,'visa',5,'111','111111'),(2,'Tony','1',11300.00,'visa',1,'111','2017-3');
/*!40000 ALTER TABLE `CreditCards` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Reviews`
--

DROP TABLE IF EXISTS `Reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Reviews` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `ReviewerName` varchar(255) DEFAULT NULL,
  `ReviewDate` datetime DEFAULT NULL,
  `Rating` tinyint(1) DEFAULT NULL,
  `Review` longtext,
  `ApartmentId` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Id_UNIQUE` (`Id`),
  KEY `FK_Reviews_Apartments_idx` (`ApartmentId`),
  CONSTRAINT `FK_Reviews_Apartments` FOREIGN KEY (`ApartmentId`) REFERENCES `Apartments` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Reviews`
--

LOCK TABLES `Reviews` WRITE;
/*!40000 ALTER TABLE `Reviews` DISABLE KEYS */;
INSERT INTO `Reviews` VALUES (1,'Tony',NULL,4,'Good Apartment',1),(2,'Tony',NULL,5,'Great Apartment',2),(3,'Tony',NULL,3,'Ok Apartment',3);
/*!40000 ALTER TABLE `Reviews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Users`
--

DROP TABLE IF EXISTS `Users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Users` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(45) DEFAULT NULL,
  `LastName` varchar(45) DEFAULT NULL,
  `Address` varchar(45) DEFAULT NULL,
  `City` varchar(45) DEFAULT NULL,
  `State` varchar(45) DEFAULT NULL,
  `PostalCode` varchar(45) DEFAULT NULL,
  `EmailAddress` varchar(45) DEFAULT NULL,
  `PhoneNumber` varchar(15) DEFAULT NULL,
  `Birthday` varchar(15) DEFAULT NULL,
  `Type` tinyint(1) DEFAULT NULL,
  `Status` tinyint(2) DEFAULT NULL COMMENT 'Use this column to set the state of the user if needed. Optional.',
  `NumOfVisits` int(4) DEFAULT NULL COMMENT 'Use this column to keep track of users visits. Optional.',
  `Username` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Id_UNIQUE` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Users`
--

LOCK TABLES `Users` WRITE;
/*!40000 ALTER TABLE `Users` DISABLE KEYS */;
INSERT INTO `Users` VALUES (1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Tony','Tony'),(2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Test','plswork'),(3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'TonyProkop','Tony'),(4,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'NewUser','new'),(5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'steve','stephen');
/*!40000 ALTER TABLE `Users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-05 23:30:50
