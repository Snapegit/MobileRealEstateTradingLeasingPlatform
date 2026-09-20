-- MySQL dump 10.13  Distrib 5.7.31, for Linux (x86_64)
--
-- Host: localhost    Database: cl7459339
-- ------------------------------------------------------
-- Server version	5.7.31

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
-- Current Database: `cl7459339`
--

/*!40000 DROP DATABASE IF EXISTS `cl7459339`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `cl7459339` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `cl7459339`;

--
-- Table structure for table `config`
--

DROP TABLE IF EXISTS `config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) DEFAULT NULL COMMENT '配置参数值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='配置文件';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config`
--

LOCK TABLES `config` WRITE;
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
INSERT INTO `config` VALUES (1,'swiper1','file/swiperPicture1.jpg'),(2,'swiper2','file/1704365572413.png'),(3,'swiper3','file/swiperPicture3.jpg');
/*!40000 ALTER TABLE `config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discussfangyuanchushou`
--

DROP TABLE IF EXISTS `discussfangyuanchushou`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discussfangyuanchushou` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `avatarurl` longtext COMMENT '头像',
  `nickname` varchar(200) DEFAULT NULL COMMENT '用户名',
  `content` longtext NOT NULL COMMENT '评论内容',
  `reply` longtext COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='房源出售评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discussfangyuanchushou`
--

LOCK TABLES `discussfangyuanchushou` WRITE;
/*!40000 ALTER TABLE `discussfangyuanchushou` DISABLE KEYS */;
/*!40000 ALTER TABLE `discussfangyuanchushou` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discussfangyuanchuzu`
--

DROP TABLE IF EXISTS `discussfangyuanchuzu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discussfangyuanchuzu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `avatarurl` longtext COMMENT '头像',
  `nickname` varchar(200) DEFAULT NULL COMMENT '用户名',
  `content` longtext NOT NULL COMMENT '评论内容',
  `reply` longtext COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='房源出租评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discussfangyuanchuzu`
--

LOCK TABLES `discussfangyuanchuzu` WRITE;
/*!40000 ALTER TABLE `discussfangyuanchuzu` DISABLE KEYS */;
/*!40000 ALTER TABLE `discussfangyuanchuzu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fangwuleixing`
--

DROP TABLE IF EXISTS `fangwuleixing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fangwuleixing` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `fangwuleixing` varchar(200) NOT NULL COMMENT '房屋类型',
  PRIMARY KEY (`id`),
  UNIQUE KEY `fangwuleixing` (`fangwuleixing`)
) ENGINE=InnoDB AUTO_INCREMENT=1704365215653 DEFAULT CHARSET=utf8 COMMENT='房屋类型';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fangwuleixing`
--

LOCK TABLES `fangwuleixing` WRITE;
/*!40000 ALTER TABLE `fangwuleixing` DISABLE KEYS */;
INSERT INTO `fangwuleixing` VALUES (61,'2024-01-04 10:35:07','房屋类型1'),(62,'2024-01-04 10:35:07','房屋类型2'),(63,'2024-01-04 10:35:07','房屋类型3'),(64,'2024-01-04 10:35:07','房屋类型4'),(65,'2024-01-04 10:35:07','房屋类型5'),(66,'2024-01-04 10:35:07','房屋类型6'),(1704365215652,'2024-01-04 10:46:55','二房一厅');
/*!40000 ALTER TABLE `fangwuleixing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fangyuanchushou`
--

DROP TABLE IF EXISTS `fangyuanchushou`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fangyuanchushou` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `fangwumingcheng` varchar(200) NOT NULL COMMENT '房屋名称',
  `fangwutupian` longtext COMMENT '房屋图片',
  `fangwuleixing` varchar(200) NOT NULL COMMENT '房屋类型',
  `fangwumianji` varchar(200) DEFAULT NULL COMMENT '房屋面积',
  `fangwudizhi` varchar(200) DEFAULT NULL COMMENT '房屋地址',
  `xiaoshoujiage` double NOT NULL COMMENT '销售价格',
  `fangwujieshao` longtext COMMENT '房屋介绍',
  `jingjirenzhanghao` varchar(200) DEFAULT NULL COMMENT '经纪人账号',
  `jingjirenxingming` varchar(200) DEFAULT NULL COMMENT '经纪人姓名',
  `mendian` varchar(200) DEFAULT NULL COMMENT '门店',
  `storeupnum` int(11) DEFAULT NULL COMMENT '收藏数量',
  `dingjin` double DEFAULT NULL COMMENT '定金',
  `zhuangtai` varchar(200) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1704365272812 DEFAULT CHARSET=utf8 COMMENT='房源出售';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fangyuanchushou`
--

LOCK TABLES `fangyuanchushou` WRITE;
/*!40000 ALTER TABLE `fangyuanchushou` DISABLE KEYS */;
INSERT INTO `fangyuanchushou` VALUES (71,'2024-01-04 10:35:07','房屋名称1','file/fangyuanchushouFangwutupian1.jpg,file/fangyuanchushouFangwutupian2.jpg,file/fangyuanchushouFangwutupian3.jpg','房屋类型1','房屋面积1','房屋地址1',1,'房屋介绍1','经纪人账号1','经纪人姓名1','门店1',1,1,'已出售'),(72,'2024-01-04 10:35:07','房屋名称2','file/fangyuanchushouFangwutupian2.jpg,file/fangyuanchushouFangwutupian3.jpg,file/fangyuanchushouFangwutupian4.jpg','房屋类型2','房屋面积2','房屋地址2',2,'<p>房屋介绍2</p>','经纪人账号2','经纪人姓名2','门店2',3,2,'已出售'),(73,'2024-01-04 10:35:07','房屋名称3','file/fangyuanchushouFangwutupian3.jpg,file/fangyuanchushouFangwutupian4.jpg,file/fangyuanchushouFangwutupian5.jpg','房屋类型3','房屋面积3','房屋地址3',3,'房屋介绍3','经纪人账号3','经纪人姓名3','门店3',3,3,'已出售'),(74,'2024-01-04 10:35:07','房屋名称4','file/fangyuanchushouFangwutupian4.jpg,file/fangyuanchushouFangwutupian5.jpg,file/fangyuanchushouFangwutupian6.jpg','房屋类型4','房屋面积4','房屋地址4',4,'房屋介绍4','经纪人账号4','经纪人姓名4','门店4',4,4,'已出售'),(75,'2024-01-04 10:35:07','房屋名称5','file/fangyuanchushouFangwutupian5.jpg,file/fangyuanchushouFangwutupian6.jpg,file/fangyuanchushouFangwutupian7.jpg','房屋类型5','房屋面积5','房屋地址5',5,'房屋介绍5','经纪人账号5','经纪人姓名5','门店5',5,5,'已出售'),(76,'2024-01-04 10:35:07','房屋名称6','file/fangyuanchushouFangwutupian6.jpg,file/fangyuanchushouFangwutupian7.jpg,file/fangyuanchushouFangwutupian8.jpg','房屋类型6','房屋面积6','房屋地址6',6,'房屋介绍6','经纪人账号6','经纪人姓名6','门店6',6,6,'已出售'),(1704365272811,'2024-01-04 10:47:52','和谐小屋','file/1704365243030.webp','二房一厅','120','北京大道2号',400000,'<p>详情</p>','2','2','北京区',0,1200,'已出售');
/*!40000 ALTER TABLE `fangyuanchushou` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fangyuanchuzu`
--

DROP TABLE IF EXISTS `fangyuanchuzu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fangyuanchuzu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `fangwumingcheng` varchar(200) NOT NULL COMMENT '房屋名称',
  `fangwutupian` longtext COMMENT '房屋图片',
  `fangwuleixing` varchar(200) NOT NULL COMMENT '房屋类型',
  `fangwumianji` varchar(200) DEFAULT NULL COMMENT '房屋面积',
  `fangwudizhi` varchar(200) DEFAULT NULL COMMENT '房屋地址',
  `chuzujiage` double NOT NULL COMMENT '价格/月',
  `fangwujieshao` longtext COMMENT '房屋介绍',
  `jingjirenzhanghao` varchar(200) DEFAULT NULL COMMENT '经纪人账号',
  `jingjirenxingming` varchar(200) DEFAULT NULL COMMENT '经纪人姓名',
  `storeupnum` int(11) DEFAULT NULL COMMENT '收藏数量',
  `zhuangtai` varchar(200) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1704365374811 DEFAULT CHARSET=utf8 COMMENT='房源出租';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fangyuanchuzu`
--

LOCK TABLES `fangyuanchuzu` WRITE;
/*!40000 ALTER TABLE `fangyuanchuzu` DISABLE KEYS */;
INSERT INTO `fangyuanchuzu` VALUES (111,'2024-01-04 10:35:07','房屋名称1','file/fangyuanchuzuFangwutupian1.jpg,file/fangyuanchuzuFangwutupian2.jpg,file/fangyuanchuzuFangwutupian3.jpg','房屋类型1','房屋面积1','房屋地址1',1,'房屋介绍1','经纪人账号1','经纪人姓名1',1,'已出租'),(112,'2024-01-04 10:35:07','房屋名称2','file/fangyuanchuzuFangwutupian2.jpg,file/fangyuanchuzuFangwutupian3.jpg,file/fangyuanchuzuFangwutupian4.jpg','房屋类型2','房屋面积2','房屋地址2',2,'<p>房屋介绍2</p>','经纪人账号2','经纪人姓名2',2,'已出租'),(113,'2024-01-04 10:35:07','房屋名称3','file/fangyuanchuzuFangwutupian3.jpg,file/fangyuanchuzuFangwutupian4.jpg,file/fangyuanchuzuFangwutupian5.jpg','房屋类型3','房屋面积3','房屋地址3',3,'房屋介绍3','经纪人账号3','经纪人姓名3',3,'已出租'),(114,'2024-01-04 10:35:07','房屋名称4','file/fangyuanchuzuFangwutupian4.jpg,file/fangyuanchuzuFangwutupian5.jpg,file/fangyuanchuzuFangwutupian6.jpg','房屋类型4','房屋面积4','房屋地址4',4,'房屋介绍4','经纪人账号4','经纪人姓名4',4,'已出租'),(115,'2024-01-04 10:35:07','房屋名称5','file/fangyuanchuzuFangwutupian5.jpg,file/fangyuanchuzuFangwutupian6.jpg,file/fangyuanchuzuFangwutupian7.jpg','房屋类型5','房屋面积5','房屋地址5',5,'房屋介绍5','经纪人账号5','经纪人姓名5',5,'已出租'),(116,'2024-01-04 10:35:07','房屋名称6','file/fangyuanchuzuFangwutupian6.jpg,file/fangyuanchuzuFangwutupian7.jpg,file/fangyuanchuzuFangwutupian8.jpg','房屋类型6','房屋面积6','房屋地址6',6,'房屋介绍6','经纪人账号6','经纪人姓名6',6,'已出租'),(1704365374810,'2024-01-04 10:49:34','好好小屋','file/1704365355977.webp','二房一厅','80','广州大道2号',1199,'<p>详情</p>','2','2',0,'已出租');
/*!40000 ALTER TABLE `fangyuanchuzu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jingjiren`
--

DROP TABLE IF EXISTS `jingjiren`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jingjiren` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `jingjirenzhanghao` varchar(200) NOT NULL COMMENT '经纪人账号',
  `mima` varchar(200) NOT NULL COMMENT '密码',
  `jingjirenxingming` varchar(200) NOT NULL COMMENT '经纪人姓名',
  `touxiang` longtext COMMENT '头像',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `shouji` varchar(200) DEFAULT NULL COMMENT '手机',
  `mendian` varchar(200) DEFAULT NULL COMMENT '门店',
  PRIMARY KEY (`id`),
  UNIQUE KEY `jingjirenzhanghao` (`jingjirenzhanghao`)
) ENGINE=InnoDB AUTO_INCREMENT=1704365181790 DEFAULT CHARSET=utf8 COMMENT='经纪人';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jingjiren`
--

LOCK TABLES `jingjiren` WRITE;
/*!40000 ALTER TABLE `jingjiren` DISABLE KEYS */;
INSERT INTO `jingjiren` VALUES (51,'2024-01-04 10:35:07','经纪人账号1','123456','经纪人姓名1','file/jingjirenTouxiang1.jpg','男','19819881111','门店1'),(52,'2024-01-04 10:35:07','经纪人账号2','123456','经纪人姓名2','file/jingjirenTouxiang2.jpg','男','19819881112','门店2'),(53,'2024-01-04 10:35:07','经纪人账号3','123456','经纪人姓名3','file/jingjirenTouxiang3.jpg','男','19819881113','门店3'),(54,'2024-01-04 10:35:07','经纪人账号4','123456','经纪人姓名4','file/jingjirenTouxiang4.jpg','男','19819881114','门店4'),(55,'2024-01-04 10:35:07','经纪人账号5','123456','经纪人姓名5','file/jingjirenTouxiang5.jpg','男','19819881115','门店5'),(56,'2024-01-04 10:35:07','经纪人账号6','123456','经纪人姓名6','file/jingjirenTouxiang6.jpg','男','19819881116','门店6'),(1704365181789,'2024-01-04 10:46:21','2','2','2','file/1704365176374.jpg','男','13612312312','北京区');
/*!40000 ALTER TABLE `jingjiren` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mendian`
--

DROP TABLE IF EXISTS `mendian`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mendian` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `mendian` varchar(200) NOT NULL COMMENT '门店',
  PRIMARY KEY (`id`),
  UNIQUE KEY `mendian` (`mendian`)
) ENGINE=InnoDB AUTO_INCREMENT=1704365301355 DEFAULT CHARSET=utf8 COMMENT='门店';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mendian`
--

LOCK TABLES `mendian` WRITE;
/*!40000 ALTER TABLE `mendian` DISABLE KEYS */;
INSERT INTO `mendian` VALUES (141,'2024-01-04 10:35:07','门店1'),(142,'2024-01-04 10:35:07','门店2'),(143,'2024-01-04 10:35:07','门店3'),(144,'2024-01-04 10:35:07','门店4'),(145,'2024-01-04 10:35:07','门店5'),(146,'2024-01-04 10:35:07','门店6'),(1704365301354,'2024-01-04 10:48:20','北京区');
/*!40000 ALTER TABLE `mendian` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `menujson` longtext COMMENT '菜单',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='菜单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'2024-01-04 10:35:07','[{\"backMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-album\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"用户\",\"menuJump\":\"列表\",\"tableName\":\"yonghu\"},{\"appFrontIcon\":\"cuIcon-full\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"经纪人\",\"menuJump\":\"列表\",\"tableName\":\"jingjiren\"}],\"fontClass\":\"icon-user6\",\"menu\":\"用户管理\",\"unicode\":\"&#xef9c;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-paint\",\"buttons\":[\"查看\",\"修改\",\"删除\",\"审核\"],\"menu\":\"预约租房\",\"menuJump\":\"列表\",\"tableName\":\"yuyuezufang\"},{\"appFrontIcon\":\"cuIcon-circle\",\"buttons\":[\"查看\",\"修改\",\"删除\"],\"menu\":\"租房信息\",\"menuJump\":\"列表\",\"tableName\":\"zufangxinxi\"},{\"appFrontIcon\":\"cuIcon-list\",\"buttons\":[\"查看\",\"修改\",\"删除\",\"查看评论\"],\"menu\":\"房源出租\",\"menuJump\":\"列表\",\"tableName\":\"fangyuanchuzu\"}],\"fontClass\":\"icon-common17\",\"menu\":\"出租房源管理\",\"unicode\":\"&#xedfe;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-addressbook\",\"buttons\":[\"查看\",\"修改\",\"删除\",\"审核\"],\"menu\":\"预约购房\",\"menuJump\":\"列表\",\"tableName\":\"yuyuegoufang\"},{\"appFrontIcon\":\"cuIcon-newshot\",\"buttons\":[\"查看\",\"修改\",\"删除\"],\"menu\":\"预定房子\",\"menuJump\":\"列表\",\"tableName\":\"yudingfangzi\"},{\"appFrontIcon\":\"cuIcon-circle\",\"buttons\":[\"查看\",\"修改\",\"删除\",\"查看评论\"],\"menu\":\"房源出售\",\"menuJump\":\"列表\",\"tableName\":\"fangyuanchushou\"}],\"fontClass\":\"icon-common40\",\"menu\":\"房源信息管理\",\"unicode\":\"&#xeebb;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-circle\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"轮播图\",\"menuJump\":\"列表\",\"tableName\":\"config\"},{\"appFrontIcon\":\"cuIcon-pay\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"新闻资讯\",\"menuJump\":\"列表\",\"tableName\":\"news\"}],\"fontClass\":\"icon-common47\",\"menu\":\"管理员管理\",\"unicode\":\"&#xef63;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-vip\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"房屋类型\",\"menuJump\":\"列表\",\"tableName\":\"fangwuleixing\"}],\"fontClass\":\"icon-common22\",\"menu\":\"类型管理\",\"unicode\":\"&#xee04;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-present\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"门店\",\"menuJump\":\"列表\",\"tableName\":\"mendian\"}],\"fontClass\":\"icon-common36\",\"menu\":\"门店管理\",\"unicode\":\"&#xee9f;\"}],\"frontMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-pay\",\"buttons\":[\"预约\",\"租房\"],\"menu\":\"房源出租\",\"menuJump\":\"列表\",\"tableName\":\"fangyuanchuzu\"}],\"menu\":\"出租房源管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-skin\",\"buttons\":[\"查看\"],\"menu\":\"新闻资讯\",\"menuJump\":\"列表\",\"tableName\":\"news\"}],\"menu\":\"房屋资讯管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-vip\",\"buttons\":[\"预约\",\"预定\"],\"menu\":\"房源出售\",\"menuJump\":\"列表\",\"tableName\":\"fangyuanchushou\"}],\"menu\":\"房源信息管理\"}],\"hasBackLogin\":\"是\",\"hasBackRegister\":\"否\",\"hasFrontLogin\":\"否\",\"hasFrontRegister\":\"否\",\"roleName\":\"管理员\",\"tableName\":\"users\"},{\"backMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-newshot\",\"buttons\":[\"查看\",\"支付\"],\"menu\":\"预定房子\",\"menuJump\":\"列表\",\"tableName\":\"yudingfangzi\"},{\"appFrontIcon\":\"cuIcon-addressbook\",\"buttons\":[\"查看\",\"预定\"],\"menu\":\"预约购房\",\"menuJump\":\"列表\",\"tableName\":\"yuyuegoufang\"}],\"fontClass\":\"icon-common40\",\"menu\":\"房源信息管理\",\"unicode\":\"&#xeebb;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-paint\",\"buttons\":[\"查看\"],\"menu\":\"预约租房\",\"menuJump\":\"列表\",\"tableName\":\"yuyuezufang\"},{\"appFrontIcon\":\"cuIcon-circle\",\"buttons\":[\"查看\",\"支付\"],\"menu\":\"租房信息\",\"menuJump\":\"列表\",\"tableName\":\"zufangxinxi\"}],\"fontClass\":\"icon-common17\",\"menu\":\"出租房源管理\",\"unicode\":\"&#xedfe;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-phone\",\"buttons\":[\"查看\"],\"menu\":\"我的收藏\",\"menuJump\":\"1\",\"tableName\":\"storeup\"}],\"fontClass\":\"icon-common28\",\"menu\":\"我的收藏管理\",\"unicode\":\"&#xee2d;\"}],\"frontMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-pay\",\"buttons\":[\"预约\",\"租房\"],\"menu\":\"房源出租\",\"menuJump\":\"列表\",\"tableName\":\"fangyuanchuzu\"}],\"menu\":\"出租房源管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-skin\",\"buttons\":[\"查看\"],\"menu\":\"新闻资讯\",\"menuJump\":\"列表\",\"tableName\":\"news\"}],\"menu\":\"房屋资讯管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-vip\",\"buttons\":[\"预约\",\"预定\"],\"menu\":\"房源出售\",\"menuJump\":\"列表\",\"tableName\":\"fangyuanchushou\"}],\"menu\":\"房源信息管理\"}],\"hasBackLogin\":\"否\",\"hasBackRegister\":\"否\",\"hasFrontLogin\":\"是\",\"hasFrontRegister\":\"是\",\"roleName\":\"用户\",\"tableName\":\"yonghu\"},{\"backMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-addressbook\",\"buttons\":[\"查看\",\"修改\",\"删除\",\"审核\"],\"menu\":\"预约购房\",\"menuJump\":\"列表\",\"tableName\":\"yuyuegoufang\"},{\"appFrontIcon\":\"cuIcon-newshot\",\"buttons\":[\"查看\",\"删除\",\"修改\"],\"menu\":\"预定房子\",\"menuJump\":\"列表\",\"tableName\":\"yudingfangzi\"},{\"appFrontIcon\":\"cuIcon-circle\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"查看评论\"],\"menu\":\"房源出售\",\"menuJump\":\"列表\",\"tableName\":\"fangyuanchushou\"}],\"fontClass\":\"icon-common40\",\"menu\":\"房源信息管理\",\"unicode\":\"&#xeebb;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-circle\",\"buttons\":[\"查看\",\"删除\",\"修改\"],\"menu\":\"租房信息\",\"menuJump\":\"列表\",\"tableName\":\"zufangxinxi\"},{\"appFrontIcon\":\"cuIcon-list\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"查看评论\"],\"menu\":\"房源出租\",\"menuJump\":\"列表\",\"tableName\":\"fangyuanchuzu\"},{\"appFrontIcon\":\"cuIcon-paint\",\"buttons\":[\"查看\",\"删除\",\"审核\",\"修改\"],\"menu\":\"预约租房\",\"menuJump\":\"列表\",\"tableName\":\"yuyuezufang\"}],\"fontClass\":\"icon-common17\",\"menu\":\"出租房源管理\",\"unicode\":\"&#xedfe;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-vip\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"房屋类型\",\"menuJump\":\"列表\",\"tableName\":\"fangwuleixing\"}],\"fontClass\":\"icon-common22\",\"menu\":\"类型管理\",\"unicode\":\"&#xee04;\"}],\"frontMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-pay\",\"buttons\":[\"预约\",\"租房\"],\"menu\":\"房源出租\",\"menuJump\":\"列表\",\"tableName\":\"fangyuanchuzu\"}],\"menu\":\"出租房源管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-skin\",\"buttons\":[\"查看\"],\"menu\":\"新闻资讯\",\"menuJump\":\"列表\",\"tableName\":\"news\"}],\"menu\":\"房屋资讯管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-vip\",\"buttons\":[\"预约\",\"预定\"],\"menu\":\"房源出售\",\"menuJump\":\"列表\",\"tableName\":\"fangyuanchushou\"}],\"menu\":\"房源信息管理\"}],\"hasBackLogin\":\"是\",\"hasBackRegister\":\"是\",\"hasFrontLogin\":\"否\",\"hasFrontRegister\":\"否\",\"roleName\":\"经纪人\",\"tableName\":\"jingjiren\"}]');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `news` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `title` varchar(200) NOT NULL COMMENT '标题',
  `introduction` longtext COMMENT '简介',
  `picture` longtext NOT NULL COMMENT '图片',
  `content` longtext NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1704365605136 DEFAULT CHARSET=utf8 COMMENT='新闻资讯';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES (31,'2024-01-04 10:35:07','这是标题1','这是简介1','file/newsPicture1.jpg','这是内容1'),(32,'2024-01-04 10:35:07','这是标题2','这是简介2','file/newsPicture2.jpg','这是内容2'),(33,'2024-01-04 10:35:07','这是标题3','这是简介3','file/newsPicture3.jpg','这是内容3'),(34,'2024-01-04 10:35:07','这是标题4','这是简介4','file/newsPicture4.jpg','这是内容4'),(35,'2024-01-04 10:35:07','这是标题5','这是简介5','file/newsPicture5.jpg','这是内容5'),(36,'2024-01-04 10:35:07','这是标题6','这是简介6','file/newsPicture6.jpg','这是内容6'),(1704365605135,'2024-01-04 10:53:24','购房优惠','简述','file/1704365596177.webp','<p>这里可以写详情</p>');
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storeup`
--

DROP TABLE IF EXISTS `storeup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `storeup` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) DEFAULT NULL COMMENT 'refid',
  `tablename` varchar(200) DEFAULT NULL COMMENT '表名',
  `name` varchar(200) NOT NULL COMMENT '名称',
  `picture` longtext NOT NULL COMMENT '图片',
  `type` varchar(200) DEFAULT NULL COMMENT '类型(1:收藏,21:赞,22:踩,31:竞拍参与,41:关注)',
  `inteltype` varchar(200) DEFAULT NULL COMMENT '推荐类型',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1704364778856 DEFAULT CHARSET=utf8 COMMENT='我的收藏';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storeup`
--

LOCK TABLES `storeup` WRITE;
/*!40000 ALTER TABLE `storeup` DISABLE KEYS */;
INSERT INTO `storeup` VALUES (1704364778855,'2024-01-04 10:39:38',72,'fangyuanchushou','房屋名称2','file/fangyuanchushouFangwutupian2.jpg','1',NULL,NULL,1704364754222);
/*!40000 ALTER TABLE `storeup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(200) NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='token表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
INSERT INTO `token` VALUES (1,1704364754222,'1','yonghu','用户','yscx4akifl5b6a6vsrprcym3h5i5l5e6','2024-01-04 10:39:17','2024-01-04 11:49:44'),(2,52,'经纪人账号2','jingjiren','管理员','zhdemybqld8fmeqrbuu0aurqwz8sqsov','2024-01-04 10:40:40','2024-01-04 11:40:40'),(3,1704365181789,'2','jingjiren','管理员','vxpcv8urfmiezce3pdauf699i4xx0ntx','2024-01-04 10:46:27','2024-01-04 11:51:01'),(4,1,'admin','users','管理员','pvntg405da8j5rrzw62czwar6lmjs5j0','2024-01-04 10:48:04','2024-01-04 11:52:19');
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `username` varchar(200) NOT NULL COMMENT '用户名',
  `password` varchar(200) NOT NULL COMMENT '密码',
  `role` varchar(200) DEFAULT NULL COMMENT '角色',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='管理员';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'2024-01-04 10:35:07','admin','admin','管理员');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yonghu`
--

DROP TABLE IF EXISTS `yonghu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yonghu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yonghuming` varchar(200) NOT NULL COMMENT '用户名',
  `yonghumima` varchar(200) NOT NULL COMMENT '用户密码',
  `yonghuxingming` varchar(200) NOT NULL COMMENT '用户姓名',
  `touxiang` longtext COMMENT '头像',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `shoujihaoma` varchar(200) DEFAULT NULL COMMENT '手机号码',
  PRIMARY KEY (`id`),
  UNIQUE KEY `yonghuming` (`yonghuming`)
) ENGINE=InnoDB AUTO_INCREMENT=1704364754223 DEFAULT CHARSET=utf8 COMMENT='用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yonghu`
--

LOCK TABLES `yonghu` WRITE;
/*!40000 ALTER TABLE `yonghu` DISABLE KEYS */;
INSERT INTO `yonghu` VALUES (41,'2024-01-04 10:35:07','用户名1','123456','用户姓名1','file/yonghuTouxiang1.jpg','男','19819881111'),(42,'2024-01-04 10:35:07','用户名2','123456','用户姓名2','file/yonghuTouxiang2.jpg','男','19819881112'),(43,'2024-01-04 10:35:07','用户名3','123456','用户姓名3','file/yonghuTouxiang3.jpg','男','19819881113'),(44,'2024-01-04 10:35:07','用户名4','123456','用户姓名4','file/yonghuTouxiang4.jpg','男','19819881114'),(45,'2024-01-04 10:35:07','用户名5','123456','用户姓名5','file/yonghuTouxiang5.jpg','男','19819881115'),(46,'2024-01-04 10:35:07','用户名6','123456','用户姓名6','file/yonghuTouxiang6.jpg','男','19819881116'),(1704364754222,'2024-01-04 10:39:14','1','1','1','file/1704364747897.jpg','女','13645645645');
/*!40000 ALTER TABLE `yonghu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yudingfangzi`
--

DROP TABLE IF EXISTS `yudingfangzi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yudingfangzi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `fangwumingcheng` varchar(200) NOT NULL COMMENT '房屋名称',
  `fangwuleixing` varchar(200) DEFAULT NULL COMMENT '房屋类型',
  `fangwumianji` varchar(200) DEFAULT NULL COMMENT '房屋面积',
  `fangwudizhi` varchar(200) DEFAULT NULL COMMENT '房屋地址',
  `dingjin` double NOT NULL COMMENT '定金',
  `jingjirenzhanghao` varchar(200) DEFAULT NULL COMMENT '经纪人账号',
  `jingjirenxingming` varchar(200) DEFAULT NULL COMMENT '经纪人姓名',
  `yonghuming` varchar(200) DEFAULT NULL COMMENT '用户名',
  `yonghuxingming` varchar(200) DEFAULT NULL COMMENT '用户姓名',
  `yudingshijian` datetime DEFAULT NULL COMMENT '预定时间',
  `ispay` varchar(200) DEFAULT NULL COMMENT '是否支付',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1704365398099 DEFAULT CHARSET=utf8 COMMENT='预定房子';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yudingfangzi`
--

LOCK TABLES `yudingfangzi` WRITE;
/*!40000 ALTER TABLE `yudingfangzi` DISABLE KEYS */;
INSERT INTO `yudingfangzi` VALUES (101,'2024-01-04 10:35:07','房屋名称1','房屋类型1','房屋面积1','房屋地址1',1,'经纪人账号1','经纪人姓名1','用户名1','用户姓名1','2024-01-04 18:35:07','未支付'),(102,'2024-01-04 10:35:07','房屋名称2','房屋类型2','房屋面积2','房屋地址2',2,'经纪人账号2','经纪人姓名2','用户名2','用户姓名2','2024-01-04 18:35:07','未支付'),(103,'2024-01-04 10:35:07','房屋名称3','房屋类型3','房屋面积3','房屋地址3',3,'经纪人账号3','经纪人姓名3','用户名3','用户姓名3','2024-01-04 18:35:07','未支付'),(104,'2024-01-04 10:35:07','房屋名称4','房屋类型4','房屋面积4','房屋地址4',4,'经纪人账号4','经纪人姓名4','用户名4','用户姓名4','2024-01-04 18:35:07','未支付'),(105,'2024-01-04 10:35:07','房屋名称5','房屋类型5','房屋面积5','房屋地址5',5,'经纪人账号5','经纪人姓名5','用户名5','用户姓名5','2024-01-04 18:35:07','未支付'),(106,'2024-01-04 10:35:07','房屋名称6','房屋类型6','房屋面积6','房屋地址6',6,'经纪人账号6','经纪人姓名6','用户名6','用户姓名6','2024-01-04 18:35:07','未支付'),(1704364947240,'2024-01-04 10:42:26','房屋名称2','房屋类型2','房屋面积2','房屋地址2',2,'经纪人账号2','经纪人姓名2','1','1','2024-01-04 18:42:24','已支付'),(1704365398098,'2024-01-04 10:49:58','和谐小屋','二房一厅','120','北京大道2号',1200,'2','2','1','1','2024-01-04 18:49:59','已支付');
/*!40000 ALTER TABLE `yudingfangzi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yuyuegoufang`
--

DROP TABLE IF EXISTS `yuyuegoufang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yuyuegoufang` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `fangwumingcheng` varchar(200) NOT NULL COMMENT '房屋名称',
  `fangwuleixing` varchar(200) DEFAULT NULL COMMENT '房屋类型',
  `fangwumianji` varchar(200) DEFAULT NULL COMMENT '房屋面积',
  `fangwudizhi` varchar(200) DEFAULT NULL COMMENT '房屋地址',
  `xiaoshoujiage` double NOT NULL COMMENT '销售价格',
  `jingjirenzhanghao` varchar(200) DEFAULT NULL COMMENT '经纪人账号',
  `jingjirenxingming` varchar(200) DEFAULT NULL COMMENT '经纪人姓名',
  `yonghuming` varchar(200) DEFAULT NULL COMMENT '用户名',
  `yonghuxingming` varchar(200) DEFAULT NULL COMMENT '用户姓名',
  `yuyueshijian` datetime DEFAULT NULL COMMENT '预约时间',
  `sfsh` varchar(200) DEFAULT NULL COMMENT '是否审核',
  `shhf` longtext COMMENT '回复内容',
  `dingjin` double DEFAULT NULL COMMENT '定金',
  `crossuserid` bigint(20) DEFAULT NULL COMMENT '跨表用户id',
  `crossrefid` bigint(20) DEFAULT NULL COMMENT '跨表主键id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1704365393925 DEFAULT CHARSET=utf8 COMMENT='预约购房';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yuyuegoufang`
--

LOCK TABLES `yuyuegoufang` WRITE;
/*!40000 ALTER TABLE `yuyuegoufang` DISABLE KEYS */;
INSERT INTO `yuyuegoufang` VALUES (91,'2024-01-04 10:35:07','房屋名称1','房屋类型1','房屋面积1','房屋地址1',1,'经纪人账号1','经纪人姓名1','用户名1','用户姓名1','2024-01-04 18:35:07','是','',1,1,1),(92,'2024-01-04 10:35:07','房屋名称2','房屋类型2','房屋面积2','房屋地址2',2,'经纪人账号2','经纪人姓名2','用户名2','用户姓名2','2024-01-04 18:35:07','是','',2,2,2),(93,'2024-01-04 10:35:07','房屋名称3','房屋类型3','房屋面积3','房屋地址3',3,'经纪人账号3','经纪人姓名3','用户名3','用户姓名3','2024-01-04 18:35:07','是','',3,3,3),(94,'2024-01-04 10:35:07','房屋名称4','房屋类型4','房屋面积4','房屋地址4',4,'经纪人账号4','经纪人姓名4','用户名4','用户姓名4','2024-01-04 18:35:07','是','',4,4,4),(95,'2024-01-04 10:35:07','房屋名称5','房屋类型5','房屋面积5','房屋地址5',5,'经纪人账号5','经纪人姓名5','用户名5','用户姓名5','2024-01-04 18:35:07','是','',5,5,5),(96,'2024-01-04 10:35:07','房屋名称6','房屋类型6','房屋面积6','房屋地址6',6,'经纪人账号6','经纪人姓名6','用户名6','用户姓名6','2024-01-04 18:35:07','是','',6,6,6),(1704364784583,'2024-01-04 10:39:43','房屋名称2','房屋类型2','房屋面积2','房屋地址2',2,'经纪人账号2','经纪人姓名2','1','1','2024-01-04 18:39:43','是','同意',2,1704364754222,72),(1704365393924,'2024-01-04 10:49:53','和谐小屋','二房一厅','120','北京大道2号',400000,'2','2','1','1','2024-01-04 18:49:53','是','审核',1200,1704364754222,1704365272811);
/*!40000 ALTER TABLE `yuyuegoufang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yuyuezufang`
--

DROP TABLE IF EXISTS `yuyuezufang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yuyuezufang` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `fangwumingcheng` varchar(200) NOT NULL COMMENT '房屋名称',
  `fangwuleixing` varchar(200) DEFAULT NULL COMMENT '房屋类型',
  `fangwumianji` varchar(200) DEFAULT NULL COMMENT '房屋面积',
  `fangwudizhi` varchar(200) DEFAULT NULL COMMENT '房屋地址',
  `chuzujiage` double NOT NULL COMMENT '出租价格',
  `jingjirenzhanghao` varchar(200) DEFAULT NULL COMMENT '经纪人账号',
  `jingjirenxingming` varchar(200) DEFAULT NULL COMMENT '经纪人姓名',
  `yonghuming` varchar(200) DEFAULT NULL COMMENT '用户名',
  `yonghuxingming` varchar(200) DEFAULT NULL COMMENT '用户姓名',
  `yuyueshijian` datetime DEFAULT NULL COMMENT '预约时间',
  `sfsh` varchar(200) DEFAULT NULL COMMENT '是否审核',
  `shhf` longtext COMMENT '回复内容',
  `crossuserid` bigint(20) DEFAULT NULL COMMENT '跨表用户id',
  `crossrefid` bigint(20) DEFAULT NULL COMMENT '跨表主键id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1704365407800 DEFAULT CHARSET=utf8 COMMENT='预约租房';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yuyuezufang`
--

LOCK TABLES `yuyuezufang` WRITE;
/*!40000 ALTER TABLE `yuyuezufang` DISABLE KEYS */;
INSERT INTO `yuyuezufang` VALUES (121,'2024-01-04 10:35:07','房屋名称1','房屋类型1','房屋面积1','房屋地址1',1,'经纪人账号1','经纪人姓名1','用户名1','用户姓名1','2024-01-04 18:35:07','是','',1,1),(122,'2024-01-04 10:35:07','房屋名称2','房屋类型2','房屋面积2','房屋地址2',2,'经纪人账号2','经纪人姓名2','用户名2','用户姓名2','2024-01-04 18:35:07','是','',2,2),(123,'2024-01-04 10:35:07','房屋名称3','房屋类型3','房屋面积3','房屋地址3',3,'经纪人账号3','经纪人姓名3','用户名3','用户姓名3','2024-01-04 18:35:07','是','',3,3),(124,'2024-01-04 10:35:07','房屋名称4','房屋类型4','房屋面积4','房屋地址4',4,'经纪人账号4','经纪人姓名4','用户名4','用户姓名4','2024-01-04 18:35:07','是','',4,4),(125,'2024-01-04 10:35:07','房屋名称5','房屋类型5','房屋面积5','房屋地址5',5,'经纪人账号5','经纪人姓名5','用户名5','用户姓名5','2024-01-04 18:35:07','是','',5,5),(126,'2024-01-04 10:35:07','房屋名称6','房屋类型6','房屋面积6','房屋地址6',6,'经纪人账号6','经纪人姓名6','用户名6','用户姓名6','2024-01-04 18:35:07','是','',6,6),(1704364797450,'2024-01-04 10:39:56','房屋名称2','房屋类型2','房屋面积2','房屋地址2',2,'经纪人账号2','经纪人姓名2','1','1','2024-01-04 18:39:57','是','通过',1704364754222,112),(1704365407799,'2024-01-04 10:50:07','好好小屋','二房一厅','80','广州大道2号',1199,'2','2','1','1','2024-01-04 18:50:08','是','同意',1704364754222,1704365374810);
/*!40000 ALTER TABLE `yuyuezufang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zufangxinxi`
--

DROP TABLE IF EXISTS `zufangxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zufangxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `fangwumingcheng` varchar(200) NOT NULL COMMENT '房屋名称',
  `fangwuleixing` varchar(200) DEFAULT NULL COMMENT '房屋类型',
  `fangwumianji` varchar(200) DEFAULT NULL COMMENT '房屋面积',
  `fangwudizhi` varchar(200) DEFAULT NULL COMMENT '房屋地址',
  `chuzujiage` double NOT NULL COMMENT '出租价格',
  `jingjirenzhanghao` varchar(200) DEFAULT NULL COMMENT '经纪人账号',
  `jingjirenxingming` varchar(200) DEFAULT NULL COMMENT '经纪人姓名',
  `yonghuming` varchar(200) DEFAULT NULL COMMENT '用户名',
  `yonghuxingming` varchar(200) DEFAULT NULL COMMENT '用户姓名',
  `chuzushijian` datetime DEFAULT NULL COMMENT '出租时间',
  `ispay` varchar(200) DEFAULT NULL COMMENT '是否支付',
  `zulinyueshu` int(11) DEFAULT NULL COMMENT '租赁月数',
  `zongjia` varchar(200) DEFAULT NULL COMMENT '总价',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1704365414875 DEFAULT CHARSET=utf8 COMMENT='租房信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zufangxinxi`
--

LOCK TABLES `zufangxinxi` WRITE;
/*!40000 ALTER TABLE `zufangxinxi` DISABLE KEYS */;
INSERT INTO `zufangxinxi` VALUES (131,'2024-01-04 10:35:07','房屋名称1','房屋类型1','房屋面积1','房屋地址1',1,'经纪人账号1','经纪人姓名1','用户名1','用户姓名1','2024-01-04 18:35:07','未支付',1,'总价1'),(132,'2024-01-04 10:35:07','房屋名称2','房屋类型2','房屋面积2','房屋地址2',2,'经纪人账号2','经纪人姓名2','用户名2','用户姓名2','2024-01-04 18:35:07','未支付',2,'总价2'),(133,'2024-01-04 10:35:07','房屋名称3','房屋类型3','房屋面积3','房屋地址3',3,'经纪人账号3','经纪人姓名3','用户名3','用户姓名3','2024-01-04 18:35:07','未支付',3,'总价3'),(134,'2024-01-04 10:35:07','房屋名称4','房屋类型4','房屋面积4','房屋地址4',4,'经纪人账号4','经纪人姓名4','用户名4','用户姓名4','2024-01-04 18:35:07','未支付',4,'总价4'),(135,'2024-01-04 10:35:07','房屋名称5','房屋类型5','房屋面积5','房屋地址5',5,'经纪人账号5','经纪人姓名5','用户名5','用户姓名5','2024-01-04 18:35:07','未支付',5,'总价5'),(136,'2024-01-04 10:35:07','房屋名称6','房屋类型6','房屋面积6','房屋地址6',6,'经纪人账号6','经纪人姓名6','用户名6','用户姓名6','2024-01-04 18:35:07','未支付',6,'总价6'),(1704364965282,'2024-01-04 10:42:45','房屋名称2','房屋类型2','房屋面积2','房屋地址2',2,'经纪人账号2','经纪人姓名2','1','1','2024-01-04 18:42:42','已支付',2,'4.00'),(1704365414874,'2024-01-04 10:50:14','好好小屋','二房一厅','80','广州大道2号',1199,'2','2','1','1','2024-01-04 18:50:13','已支付',3,'3597.00');
/*!40000 ALTER TABLE `zufangxinxi` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-26 17:42:09
