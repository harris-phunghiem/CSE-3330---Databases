/*
	Class: CSE 3330
	Semester: Fall 2016
	Student Name: Nghiem, Harris, hpn2896
	Student ID: 1000572896
	Assignment: project #1
*/

INSERT INTO Airport (CODE, CITY, FROMSTATE) VALUES 
		('DFW', 'DALLAS', 'TEXAS'),
		('LAX', 'LOS ANGELES', 'CALIFORNIA'),
		('JFK', 'NEW YORK', 'NEW YORK'),
		('SJT', 'SAN ANGELO', 'TEXAS'),
		('SAT', 'SAN ANTONIO', 'TEXAS'),
		('SAN', 'SAN DIEGO', 'CALIFORNIA'),
		('AMA', 'AMARILLO', 'TEXAS');


INSERT INTO Flight (FLNO, MEAL, SMOKING) VALUES 
		('100', 'STEAK AND LOBSTER', NULL),
		('101', 'VEGAN', 'Y'),
		('102', 'HAMBURGER', 'N'),
		('103', 'HOT DOG', 'Y'),
		('104', NULL, NULL),
		('105',NULL,NULL),
		('106', 'SUSHI', 'Y');


INSERT INTO FlightInstance VALUES
		('100', '2016-9-23' ),
		('101', '2016-8-23' ),
		('102', '2016-7-23' ),
		('103', '2016-6-23' ),
		('104', '2016-5-23' ),
		('105', '2016-4-23' ),
		('106', '2016-3-23' ),
		('107', '2016-2-23' ),
		('108', '2016-1-23' ),
		('109', '2016-0-23' );


INSERT INTO FlightLeg VALUES 
		('1001', '9001', 'LOS ANGELES', 'DALLAS', '14:20', '17:20', '123456' ),
		('1002', '9002', 'NEW YOKR', 'SAN ANGELP', '4:20', '17:20', '111111' ),
		('1003', '9003', 'SAN ANGELO', 'AMARILLO', '4:20', '7:20', '222222' ),
		('1004', '9004', 'SAN ANTONIO', 'DALLAS', '10:20', '17:20', '333333' ),
		('1005', '9005', 'AMARILLO', 'DALLAS', '11:20', '17:20', '444444' ),
		('1006', '9006', 'LOS ANGELES', 'SAN DIEGO', '14:20', '18:20', '555555' ),
		('1007', '9007', 'DALLAS', 'SAN ANGELO', '14:20', '18:20', '6666666' ),
		('1008', '9008', 'NEW YORK', 'DALLAS', '14:20', '19:20', '7777777' ),
		('1009', '9009', 'LOS ANGELES', 'DALLAS', '14:20', '20:20', '8888888');

		
INSERT INTO FlightLegDistance VALUES 
		('1001', '9001', '2016-9-23', '14:20', '17:20', 'BILLY BOB'),
		('1002', '9002', '2016-9-23', '4:20', '17:20', 'HARRY JOE'),
		('1003', '9003', '2016-9-23', '4:20', '7:20', 'JACK JOHNSON'),
		('1004', '9004', '2016-9-23', '10:20', '17:20', 'MARY BLIGE'),
		('1005', '9005', '2016-9-23', '11:20', '17:20', 'CHRIS CARTER'),
		('1006', '9006', '2016-9-23', '14:20', '20:20', 'WILL SMITH'),
		('1007', '9007', '2016-9-23', '14:20', '20:20', 'JACKIE CHAN'),
		('1008', '9008', '2016-9-23', '11:20', '17:20', 'JET LEE'),
		('1009', '9009', '2016-9-23', '14:20', '20:20', 'SHANE SMITH');


INSERT INTO Passenger  (ID, NAME, PHONE) VALUES
		('7654321', 'BILLY BOB', 		'987-987-9877'),
		('1234567', 'HARRY JOE', 		'321-685-4565'),
		('8765432', 'JACK JOHNSON',		'127-135-5644'),
		('2345678', 'MARY BLIGE', 		'321-654-3512'),
		('9834543', 'CHRIS CARTER', 	'983-231-9842'),
		('9873453', 'CHRIS ChARTER', 	'555-231-9842'),
		('3456789', 'WILL SMITH', 		'654-987-6846');


INSERT INTO Plane VALUES
		('BOEING', '727', 'MODEL E', '2016-9-23','2016-2-23'),
		('BOEING', '787', 'MODEL F', '2016-10-23','2016-2-23'),
		('BOEING', '757', 'MODEL G', '2016-11-23','2016-2-23'),
		('BOEING', '1234', 'MODEL H', '2016-12-23','2016-2-23'),
		('BOEING', '1254', 'MODEL I', '2016-01-23','2016-2-23'),
		('BOEING', '1876', 'MODEL J', '2016-3-23','2016-2-23'),
		('BOEING', '8765', 'MODEL K', '2016-2-23','2016-2-23' );


	
INSERT INTO PlaneSeats (Maker, Model, SeatType, NoOfSeats) VALUES 
		('AA', '955', '00', 200),
		('AW', '985', '11', 290),
		('BA', '394', '22', 300),
		('BD', '727', '55', 210),
		('CA', '747', '44', 280),
		('EA', '737', '33', 160),
		('OT', '757', '23', 120);

INSERT INTO PlaneType (Maker, Model, FlyingSpeed, GroundSpeed) VALUES 
		('AIRBUS', 'A300', 520, 100),
		('AIRBUS', 'A320', 600, 80),
		('MD', 'MD11', 650, 90),
		('MD', 'SUPER80', 550, 90),
		('BOEING', '727', 510, 100),
		('BOEING', '787', 810, 100),
		('BOEING', '757', 740, 100);

INSERT INTO Pilot (ID, Name, DateHired) VALUES 
	(0001, 'Jones', '1990-10-5'),
	(0002, 'Adams', '1990-6-1'),
	(0003, 'Walker', '1991-7-2'),
	(0004, 'Flores', '1992-4-1'),
	(0005, 'Thompson', '1992-4-10'),
	(0006, 'Dean', '1993-9-2'),
	(0007, 'Carter', '1994-8-1');


INSERT INTO Reservation VALUES
( 7654321, 123, '2016-1-1', 'DFW', 'LAX', 'FIRST', '2016-1-1',  '2016-1-1' ),
( 1234567, 222, '2016-1-1', 'DFW', 'LAX', 'FIRST', '2016-1-1',  '2016-1-1' ),
( 8765432, 333, '2016-1-1', 'DFW', 'LAX', 'FIRST', '2016-1-1',  '2016-1-1' ),
( 2345678, 444, '2016-1-1', 'DFW', 'LAX', 'FIRST', '2016-1-1',  '2016-1-1' ),
( 9876543, 555, '2016-1-1', 'DFW', 'LAX', 'FIRST', '2016-1-1',  '2016-1-1' ),
( 3456789, 666, '2016-1-1', 'DFW', 'LAX', 'FIRST', '2016-1-1',  '2016-1-1' );

		
								