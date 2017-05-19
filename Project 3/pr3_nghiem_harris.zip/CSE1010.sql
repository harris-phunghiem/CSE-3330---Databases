/*
Class: CSE 3330
Semester: Fall 2016
Student Name: Nghiem, Harris, hpn2896
Student ID: 1000572896
*/

/* This will create a view of atable called Airport_Flights. It will
retrieve the Airport Code, City, State, Flight #, Dep Time. It will 
list all flights from a particular airpot w times of dep by
joining Flightleg and Airport*/

CREATE OR REPLACE VIEW Airport_Flights  AS 
select a.Code  Airport_Code, a.City City, a.State State, f.Flno Flight_Number, 
f.DeptTime  Departure_Time from FlightLeg f, Airport a 
where  f.froma =a.code
order by a.code;

/*Creates a view of a table called Airport_Plane_Arrivals that counts
the number of daily arrivals for airport by planetype by joining FlightLeg, FlightLegInstance,
Plane, PlaneType and Airport*/

CREATE OR REPLACE VIEW Airport_Plane_Arrivals  AS (
select l.ToA Airport_Code, a.City City, a.State State, p.Maker, p.Model, count(p.ID) NumberOf_Daily_Arrivals
from FlightLeg l, Plane p, PlaneType pt, Airport a
where  p.ID = l.Plane and p.Maker = pt.Maker and p.Model = pt.Model and a.Code = l.ToA
group by l.ToA, a.City, a.State, p.Maker, p.Model);

/*Creates a view of a table Airport_To_Airport_Capcity that joins 4 tables and returns number of seats 
available from one airport to another, as well as the seat types. */

CREATE OR REPLACE VIEW Airport_To_Airport_Capacity  AS
select f.FromA FROM_AIRPORT, f.ToA TO_AIRPORT, s.SeatType, s.NoOfSeats Number_Seats_Available
from FlightLegInstance i, FlightLeg f, Plane p, PlaneSeats s
where i.FLNO = f.FLNO and i.Seq=f.Seq and p.ID = f.Plane and p.Maker = s.Maker and p.Model = s.Model
group by f.FromA, f.ToA, s.SeatType
order by f.FromA, f.ToA