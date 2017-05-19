--Class:	CSE3330
--Semester:	Spring2016
--Student Name:	Lennix,Emmanuel
--Student ID:	1001104990
--Assignment:	project#2
;


SELECT Name 
FROM Passenger 
WHERE Name 
LIKE 'FR%';

SELECT State,COUNT(*) 
From Airport 
WHERE State = 'NY'
GROUP BY State;


SELECT DISTINCT FLNO 
FROM FlightLeg 
WHERE FromA = 'DFW' OR ToA= 'DFW';

SELECT P.Maker, COUNT(*)
FROM PlaneType A, Plane P
WHERE A.Maker = P.Maker AND A.Model = P.Model
GROUP BY P.Maker
; 

SELECT DISTINCT Name, Phone 
FROM Passenger,Reservation 
WHERE ID = PassID AND DateBooked="2015-9-15" AND DateCancelled IS NULL;
