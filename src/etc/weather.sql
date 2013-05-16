-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.61-0+squeeze1


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema weather
--

CREATE DATABASE IF NOT EXISTS weather;
USE weather;

--
-- Definition of table `weather`.`City`
--

DROP TABLE IF EXISTS `weather`.`City`;
CREATE TABLE  `weather`.`City` (
  `idCity` int(11) NOT NULL AUTO_INCREMENT,
  `City` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idCity`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `weather`.`City`
--

/*!40000 ALTER TABLE `City` DISABLE KEYS */;
LOCK TABLES `City` WRITE;
INSERT INTO `weather`.`City` VALUES  (1,'Челябинск');
UNLOCK TABLES;
/*!40000 ALTER TABLE `City` ENABLE KEYS */;


--
-- Definition of table `weather`.`Site`
--

DROP TABLE IF EXISTS `weather`.`Site`;
CREATE TABLE  `weather`.`Site` (
  `idSite` int(11) NOT NULL AUTO_INCREMENT,
  `Site` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idSite`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `weather`.`Site`
--

/*!40000 ALTER TABLE `Site` DISABLE KEYS */;
LOCK TABLES `Site` WRITE;
INSERT INTO `weather`.`Site` VALUES  (1,'Yandex'),
 (2,'openweathermap.org'),
 (3,'Forecast.io');
UNLOCK TABLES;
/*!40000 ALTER TABLE `Site` ENABLE KEYS */;


--
-- Definition of table `weather`.`Weather`
--

DROP TABLE IF EXISTS `weather`.`Weather`;
CREATE TABLE  `weather`.`Weather` (
  `idweather` int(11) NOT NULL AUTO_INCREMENT,
  `City_idCity` int(11) NOT NULL,
  `Site_idSite` int(11) NOT NULL,
  `day` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `temper` decimal(5,2) NOT NULL,
  `typeWeather` varchar(45) NOT NULL,
  `speedWing` decimal(3,1) NOT NULL,
  `degWing` varchar(45) DEFAULT NULL,
  `pressure` decimal(5,1) NOT NULL,
  `humidity` decimal(5,2) NOT NULL,
  `cloudCover` decimal(5,2) DEFAULT NULL,
  `visibility` decimal(5,2) DEFAULT NULL,
  `precipIntensity` decimal(5,2) DEFAULT NULL,
  `dewPoint` decimal(4,2) DEFAULT NULL,
  `ozone` decimal(6,2) DEFAULT NULL,
  PRIMARY KEY (`idweather`),
  KEY `fk_Weather_Site` (`Site_idSite`),
  KEY `fk_Weather_City1` (`City_idCity`),
  CONSTRAINT `fk_Weather_City1` FOREIGN KEY (`City_idCity`) REFERENCES `City` (`idCity`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Weather_Site` FOREIGN KEY (`Site_idSite`) REFERENCES `Site` (`idSite`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `weather`.`Weather`
--

/*!40000 ALTER TABLE `Weather` DISABLE KEYS */;
LOCK TABLES `Weather` WRITE;
INSERT INTO `weather`.`Weather` VALUES  (1,1,1,'2013-05-15 13:30:00','23.00','облачно с прояснениями','5.0','n','1014.0','33.00',NULL,NULL,NULL,NULL,NULL),
 (2,1,2,'2013-05-15 07:30:00','23.00','Clouds','5.0','350','1014.0','33.00',NULL,NULL,NULL,NULL,NULL),
 (3,1,3,'2013-05-15 14:27:56','22.45','Sprinkling','4.5','338','1014.3','0.37','0.43','9.99','0.27','7.15','336.24'),
 (4,1,1,'2013-05-15 14:00:00','22.00','облачно с прояснениями','4.0','n','1014.0','38.00',NULL,NULL,NULL,NULL,NULL),
 (5,1,2,'2013-05-15 08:00:00','22.00','Clouds','4.0','340','1014.0','37.00',NULL,NULL,NULL,NULL,NULL),
 (6,1,3,'2013-05-15 14:46:39','22.41','Sprinkling','4.4','340','1014.2','0.38','0.45','9.99','0.26','7.47','336.46'),
 (7,1,1,'2013-05-16 14:30:00','17.00','облачно с прояснениями','3.0','s','1020.0','63.00',NULL,NULL,NULL,NULL,NULL),
 (8,1,2,'2013-05-16 08:30:00','17.00','Clouds','3.0','0','1020.0','63.00',NULL,NULL,NULL,NULL,NULL),
 (9,1,3,'2013-05-16 15:01:46','16.99','Clear','3.1','167','1018.9','0.63','0.16','9.99','0.00','10.02','340.89'),
 (10,1,1,'2013-05-16 14:30:00','17.00','облачно с прояснениями','3.0','s','1020.0','63.00',NULL,NULL,NULL,NULL,NULL),
 (11,1,2,'2013-05-16 08:30:00','17.00','Clouds','3.0','0','1020.0','63.00',NULL,NULL,NULL,NULL,NULL),
 (12,1,3,'2013-05-16 15:17:14','17.91','Clear','2.0','169','1018.8','0.62','0.15','9.99','0.00','10.62','341.04'),
 (13,1,1,'2013-05-16 15:00:00','18.00','облачно с прояснениями','1.0','s','1020.0','64.00',NULL,NULL,NULL,NULL,NULL),
 (14,1,2,'2013-05-16 08:30:00','17.00','Clouds','3.0','0','1020.0','63.00',NULL,NULL,NULL,NULL,NULL),
 (15,1,3,'2013-05-16 15:22:53','18.07','Clear','2.0','170','1018.8','0.62','0.14','9.99','0.00','10.66','341.09'),
 (16,1,1,'2013-05-16 15:00:00','18.00','облачно с прояснениями','1.0','sw','1020.0','64.00',NULL,NULL,NULL,NULL,NULL),
 (17,1,2,'2013-05-16 08:30:00','17.00','Clouds','3.0','0','1020.0','63.00',NULL,NULL,NULL,NULL,NULL),
 (18,1,3,'2013-05-16 15:28:50','18.24','Clear','2.0','171','1018.7','0.61','0.14','9.99','0.00','10.70','341.15'),
 (19,1,1,'2013-05-16 15:00:00','19.00','переменная облачность','1.0','se','1019.0','58.00',NULL,NULL,NULL,NULL,NULL),
 (20,1,2,'2013-05-16 09:30:00','19.00','Clouds','2.0','0','1019.0','55.00',NULL,NULL,NULL,NULL,NULL),
 (21,1,3,'2013-05-16 16:06:57','19.06','Clear','2.0','170','1018.5','0.56','0.11','9.99','0.00','9.97','341.50'),
 (22,1,1,'2013-05-16 15:00:00','19.00','переменная облачность','1.0','se','1019.0','58.00',NULL,NULL,NULL,NULL,NULL),
 (23,1,2,'2013-05-16 09:30:00','19.00','Clouds','2.0','0','1019.0','55.00',NULL,NULL,NULL,NULL,NULL),
 (24,1,3,'2013-05-16 16:08:47','19.08','Clear','2.0','168','1018.5','0.56','0.11','9.99','0.00','9.97','341.51');
UNLOCK TABLES;
/*!40000 ALTER TABLE `Weather` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
