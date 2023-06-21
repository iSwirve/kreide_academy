/*
SQLyog Community v13.1.7 (64 bit)
MySQL - 10.4.28-MariaDB : Database - kreide
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`kreide` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `kreide`;

/*Table structure for table `attendance` */

DROP TABLE IF EXISTS `attendance`;

CREATE TABLE `attendance` (
  `att_id` int(11) NOT NULL AUTO_INCREMENT,
  `month` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `week` int(11) NOT NULL,
  `year` int(11) NOT NULL,
  PRIMARY KEY (`att_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `attendance` */

/*Table structure for table `paket` */

DROP TABLE IF EXISTS `paket`;

CREATE TABLE `paket` (
  `paketid` int(11) NOT NULL AUTO_INCREMENT,
  `nama_paket` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`paketid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `paket` */

insert  into `paket`(`paketid`,`nama_paket`) values 
(1,'Web Development'),
(2,'Java EE');

/*Table structure for table `students` */

DROP TABLE IF EXISTS `students`;

CREATE TABLE `students` (
  `studentid` int(11) NOT NULL AUTO_INCREMENT,
  `mendaftar_sejak` varchar(255) DEFAULT NULL,
  `student_name` varchar(255) DEFAULT NULL,
  `fk_userid` varchar(255) DEFAULT NULL,
  `fk_paketid` int(11) NOT NULL,
  PRIMARY KEY (`studentid`),
  KEY `FKgbmkfabnq2y6asch1jonk0gqc` (`fk_userid`),
  KEY `FKat9aqlpkgthequn1uf25xk5dt` (`fk_paketid`),
  CONSTRAINT `FKat9aqlpkgthequn1uf25xk5dt` FOREIGN KEY (`fk_paketid`) REFERENCES `paket` (`paketid`),
  CONSTRAINT `FKgbmkfabnq2y6asch1jonk0gqc` FOREIGN KEY (`fk_userid`) REFERENCES `users` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `students` */

insert  into `students`(`studentid`,`mendaftar_sejak`,`student_name`,`fk_userid`,`fk_paketid`) values 
(2,NULL,'Ken','eriko',1),
(3,NULL,'Farel','eka',2),
(4,NULL,'Edo','eka',2);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `users` */

insert  into `users`(`username`,`password`,`level`) values 
('asd','asd','admin'),
('eka','eka','admin'),
('eriko','eriko','admin'),
('john','john','superuser'),
('kevin','kevin','superuser'),
('russel','russel','admin');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
