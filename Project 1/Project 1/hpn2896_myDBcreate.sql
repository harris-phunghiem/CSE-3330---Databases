/*
	Class: CSE 3330
	Semester: Fall 2016
	Student Name: Nghiem, Harris, hpn2896
	Student ID: 1000572896
	Assignment: project #1
*/

CREATE TABLE `Airport`
(
	`CODE` varchar(3) NOT NULL DEFAULT '000',
	`CITY` varchar(255),
	`FROMSTATE` varchar(255),
	PRIMARY KEY (`CODE`)
);

CREATE TABLE `Flight`
(
	`FLNO` int NOT NULL DEFAULT '00000',
	`MEAL` varchar(255) DEFAULT 'NO MEAL',
	`SMOKING` char(1) DEFAULT 'N',
	PRIMARY KEY (`FLNO`)
);

CREATE TABLE `FlightInstance`
(
	`FLNO` int NOT NULL,
	`FDATE` date NOT NULL,
	PRIMARY KEY (`FLNO`, `FDATE`)
);

CREATE TABLE FlightLeg
(
	`FLNO` int NOT NULL,
	`SEQ` int NOT NULL,
	`FROMA` varchar(255),
	`TOA` varchar(255),
	`DEPTIME` time,
	`AIRTIME` time,
	`PLANE` int,
	PRIMARY KEY (`FLNO`, `SEQ`),
	FOREIGN KEY (`FLNO`) 	REFERENCES Flight(`FLNO`),
	FOREIGN KEY (`FROMA`) 	REFERENCES Airport (`CODE`),
	FOREIGN KEY (`TOA`) 	REFERENCES Airport (`CODE`),
	FOREIGN KEY (`PLANE`) 	REFERENCES Plane (`ID`)
);


CREATE TABLE `FlightLegDistance`
(
	`SEQ` int NOT NULL,
	`FLNO` int NOT NULL,
	`FDATE` date NOT NULL,
	`ACTDEPT` time,
	`ACTARR` time,
	`PILOT` varchar(255),
	PRIMARY KEY (`SEQ`, `FLNO`, `FDATE`),
	FOREIGN KEY (`SEQ`) 		REFERENCES FlightLeg(`FLNO`),
	FOREIGN KEY (`FLNO`) 		REFERENCES FlightLeg(`FLNO`),
	FOREIGN KEY (`FLNO`) 				REFERENCES FlightInstance(`FLNO`),
	FOREIGN KEY (`FDATE`) 				REFERENCES FlightInstance(`FLNO`),
	FOREIGN KEY (`PILOT`) 				REFERENCES Pilot(`ID`)
);

CREATE TABLE `Passenger`
(
	`ID` int NOT NULL,
	`NAME` varchar(255),
	`PHONE` varchar(14),
	PRIMARY KEY (`ID`)
);


CREATE TABLE `Plane`
(
  `MAKER` varchar(256) NOT NULL,
  `ID` int(11) NOT NULL DEFAULT '0',
  `MODEL` varchar(45) DEFAULT NULL,
  `LASTMAINT` date DEFAULT NULL,
  `LASTMAINTA` date DEFAULT NULL,
  PRIMARY KEY (`ID`),
  FOREIGN KEY (`MAKER`) REFERENCES PlaneType (`MAKER`),
  FOREIGN KEY (`MODEL`) REFERENCES PlaneType (`MAKER`)
);

CREATE TABLE PlaneSeats
(
	`MAKER` varchar(255) NOT NULL,
	`MODEL` varchar(255) NOT NULL,
	`SEATTYPE` int NOT NULL,
	`NOOFSEATS` int,
	PRIMARY KEY (`MAKER`, `MODEL`, `SEATTYPE`),
	FOREIGN KEY (`MAKER`) REFERENCES PlaneType(`MAKER`),
	FOREIGN KEY (`MAKER`) REFERENCES PlaneType (`MAKER`),
	FOREIGN KEY (`SEATTYPE`) REFERENCES PlaneType (`MAKER`)

);

CREATE TABLE `PlaneType`
(
	`MAKER` varchar(255) NOT NULL,
	`MODEL` varchar(255) NOT NULL,
	`FLYINGSPEED` int,
	`GROUNDSPEED` int,
	PRIMARY KEY (`MAKER`, `MODEL`)
);

CREATE TABLE `Pilot`
(
	`ID` int NOT NULL,
	`NAME` varchar(255),
	`DATEHIRED` date,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Reservation` 
(
	`PASSID` int NOT NULL DEFAULT '00000',
	`FLNO` int NOT NULL,
	`FDATE` date NOT NULL,
	`FROMA` varchar(255),
	`TOA` varchar(255),
	`SEATCLASS` varchar(255) DEFAULT 'COACH',
	`DATEBOOKED` date,
	`DATECANCELLED` date,
	PRIMARY KEY (`PASSID`, `FLNO`, `FDATE`),
	FOREIGN KEY (`PASSID`) 			REFERENCES Passenger(`ID`),
	FOREIGN KEY (`FLNO`)		 	REFERENCES FlightInstance (`FLNO`),
	FOREIGN KEY (`FDATE`) 			REFERENCES FlightInstance (`FLNO`),
	FOREIGN KEY (`FROMA`) 			REFERENCES Airport (`CODE`),
	FOREIGN KEY (`TOA`) 			REFERENCES Airport (`CODE`)
);



