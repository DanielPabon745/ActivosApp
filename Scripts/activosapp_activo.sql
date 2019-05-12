-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: activosapp
-- ------------------------------------------------------
-- Server version	8.0.16

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
-- Table structure for table `activo`
--

DROP TABLE IF EXISTS `activo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `activo` (
  `serial` int(11) NOT NULL,
  `alto` int(11) NOT NULL,
  `ancho` int(11) NOT NULL,
  `color` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `descripcion` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `estado` int(11) NOT NULL,
  `fecha_baja` date DEFAULT NULL,
  `fecha_compra` date DEFAULT NULL,
  `largo` int(11) NOT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `numero_interno` int(11) NOT NULL,
  `peso` int(11) NOT NULL,
  `tipo` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `valor` int(11) NOT NULL,
  `id_area` int(11) DEFAULT NULL,
  `id_persona` int(11) DEFAULT NULL,
  PRIMARY KEY (`serial`),
  KEY `FKlbqkpikkm48wy3897a7ny6yb4` (`id_area`),
  KEY `FKa5qkdke5t44m32lcn7j2hskp1` (`id_persona`),
  CONSTRAINT `FKa5qkdke5t44m32lcn7j2hskp1` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id_persona`),
  CONSTRAINT `FKlbqkpikkm48wy3897a7ny6yb4` FOREIGN KEY (`id_area`) REFERENCES `area` (`id_area`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activo`
--

LOCK TABLES `activo` WRITE;
/*!40000 ALTER TABLE `activo` DISABLE KEYS */;
INSERT INTO `activo` VALUES (100000,80,160,'Cafe','Escritorio para empleado',1,NULL,'2012-04-14',120,'Escritorio',111236,20,'Mueble',540000,2,NULL),(100001,25,98,'Blanco','Mueble para documentos',5,NULL,'2016-11-30',40,'Organizador',111237,15,'Mueble',256000,3,NULL),(100002,2,30,'Negro','Teclado para computador',3,NULL,'2015-08-11',15,'Teclado',111238,5,'Tecnología',89000,1,NULL),(100003,40,50,'Blanca','Impresora para área',5,NULL,'2017-06-13',76,'Impresora',111239,8,'Tecnología',784000,4,NULL),(100004,80,160,'Gris','Escritorio para empleado',3,NULL,'2011-08-22',125,'Escritorio',111240,20,'Mueble',600000,1,NULL),(100005,90,165,'Blanco','Escritorio para empleado',5,NULL,'2017-02-27',123,'Escritorio',111241,25,'Mueble',658000,1,NULL),(100006,80,178,'Blanco','Escritorio para empleado',5,NULL,'2016-05-19',115,'Escritorio',111242,23,'Mueble',746000,1,NULL),(100007,2,30,'Negro','Computador para empleado',5,NULL,'2016-09-17',15,'Computador',111243,5,'Tecnología',2300000,NULL,406589745),(100008,40,50,'Blanco','Impresora para área',4,NULL,'2014-01-21',76,'Impresora',111244,8,'Tecnología',784000,NULL,754866214),(100009,2,30,'Negro','Teclado para computador',2,NULL,'2014-07-19',15,'Teclado',111245,5,'Tecnología',89000,NULL,754866214),(100010,40,50,'Blanco','Computador para empleado',5,NULL,'2015-12-03',76,'Computador',111246,8,'Tecnología',1865000,NULL,1025487847);
/*!40000 ALTER TABLE `activo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-12 18:16:14
