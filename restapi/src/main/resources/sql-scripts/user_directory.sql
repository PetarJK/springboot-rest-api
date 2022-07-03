CREATE DATABASE  IF NOT EXISTS `user_directory`;
USE `user_directory`;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `date_of_birth` datetime DEFAULT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Mock data for table `user`
--

INSERT INTO `user` VALUES 
	(1,'Deckard','Cain','2000-06-29','+359 123 456 789','cain@d2lod.com'),
	(2,'Zeratul','Fromaiur','1998-03-31','+359 123 123 321','zeratul@blizzard.com'),
    (3,'Lord','Vader','1987-01-01','+359 123 456 789','vader@dlucas.com'),
    (4,'Anakin','Skywalker','1988-03-01','+359 123 952 789','Skywalker@lucas.com'),
    (5,'Artanis','Protoss','1998-06-15','+359 587 456 254','artanis@broodwar.com'),
    (6,'Petar','Yankov','2000-01-01','+359 036 456 323','yankov@gmail.com'),
    (7,'John','Doe','1955-11-29','+359 333 456 555','doe@gmail.com'),
    (8,'Mary','Public','1994-10-15','+359 454 456 777','public@gmal.com'),
    (9,'Arina','Yankova','2021-05-11','+359 555 555 555','arina@gmail.com'),
    (10,'Sara','Kerrigan','2000-05-05','+359 123 222 987','kerrigan@broodwar.com');
    
--
-- Spring Security data
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `users` 
VALUES 
('Arina','{noop}pass123',1),
('Kristina','{noop}pass123',1),
('Petar','{noop}pass123',1);

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `authorities` 
VALUES 
('Arina','ROLE_EMPLOYEE'),
('Kristina','ROLE_EMPLOYEE'),
('Kristina','ROLE_MANAGER'),
('Petar','ROLE_EMPLOYEE'),
('Petar','ROLE_ADMIN');