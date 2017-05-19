/*
Class: CSE 3330
Semester: Fall 2016
Student Name: Nghiem, Harris, hpn2896
Student ID: 1000572896
Assignment: project #2
*/

/*
--Retrieve all flight IDs that include meals. Selecting all values from Flight where the meal is not null
*/
SELECT * FROM Flight where MEAL != 'NULL';

/*
--Retrieve the model and flying speed of every plane type made by Boeing. Select from the table PlaneType all the planes made by Boeing, and show their Model and Flyingspeed
*/
SELECT MODEL, FLYINGSPEED FROM PlaneType WHERE MAKER = 'Boeing';

/*
--Selecting from Table Plane, PlaneType, return ID, MAKE, MODEL WHERE Flyingspeed or GroundSpeed > 1000
*/
SELECT DISTINCT ID, Plane.MAKER, Plane.MODEL FROM Plane,PlaneType WHERE GROUNDSPEED > 100 OR FLYINGSPEED > 100;

/*
--Another way to write. Retrieve all flight IDs with their respective meals that only have meals. Select from the table Flight where the meals are not null, and return the
-- Flight Number(FLNO), AND MEAL
--/*SELECT FLNO,MEAL from Flight where Meal = 'VEGAN' or Meal = 'STEAK AND LOBSTER' or Meal = 'SUSHI' OR Meal = 'HAMBURGER' OR Meal = 'HOT DOG';
*/

/*
--Retrieve the name of every pilot that has flown an Airbus 380
--Plane.Maker & Model -> FlightLeg.Plane, FlightLeg.FLNO-> FlightLegInstance.FLNO, FlightLegInstance.Pilot -> Pilot.ID... Return name
*/

SELECT DISTINCT p.Name 
from Pilot p 
join FlightLegInstance f On f.Pilot = p.ID 
join FlightLeg g On g.FLNO = f.FLNO 
join Plane h on h.ID = g.Plane 
where h.Maker = 'AIRBUS' AND h.Model ='380';

/*
--Retrieve the total number of seats available on planes
--Add up the number of total seats on all the planes
*/
select sum(NoOfSeats) from PlaneSeats;

/*
--Retrieve total number of 'F' class seats booked and not cancelled after '2015-09-13'
--Pull all seat classes from Reservation and count the number of rows. Omitted the date cancellation
due to NULL
*/

select COUNT(SeatClass) 
From Reservation 
Where SeatClass ='F';

/*
--If default was not null.. code would be as follows
--select COUNT(SeatClass) From Reservation Where SeatClass ='F' & DataCancelled > '2015-09-13;
*/

