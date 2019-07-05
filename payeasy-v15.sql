-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.25-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for payeasy
CREATE DATABASE IF NOT EXISTS `payeasy` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `payeasy`;

-- Dumping structure for table payeasy.allowance
CREATE TABLE IF NOT EXISTS `allowance` (
  `allowanceid` int(11) NOT NULL AUTO_INCREMENT,
  `allowancehead` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`allowanceid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table payeasy.allowance: ~3 rows (approximately)
DELETE FROM `allowance`;
/*!40000 ALTER TABLE `allowance` DISABLE KEYS */;
INSERT INTO `allowance` (`allowanceid`, `allowancehead`) VALUES
	(1, ' Accommodation'),
	(2, 'Transport'),
	(3, 'Medical');
/*!40000 ALTER TABLE `allowance` ENABLE KEYS */;

-- Dumping structure for table payeasy.allowancecal
CREATE TABLE IF NOT EXISTS `allowancecal` (
  `allowancecalid` int(11) NOT NULL AUTO_INCREMENT,
  `jobtitlename` varchar(50) DEFAULT NULL,
  `allowancehead` varchar(50) DEFAULT NULL,
  `basicsalaryamount` double DEFAULT NULL,
  `percent` int(11) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `basicyearvalue` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`allowancecalid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

-- Dumping data for table payeasy.allowancecal: ~10 rows (approximately)
DELETE FROM `allowancecal`;
/*!40000 ALTER TABLE `allowancecal` DISABLE KEYS */;
INSERT INTO `allowancecal` (`allowancecalid`, `jobtitlename`, `allowancehead`, `basicsalaryamount`, `percent`, `amount`, `basicyearvalue`) VALUES
	(3, 'Web Developer', 'Medical', 60000, 12, 7200, '2019'),
	(4, 'Web Developer', 'Transport', 60000, 5, 3000, '2019'),
	(6, 'Web Developer', 'Transport', 55000, 4, 2200, '2015'),
	(7, 'CEO', 'Medical', 600000, 20, 120000, '2015'),
	(8, 'CEO', ' Accommodation', 700000, 18, 126000, '2019'),
	(9, 'Project Manager', 'Transport', 60500, 8, 4840, '2015'),
	(10, 'Receptionist', 'Transport', 35000, 5, 1750, '2015'),
	(11, 'Receptionist', 'Medical', 35000, 12, 4200, '2015'),
	(12, 'Receptionist', 'Transport', 40000, 6, 2400, '2019'),
	(13, 'Receptionist', 'Medical', 40000, 13, 5200, '2019');
/*!40000 ALTER TABLE `allowancecal` ENABLE KEYS */;

-- Dumping structure for table payeasy.basicsalary
CREATE TABLE IF NOT EXISTS `basicsalary` (
  `basicsalaryid` int(11) NOT NULL AUTO_INCREMENT,
  `basicsalaryamount` double DEFAULT NULL,
  `jobtitlename` varchar(50) DEFAULT NULL,
  `basicyearvalue` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`basicsalaryid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

-- Dumping data for table payeasy.basicsalary: ~8 rows (approximately)
DELETE FROM `basicsalary`;
/*!40000 ALTER TABLE `basicsalary` DISABLE KEYS */;
INSERT INTO `basicsalary` (`basicsalaryid`, `basicsalaryamount`, `jobtitlename`, `basicyearvalue`) VALUES
	(10, 610005, 'CEO', '2015'),
	(12, 60500, 'Project Manager', '2015'),
	(13, 55000, 'Web Developer', '2015'),
	(14, 700000, 'CEO', '2019'),
	(15, 65000, 'Project Manager', '2019'),
	(16, 60000, 'Web Developer', '2019'),
	(17, 35000, 'Receptionist', '2015'),
	(18, 40000, 'Receptionist', '2019');
/*!40000 ALTER TABLE `basicsalary` ENABLE KEYS */;

-- Dumping structure for table payeasy.basicyear
CREATE TABLE IF NOT EXISTS `basicyear` (
  `basicyearid` int(11) NOT NULL AUTO_INCREMENT,
  `basicyearvalue` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`basicyearid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Dumping data for table payeasy.basicyear: ~2 rows (approximately)
DELETE FROM `basicyear`;
/*!40000 ALTER TABLE `basicyear` DISABLE KEYS */;
INSERT INTO `basicyear` (`basicyearid`, `basicyearvalue`) VALUES
	(4, '2015'),
	(5, '2019');
/*!40000 ALTER TABLE `basicyear` ENABLE KEYS */;

-- Dumping structure for table payeasy.deduction
CREATE TABLE IF NOT EXISTS `deduction` (
  `deductionid` int(11) NOT NULL AUTO_INCREMENT,
  `deductionhead` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`deductionid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table payeasy.deduction: ~2 rows (approximately)
DELETE FROM `deduction`;
/*!40000 ALTER TABLE `deduction` DISABLE KEYS */;
INSERT INTO `deduction` (`deductionid`, `deductionhead`) VALUES
	(1, 'Income Tax'),
	(2, 'Refreshments');
/*!40000 ALTER TABLE `deduction` ENABLE KEYS */;

-- Dumping structure for table payeasy.deductioncal
CREATE TABLE IF NOT EXISTS `deductioncal` (
  `deductioncalid` int(11) NOT NULL AUTO_INCREMENT,
  `jobtitlename` varchar(50) DEFAULT NULL,
  `deductionhead` varchar(50) DEFAULT NULL,
  `basicsalaryamount` double DEFAULT NULL,
  `percent` int(11) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `basicyearvalue` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`deductioncalid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

-- Dumping data for table payeasy.deductioncal: ~12 rows (approximately)
DELETE FROM `deductioncal`;
/*!40000 ALTER TABLE `deductioncal` DISABLE KEYS */;
INSERT INTO `deductioncal` (`deductioncalid`, `jobtitlename`, `deductionhead`, `basicsalaryamount`, `percent`, `amount`, `basicyearvalue`) VALUES
	(5, 'Web Developer', 'Income Tax', 60000, 9, 5400, '2019'),
	(6, 'Web Developer', 'Income Tax', 55000, 8, 4400, '2015'),
	(7, 'CEO', 'Refreshments', 600005, 2, 12000.1, '2015'),
	(8, 'CEO', 'Refreshments', 700000, 2, 14000, '2019'),
	(9, 'Web Developer', 'Refreshments', 55000, 2, 1100, '2015'),
	(10, 'Web Developer', 'Refreshments', 60000, 2, 1200, '2019'),
	(11, 'CEO', 'Income Tax', 600005, 10, 60000.5, '2015'),
	(12, 'CEO', 'Income Tax', 700000, 10, 70000, '2019'),
	(13, 'Receptionist', 'Income Tax', 35000, 8, 2800, '2015'),
	(14, 'Receptionist', 'Refreshments', 35000, 1, 350, '2015'),
	(15, 'Receptionist', 'Income Tax', 40000, 8, 3200, '2019'),
	(16, 'Receptionist', 'Refreshments', 40000, 2, 800, '2019');
/*!40000 ALTER TABLE `deductioncal` ENABLE KEYS */;

-- Dumping structure for table payeasy.department
CREATE TABLE IF NOT EXISTS `department` (
  `departmentid` int(11) NOT NULL AUTO_INCREMENT,
  `departmentname` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`departmentid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Dumping data for table payeasy.department: ~5 rows (approximately)
DELETE FROM `department`;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` (`departmentid`, `departmentname`) VALUES
	(1, 'ICT'),
	(2, 'Human Resource'),
	(3, 'Production'),
	(4, 'Marketing'),
	(5, 'Research and Development');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;

-- Dumping structure for table payeasy.employee
CREATE TABLE IF NOT EXISTS `employee` (
  `empid` int(11) NOT NULL AUTO_INCREMENT,
  `empname` varchar(50) DEFAULT NULL,
  `jobtitlename` varchar(50) DEFAULT NULL,
  `departmentname` varchar(50) DEFAULT NULL,
  `emptypename` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `emailid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`empid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Dumping data for table payeasy.employee: ~4 rows (approximately)
DELETE FROM `employee`;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` (`empid`, `empname`, `jobtitlename`, `departmentname`, `emptypename`, `phone`, `address`, `emailid`) VALUES
	(1, 'Kuddus', 'Web Developer', 'ICT', 'Permanent', '0154545', 'Sylhet', 'name@gmil.com'),
	(2, 'Motin', 'Web Developer', 'Research and Development', 'Permanent', '555', 'Khulna', 'motin@gmail.com'),
	(4, 'Mokhles', 'Receptionist', 'Marketing', 'Permanent', '99939', 'Venice', 'mokhles@gmail.com'),
	(5, 'Jobbar', 'CEO', 'Research and Development', 'Permanent', '01925', 'Sweden', 'jobbar@gmail.com');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;

-- Dumping structure for table payeasy.emptype
CREATE TABLE IF NOT EXISTS `emptype` (
  `emptypeid` int(11) NOT NULL AUTO_INCREMENT,
  `emptypename` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`emptypeid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table payeasy.emptype: ~2 rows (approximately)
DELETE FROM `emptype`;
/*!40000 ALTER TABLE `emptype` DISABLE KEYS */;
INSERT INTO `emptype` (`emptypeid`, `emptypename`) VALUES
	(1, 'Permanent'),
	(2, 'Contract');
/*!40000 ALTER TABLE `emptype` ENABLE KEYS */;

-- Dumping structure for table payeasy.jobtitle
CREATE TABLE IF NOT EXISTS `jobtitle` (
  `jobtitleid` int(11) NOT NULL AUTO_INCREMENT,
  `jobtitlename` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`jobtitleid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- Dumping data for table payeasy.jobtitle: ~7 rows (approximately)
DELETE FROM `jobtitle`;
/*!40000 ALTER TABLE `jobtitle` DISABLE KEYS */;
INSERT INTO `jobtitle` (`jobtitleid`, `jobtitlename`) VALUES
	(1, 'CEO'),
	(2, 'Web Developer'),
	(3, 'Project Manager'),
	(5, 'Accountant'),
	(6, 'Receptionist'),
	(7, 'Quality Controller'),
	(8, 'Auditing Clerk');
/*!40000 ALTER TABLE `jobtitle` ENABLE KEYS */;

-- Dumping structure for table payeasy.payallowance
CREATE TABLE IF NOT EXISTS `payallowance` (
  `payallowanceid` int(11) NOT NULL AUTO_INCREMENT,
  `paymentid` int(11) DEFAULT NULL,
  `allowancehead` varchar(50) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  PRIMARY KEY (`payallowanceid`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

-- Dumping data for table payeasy.payallowance: ~17 rows (approximately)
DELETE FROM `payallowance`;
/*!40000 ALTER TABLE `payallowance` DISABLE KEYS */;
INSERT INTO `payallowance` (`payallowanceid`, `paymentid`, `allowancehead`, `amount`) VALUES
	(1, 4, 'Medical', 7200),
	(2, 4, 'Transport', 3000),
	(3, 5, 'Medical', 7200),
	(4, 6, 'Medical', 7200),
	(5, 6, 'Transport', 3000),
	(6, 7, 'Medical', 7200),
	(7, 7, 'Transport', 3000),
	(8, 8, 'Medical', 7200),
	(9, 8, 'Transport', 3000),
	(10, 9, 'Medical', 7200),
	(11, 9, 'Transport', 3000),
	(12, 10, 'Medical', 7200),
	(13, 11, 'Medical', 7200),
	(14, 11, 'Transport', 3000),
	(15, 12, 'Medical', 7200),
	(16, 12, 'Transport', 3000),
	(17, 13, 'Medical', 7200);
/*!40000 ALTER TABLE `payallowance` ENABLE KEYS */;

-- Dumping structure for table payeasy.paydeduction
CREATE TABLE IF NOT EXISTS `paydeduction` (
  `paydeductionid` int(11) NOT NULL AUTO_INCREMENT,
  `paymentid` int(11) DEFAULT NULL,
  `deductionhead` varchar(50) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  PRIMARY KEY (`paydeductionid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

-- Dumping data for table payeasy.paydeduction: ~13 rows (approximately)
DELETE FROM `paydeduction`;
/*!40000 ALTER TABLE `paydeduction` DISABLE KEYS */;
INSERT INTO `paydeduction` (`paydeductionid`, `paymentid`, `deductionhead`, `amount`) VALUES
	(1, 5, 'Income Tax', 5400),
	(2, 5, 'Refreshments', 1200),
	(3, 6, 'Income Tax', 5400),
	(4, 7, 'Income Tax', 5400),
	(5, 7, 'Refreshments', 1200),
	(6, 8, 'Income Tax', 5400),
	(7, 8, 'Refreshments', 1200),
	(8, 9, 'Income Tax', 5400),
	(9, 10, 'Income Tax', 5400),
	(10, 11, 'Income Tax', 5400),
	(11, 12, 'Income Tax', 5400),
	(12, 13, 'Income Tax', 5400),
	(13, 13, 'Refreshments', 1200);
/*!40000 ALTER TABLE `paydeduction` ENABLE KEYS */;

-- Dumping structure for table payeasy.payment
CREATE TABLE IF NOT EXISTS `payment` (
  `paymentid` int(11) NOT NULL AUTO_INCREMENT,
  `empname` varchar(50) DEFAULT NULL,
  `jobtitlename` varchar(50) DEFAULT NULL,
  `basicyearvalue` varchar(50) DEFAULT NULL,
  `basicsalaryamount` double DEFAULT NULL,
  `payingmonth` varchar(50) DEFAULT NULL,
  `payingyear` varchar(50) DEFAULT NULL,
  `paytypename` varchar(50) DEFAULT NULL,
  `checkno` varchar(50) DEFAULT NULL,
  `bankname` varchar(50) DEFAULT NULL,
  `totalallowance` double DEFAULT NULL,
  `totaldeduction` double DEFAULT NULL,
  `netsalary` double DEFAULT NULL,
  PRIMARY KEY (`paymentid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

-- Dumping data for table payeasy.payment: ~11 rows (approximately)
DELETE FROM `payment`;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` (`paymentid`, `empname`, `jobtitlename`, `basicyearvalue`, `basicsalaryamount`, `payingmonth`, `payingyear`, `paytypename`, `checkno`, `bankname`, `totalallowance`, `totaldeduction`, `netsalary`) VALUES
	(1, 'Kuddus', 'Web Developer', '2019', 60000, 'June', '2019', 'paytypename', 'checkno', 'bankname', 999, 555, 121212),
	(2, 'Kuddus', 'Web Developer', '2019', 60000, 'June', '2019', 'Bank Deposit', '548946', 'Omni Bank', 10200, 5400, 64800),
	(3, 'Kuddus', 'Web Developer', '2019', 60000, 'August', '2019', 'Bank Deposit', '555', 'Omni Bank', 7200, 1200, 66000),
	(4, 'Kuddus', 'Web Developer', '2019', 60000, 'July', '2019', 'Cash', '222', 'Jamuna', 10200, 5400, 64800),
	(5, 'Kuddus', 'Web Developer', '2019', 60000, 'November', '2018', 'Bank Deposit', '78785', 'BBnk', 7200, 6600, 60600),
	(6, 'Kuddus', 'Web Developer', '2019', 60000, 'August', '2019', 'Bank Deposit', '25', 'Royal', 10200, 5400, 64800),
	(7, 'Kuddus', 'Web Developer', '2019', 60000, 'September', '2019', 'Bank Deposit', '878', 'Omni', 10200, 6600, 63600),
	(8, 'Kuddus', 'Web Developer', '2019', 60000, 'May', '2019', 'Bank Deposit', '8799', 'K Bank', 10200, 6600, 63600),
	(9, 'Kuddus', 'Web Developer', '2019', 60000, 'August', '2020', 'Bank Deposit', '5654', 'hg', 10200, 5400, 64800),
	(10, 'Kuddus', 'Web Developer', '2019', 60000, 'March', '2019', 'Cash', '564', 'fdsds', 7200, 5400, 61800),
	(11, 'Kuddus', 'Web Developer', '2019', 60000, 'June', '2020', 'Bank Deposit', '897', 'jk', 10200, 5400, 64800),
	(12, 'Kuddus', 'Web Developer', '2019', 60000, 'April', '2019', 'Bank Deposit', '98989', 'yfhgfgh', 10200, 5400, 64800),
	(13, 'Kuddus', 'Web Developer', '2019', 60000, 'April', '2020', 'Bank Deposit', '6546', 'jhkjh', 7200, 6600, 60600);
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;

-- Dumping structure for table payeasy.paytype
CREATE TABLE IF NOT EXISTS `paytype` (
  `paytypeid` int(11) NOT NULL AUTO_INCREMENT,
  `paytypename` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`paytypeid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table payeasy.paytype: ~2 rows (approximately)
DELETE FROM `paytype`;
/*!40000 ALTER TABLE `paytype` DISABLE KEYS */;
INSERT INTO `paytype` (`paytypeid`, `paytypename`) VALUES
	(1, 'Bank Deposit'),
	(2, 'Cash');
/*!40000 ALTER TABLE `paytype` ENABLE KEYS */;

-- Dumping structure for table payeasy.user
CREATE TABLE IF NOT EXISTS `user` (
  `emailid` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`emailid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table payeasy.user: ~0 rows (approximately)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`emailid`, `phone`, `username`) VALUES
	('leon@gmail.com', '1548', 'Leon Saiful');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Dumping structure for table payeasy.userrole
CREATE TABLE IF NOT EXISTS `userrole` (
  `emailid` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`emailid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table payeasy.userrole: ~0 rows (approximately)
DELETE FROM `userrole`;
/*!40000 ALTER TABLE `userrole` DISABLE KEYS */;
INSERT INTO `userrole` (`emailid`, `password`, `role`, `status`) VALUES
	('leon@gmail.com', 'leon', 'ROLE_ADMIN', 'True');
/*!40000 ALTER TABLE `userrole` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
