/*
--Class:        CSE 3330
--Semester:     Spring 2016
--Student Name: Lennix Emmanuel
--StudentID:    1001104990
--Assignment:   project#3
*/
/*--P1*/
SELECT ID,Maker,Model
FROM Plane
WHERE LastMaintA IN
(SELECT Code
FROM Airport
WHERE State='NY');

/*--P2*/
SELECT SeatType, SUM(NoOfSeats)
FROM	PlaneSeats S, Plane P
WHERE S.Maker = P.Maker AND S.Model = P.Model
GROUP BY SeatType;

/*--P3*/
SELECT DISTINCT Maker,Model
FROM Plane , FlightLeg
WHERE Plane=ID AND ToA IN
(SELECT Code
FROM Airport
WHERE State='TX');

/*--P4*/
SELECT DISTINCT Name
FROM Pilot P ,FlightLegInstance FLI
WHERE P.ID=FLI.Pilot AND  (FLI.Seq,FLI.FLNO) IN 
(SELECT Seq,FLNO
FROM FlightLeg, Airport
WHERE FromA=Code AND State = 'TX');



/*--P5*/
SELECT DISTINCT Name
FROM Reservation, Passenger
WHERE PassID=ID 
AND FromA IN 
(SELECT CODE 
FROM Airport
WHERE State='TX') 
AND ToA IN
(SELECT CODE
FROM Airport
WHERE State='NY');

/*--P6*/
SELECT FLNO
FROM Flight F
WHERE F.FLNO IN
(SELECT FLNO
FROM FlightLeg
GROUP BY FLNO
HAVING COUNT(FLNO) >1);

/*--P7
SELECT F.FLNO,A.City,A.State
FROM Flight F,Airport A, Airport B
WHERE F.FLNO IN (SELECT FLNO FROM FlightLeg GROUP BY FLNO HAVING COUNT(FLNO) =2);*/		 
