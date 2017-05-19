/**
Class:         CSE 3330
Semester:       Fall 2016
Student Name:   Nghiem,Harris, hpn2896
Student ID:     1000572896
**/

import java.sql.*;
import java.util.Scanner;

public class test {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/hpn2896"; //<-- replace your database name with xxx

   //  Database credentials
   static final String USER = "hpn2896";	//<-- replace your username with xxx
   static final String PASS = "Hello2016";	//<-- replace your mysql password with xxx
   
   public static void main(String[] args) {
   Connection conn = null;
      PreparedStatement  stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      
      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      String sql;
      sql = "select f.FromA FROM_AIRPORT, f.ToA TO_AIRPORT, s.SeatType, s.NoOfSeats Number_Seats_Available " +
            "from FlightLegInstance i, FlightLeg f, Plane p, PlaneSeats s " +
            "where i.FLNO = f.FLNO and i.Seq=f.Seq and p.ID = f.Plane and p.Maker = s.Maker and p.Model = s.Model and " +
            "f.FromA = ? and f.ToA = ? and s.SeatType = ? " +
            "group by f.FromA, f.ToA, s.SeatType " +
            "order by f.FromA, f.ToA ";
      stmt = conn.prepareStatement(sql);
      Scanner inputObj = new Scanner(System.in); //Create a new input object called inputObj
      System.out.print("Please enter 'FROM_AIRPORT': ");
      String fromAirport = inputObj.next(); //Prompts the user to enter something
      System.out.print("Please enter 'To_AIRPORT': ");
      String toAirport = inputObj.next(); //Prompts the user to enter something
      System.out.print("Please enter 'SEAT_TYPE': ");
      String seatTYPE = inputObj.next(); //Prompts the user to enter something
      stmt.setString(1,fromAirport);
      stmt.setString(2,toAirport);
      stmt.setString(3,seatTYPE);
      ResultSet rs = stmt.executeQuery(); //Runs the query
      
      //Print Column names
        System.out.print("FROM_AIRPORT ");
        System.out.print("TO_AIRPORT ");
        System.out.print("SeatType ");
        System.out.println("Number_Seats_Available");
    
        //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         System.out.print(rs.getString("FROM_AIRPORT"));
         System.out.print(" ");
         System.out.print(rs.getString("TO_AIRPORT"));
         System.out.print(" ");
         System.out.print(rs.getString("SeatType"));
         System.out.print(" ");
         System.out.println(rs.getString("Number_Seats_Available"));
      }
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
}//end FirstExample