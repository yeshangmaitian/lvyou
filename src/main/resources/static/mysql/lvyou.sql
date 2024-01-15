-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: lvyou
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `auser`
--

DROP TABLE IF EXISTS `auser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auser` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `apwd` varchar(15) DEFAULT NULL,
  `aname` varchar(15) DEFAULT NULL,
  `adate` varchar(15) DEFAULT NULL,
  `asalary` int(11) DEFAULT NULL,
  `aother` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`aid`),
  UNIQUE KEY `aid` (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auser`
--

LOCK TABLES `auser` WRITE;
/*!40000 ALTER TABLE `auser` DISABLE KEYS */;
INSERT INTO `auser` VALUES (1,'admin','admin','2022-1-3',22000,'老员工'),(2,'admin1','admin1','2022-10-3',12000,'技术大佬'),(3,'admin2','admin2','2022-9-3',9000,'运营'),(4,'admin3','admin3','2022-11-30',8000,'助理'),(5,'5','5','2022--12-5',5,'无');
/*!40000 ALTER TABLE `auser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manage`
--

DROP TABLE IF EXISTS `manage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `manage` (
  `mnum` int(11) NOT NULL AUTO_INCREMENT,
  `tusernum` int(11) DEFAULT NULL,
  `teamnum` int(11) DEFAULT NULL,
  `manage` varchar(15) DEFAULT NULL,
  `mdate` varchar(15) DEFAULT NULL,
  `mother` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`mnum`),
  UNIQUE KEY `mnum` (`mnum`),
  KEY `manage_tusernum_index` (`tusernum`),
  KEY `manage_tusernum_mnum_index` (`tusernum`,`mnum`),
  KEY `manage_teamnum_fk` (`teamnum`),
  CONSTRAINT `manage_teamnum_fk` FOREIGN KEY (`teamnum`) REFERENCES `team` (`teamnum`),
  CONSTRAINT `manage_tusernum_fk` FOREIGN KEY (`tusernum`) REFERENCES `tuser` (`tnum`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manage`
--

LOCK TABLES `manage` WRITE;
/*!40000 ALTER TABLE `manage` DISABLE KEYS */;
INSERT INTO `manage` VALUES (1,2001,1,'报名','2022-11-23','无'),(2,2002,2,'取消','2022-1-23','无'),(3,2001,1,'报名','2022--12-3','管理员操作'),(4,2002,2,'报名','2022-10-23','无'),(5,2004,1,'取消','2022-11-23','无'),(6,2005,2,'取消','2022-1-23','无'),(7,2006,3,'报名','2022--12-3','无'),(8,2007,4,'取消','2022-10-23','无'),(9,2008,5,'报名','2022-11-23','无'),(10,2009,1,'报名','2022-1-23','无'),(11,2010,2,'取消','2022--12-3','无'),(12,2011,3,'取消','2022-10-23','管理员操作'),(14,2001,5,'取消','2022-1-23','无'),(15,2002,1,'报名','2022--12-3','无'),(16,2001,2,'报名','2022-10-23','无'),(17,2002,3,'取消','2022-11-22','无'),(18,2009,3,'取消','2022-11-32','无'),(19,2010,4,'取消','2022-1-24','无'),(20,2011,5,'报名','2022--12-5','管理员操作'),(21,2012,3,'取消','2022-10-6','无'),(22,2009,4,'报名','2022-11-27','无'),(23,2010,5,'报名','2022-1-27','无'),(24,2011,3,'取消','2022-1-24','管理员操作'),(25,2012,4,'取消','2022--12-5','无'),(26,2001,5,'取消','2022-10-6','管理员操作'),(27,2013,5,'报名','2022--12-4','无'),(28,2013,5,'取消','2022--12-5','无');
/*!40000 ALTER TABLE `manage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `place`
--

DROP TABLE IF EXISTS `place`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `place` (
  `placenum` int(11) NOT NULL AUTO_INCREMENT,
  `placename` varchar(20) DEFAULT NULL,
  `place` varchar(20) DEFAULT NULL,
  `star` int(11) DEFAULT NULL,
  `ticket` decimal(7,2) DEFAULT NULL,
  `placeother` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`placenum`),
  UNIQUE KEY `placenum` (`placenum`),
  KEY `place_placename_index` (`placename`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `place`
--

LOCK TABLES `place` WRITE;
/*!40000 ALTER TABLE `place` DISABLE KEYS */;
INSERT INTO `place` VALUES (1,'西海固','宁南',5,10.00,NULL),(2,'银川','银川',4,4.00,NULL),(3,'固原','固原',3,3.00,'新景点'),(4,'中卫','中卫',4,5.00,NULL),(5,'南华山','海原',4,5.00,NULL),(6,'灵武','灵武',5,10.00,'服务好'),(7,'六盘山','固原',4,4.00,NULL),(8,'红军纪念馆','吴忠',3,3.00,NULL),(9,'科技馆','银川',4,5.00,'免费停车'),(10,'图书馆','银川',4,10.00,NULL),(11,'河东机场','灵武',5,4.00,'有海'),(12,'人民广场','银川',4,3.00,NULL),(13,'六盘高中','银川',3,5.00,'可听课'),(14,'育才高中','银川',4,10.00,'扶贫高中'),(15,'海原大地震','海原',4,4.00,NULL),(16,'西关大寺','海原',5,3.00,'宗教文化历史'),(17,'海拉都广场','海原',4,5.00,NULL),(18,'西湖','海原',4,3.00,'可吃饭'),(19,'海原','海原',4,6.00,NULL),(20,'中宁','中卫',4,6.00,'de');
/*!40000 ALTER TABLE `place` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `route`
--

DROP TABLE IF EXISTS `route`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `route` (
  `routenum` int(11) NOT NULL AUTO_INCREMENT,
  `specialplace` varchar(15) DEFAULT NULL,
  `begin` varchar(15) DEFAULT NULL,
  `end` varchar(15) DEFAULT NULL,
  `longtime` int(11) DEFAULT NULL,
  PRIMARY KEY (`routenum`),
  UNIQUE KEY `routenum` (`routenum`),
  KEY `route_sp_fk` (`specialplace`),
  KEY `route_begin_fk` (`begin`),
  KEY `route_end_fk` (`end`),
  CONSTRAINT `route_begin_fk` FOREIGN KEY (`begin`) REFERENCES `place` (`placename`),
  CONSTRAINT `route_end_fk` FOREIGN KEY (`end`) REFERENCES `place` (`placename`),
  CONSTRAINT `route_sp_fk` FOREIGN KEY (`specialplace`) REFERENCES `place` (`placename`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route`
--

LOCK TABLES `route` WRITE;
/*!40000 ALTER TABLE `route` DISABLE KEYS */;
INSERT INTO `route` VALUES (1,'西海固','中卫','固原',2),(2,'中卫','银川','固原',3),(3,'灵武','灵武','中卫',2),(4,'六盘山','银川','海原',6),(5,'红军纪念馆','固原','灵武',6);
/*!40000 ALTER TABLE `route` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team`
--

DROP TABLE IF EXISTS `team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `team` (
  `teamnum` int(11) NOT NULL AUTO_INCREMENT,
  `teamname` varchar(15) DEFAULT NULL,
  `teamphone` varchar(15) DEFAULT NULL,
  `teamrnum` int(11) DEFAULT NULL,
  `teamother` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`teamnum`),
  UNIQUE KEY `teamnum` (`teamnum`),
  KEY `team_routenum_fk` (`teamrnum`),
  CONSTRAINT `team_routenum_fk` FOREIGN KEY (`teamrnum`) REFERENCES `route` (`routenum`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team`
--

LOCK TABLES `team` WRITE;
/*!40000 ALTER TABLE `team` DISABLE KEYS */;
INSERT INTO `team` VALUES (1,'线路一','13200001111',1,'无'),(2,'线路二','13200000000',2,'春天第一个'),(3,'线路三','13200002222',3,'无'),(4,'线路四','13233330000',4,'无'),(5,'线路五','13211110000',5,'可接送');
/*!40000 ALTER TABLE `team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tuser`
--

DROP TABLE IF EXISTS `tuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tuser` (
  `tnum` int(11) NOT NULL AUTO_INCREMENT,
  `tname` varchar(12) DEFAULT NULL,
  `tpwd` varchar(12) DEFAULT NULL,
  `tsex` varchar(12) DEFAULT NULL,
  `tage` int(11) DEFAULT NULL,
  `tphone` varchar(12) DEFAULT NULL,
  `tephone` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`tnum`),
  UNIQUE KEY `tuser_pk` (`tnum`),
  KEY `tuser__index` (`tnum`)
) ENGINE=InnoDB AUTO_INCREMENT=2015 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tuser`
--

LOCK TABLES `tuser` WRITE;
/*!40000 ALTER TABLE `tuser` DISABLE KEYS */;
INSERT INTO `tuser` VALUES (2001,'张三','张三','男',23,'13200000000','无'),(2002,'李四','李四','女',32,'13200000000','无'),(2003,'王五','王五','男',22,'13200001111','无'),(2004,'张刚','张刚','女',12,'13200000000','无'),(2005,'王磊','王磊','男',23,'13200002222','无'),(2006,'刘郎','刘郎','女',32,'13200000000','无'),(2007,'田野','田野','男',22,'13211110000','无'),(2008,'马槊','马槊','女',12,'13233330000','无'),(2009,'马龙','马龙','男',23,'13200000000','无'),(2010,'马龙','马龙','女',32,'13200004444','无'),(2011,'马蓉','马蓉','男',22,'13200000000','13200000000'),(2012,'刘颖','刘颖','女',12,'13200003333','无'),(2013,'5','5','男',5,'5','5');
/*!40000 ALTER TABLE `tuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'lvyou'
--

--
-- Dumping routines for database 'lvyou'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-25 22:03:01
