
-- Class:               CSE 3330
-- Semester:            Spring 2016
-- Student Name:        Lennix,Emmanuel,ejl4990
-- Student ID:          1001104990
-- Assignment:          project #1



UPDATE Airport SET Code = 'UNO' WHERE Code ='DFW';
UPDATE Passenger SET ID=9999 WHERE ID = 1;
UPDATE Pilot SET ID=9999 WHERE ID = 1;
UPDATE PlaneType SET Model='Cool' WHERE Model = 'SUPER80';
UPDATE FlightLeg SET Seq =9999 WHERE Seq = 1;

SElECT * FROM PlaneType;
SELECT * FROM Plane;
SELECT * FROM Airport;
SELECT * FROM Reservation;
SELECT * FROM FlightLeg;
SELECT * FROM FlightLegInstance;
SELECT * FROM Pilot;
