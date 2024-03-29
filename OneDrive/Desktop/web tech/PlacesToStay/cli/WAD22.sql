USE ptsae1; -- CHANGE THIS TO USE YOUR DATABASE

DROP TABLE IF EXISTS accommodation;
DROP TABLE IF EXISTS acc_dates;
DROP TABLE IF EXISTS acc_users;
DROP TABLE IF EXISTS acc_bookings;

CREATE TABLE IF NOT EXISTS `accommodation` (
  `ID` int(11) AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `longitude` float DEFAULT NULL,
  `latitude` float DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB;

INSERT INTO `accommodation` (ID,name,type,location,longitude,latitude,description) VALUES (1, 'Pikes Peak Inn','hotel','Colorado',-104.913,38.8578,'A nice place to stay'),(2, 'Fireside Inn','BandB','Colorado',-106.045,39.4821,'A nice place to stay'),(3, 'Fawlty Towers','hotel','Torquay',-3.4963,50.4601,'Classy hotel with charming owner'),(4, 'The Boar Inn','pub','Hampshire',-1,51,'A nice place to stay'),(5, 'The Dales Inn','pub','Yorkshire',-2.0462,54.1465,'A nice place to stay'),(6, 'Jurys Inn','hotel','Hampshire',-1.401,50.9106,'A nice place to stay'),(7, 'Premier Inn','hotel','Hampshire',-1.3985,50.9071,'A nice place to stay'),(8, 'Hollands Wood','campsite','Hampshire',-1.57,50.83,'A nice place to stay'),(9, 'Ashurst','campsite','Hampshire',-1.53,50.887,'A nice place to stay'),(10, 'Hotel Mirto','hotel','Greece',22.5023,40.105,'A nice place to stay');


CREATE TABLE IF NOT EXISTS acc_dates (ID INT PRIMARY KEY AUTO_INCREMENT, accID INT, thedate INT, availability INT DEFAULT 20);

CREATE TABLE IF NOT EXISTS acc_users (ID INT PRIMARY KEY AUTO_INCREMENT, username VARCHAR(255), password VARCHAR(255), admin TINYINT DEFAULT 0);

CREATE TABLE IF NOT EXISTS acc_bookings (ID INT PRIMARY KEY AUTO_INCREMENT, accID INT, thedate INT, username VARCHAR(255), npeople INT); 

INSERT INTO acc_users(username,password,admin) VALUES ('admin','admin123',1),('tim','tim123',0),('kate','kate123',0),('visithampshire','vh123',0);

INSERT INTO acc_dates(accID,thedate) VALUES (1,220601),(1,220602),(1,220603),(2,220601),(2,220602),(2,220603),(3,220601),(3,220602),(3,220603),(4,220601),(4,220602),(4,220603),(5,220601),(5,220602),(5,220603),(6,220601),(6,220602),(6,220603),(7,220601),(7,220602),(7,220603),(8,220601),(8,220602),(8,220603),(9,220601),(0,220602),(9,220603),(10,220601),(10,220602),(10,220603);
