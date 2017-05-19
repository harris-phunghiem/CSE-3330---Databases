/**
Class::         CSE 3330
Semester:       Fall 2016
Student Name:   Nghiem,Harris, hpn2896
Student ID:     1000572896
**/

import java.sql.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class test2 {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/hpn2896"; //<-- replace your database name with xxx

   //  Database credentials
   static final String USER = "hpn2896";	//<-- replace your username with xxx
   static final String PASS = "Hello2016";	//<-- replace your mysql password with xxx
   static Connection conn = null;
   
   public static void main(String[] args) {
   PreparedStatement  stmt = null;
    
    String passengerName = null; //Prompts the user to enter string
    String phoneNumber = null; //Prompts the user to enter something
    String sql = null;
    String flightNumber = null;
    String fromAirport = null; //Prompts the user to enter something
    String toAirport = null; //Prompts the user to enter something
    String seatClass = null; //Prompts the user to enter something
    String flightDay= null; //Prompts the user to enter something
    String flightMonth= null; //Prompts the user to enter something
    String flightYear= null; //Prompts the user to enter something
    ResultSet rs = null;



    try{
        //STEP 2: Register JDBC driver
        Class.forName("com.mysql.jdbc.Driver");

        //STEP 3: Open a connection
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL,USER,PASS);

        //STEP 4: Execute a query
        System.out.println("Creating statement...");
        sql = "select count(*) Existsifmorethan0 from Passenger " +
              "where name = ? and phone = ?";
        stmt = conn.prepareStatement(sql);
        Scanner inputObj = new Scanner(System.in); //Create a new input object called inputObj
        
        //Prompts the user for Passenger Name
        System.out.print("Please enter 'Passenger Name': ");
        boolean hasSpecialChar = true;
        while(hasSpecialChar)
        {
          passengerName = inputObj.nextLine();
          if (passengerName.equals("/Q"))
          {
            rs.close();
            stmt.close();
            conn.close();
          }
          Pattern p = Pattern.compile("[^a-zA-Z ]");
          hasSpecialChar = p.matcher(passengerName).find();
          if (hasSpecialChar == true)
              System.out.print("Please try again and enter 'Passenger Name': ");     
        }
        
        //Prompts the user for Phone Number
        System.out.print("Please enter 'Phone number (XXXXXXXXXX)': ");
        boolean numberSpecialChar = true;
        while(numberSpecialChar)
        {
            phoneNumber = inputObj.next();
            if (phoneNumber.equals("/Q"))
            {
                rs.close();
                stmt.close();
                conn.close();
                }
            Pattern p = Pattern.compile("[^0-9]");
            numberSpecialChar = p.matcher(phoneNumber).find();
            int length = String.valueOf(phoneNumber).length();
            if(length == 10 && numberSpecialChar == false)
            {
                numberSpecialChar = false;
            }
            else
            {
                numberSpecialChar = true;
            }
          System.out.print("You entered: ");
          System.out.print(phoneNumber);
          System.out.print("\n");
          if(numberSpecialChar == true)
              System.out.print("Please try again and enter 'Phone Number': ");     
        }    
        
        //Prompts the user for Flight Number (Should be int XXX)
        System.out.print("Please enter 'Flight Number (XXX)': ");
        boolean flightNumberSpecialChar = true;
        boolean flag = true;
        while(flag)
        {
          //Prompts the user to enter something
          flightNumber = inputObj.next();
          if (flightNumber.equals("/Q"))
            {
                rs.close();
                stmt.close();
                conn.close();
                }
          Pattern p = Pattern.compile("[0-9][0-9][0-9]$");
          flightNumberSpecialChar = p.matcher(flightNumber).find(); //Should return true
          int length = flightNumber.length();
          if(length == 3 && flightNumberSpecialChar == true && checkFlight(flightNumber))
          {
              flag = false;
          }
          else
          {
              flag = true;
          }
          System.out.print("You entered: ");
//          System.out.print(flightNumberSpecialChar);
          System.out.print(flightNumber);
          System.out.print("\n");
          if(flag == true )
              System.out.print("Please try again and enter 'Flight': ");  
        } 

        
        //Prompts the user for the Date
        
        //Month first
        System.out.print("Please enter 'Flight Date Month (XX)': ");
        boolean flightMonthSpecialChar = true;
        while(flightMonthSpecialChar)
        {
          flightMonth = inputObj.next(); //Prompts the user to enter something
          if (flightMonth.equals("/Q"))
            {
                rs.close();
                stmt.close();
                conn.close();
                }
          Pattern p = Pattern.compile("[^0-9]");
          flightMonthSpecialChar = p.matcher(flightMonth).find();
          int length = String.valueOf(flightMonth).length();
          if((length == 1 || length == 2) && flightMonthSpecialChar == false)
          {
              flightMonthSpecialChar = false;
          }
          else
          {
              flightMonthSpecialChar = true;
          }
          System.out.print("You entered: ");
          System.out.print(flightMonth);
          System.out.print("\n");
          if(flightMonthSpecialChar == true)
              System.out.print("Please try again and enter 'Flight Month': ");     
        }    
        
        //Days Second
        System.out.print("Please enter 'Flight Date Day (XX)': ");
        boolean flightDaySpecialChar = true;
        while(flightDaySpecialChar)
        {
          flightDay = inputObj.next(); //Prompts the user to enter something
           if (flightDay.equals("/Q"))
            {
                rs.close();
                stmt.close();
                conn.close();
                }
          Pattern p = Pattern.compile("[^0-9]");
          flightDaySpecialChar = p.matcher(flightDay).find();
          int length = String.valueOf(flightDay).length();
          if((length == 1 || length == 2) && flightDaySpecialChar == false)
          {
              flightDaySpecialChar = false;
          }
          else
          {
              flightDaySpecialChar = true;
          }
          System.out.print("You entered: ");
          System.out.print(flightDay);
          System.out.print("\n");
          if(flightDaySpecialChar == true)
              System.out.print("Please try again and enter 'Flight Month': ");     
        }    
        
         //Year Last
        System.out.print("Please enter 'Flight Date Year (XXXX)': ");
        boolean flightYearSpecialChar = true;
        while(flightYearSpecialChar)
        {
            flightYear = inputObj.next();  
            if (flightYear.equals("/Q"))
            {
                rs.close();
                stmt.close();
                conn.close();
                }
          Pattern p = Pattern.compile("[^0-9]");
          flightYearSpecialChar = p.matcher(flightYear).find();
          int length = String.valueOf(flightYear).length();
          if(length == 4 && flightYearSpecialChar == false)
          {
              flightYearSpecialChar = false;
          }
          else
          {
              flightYearSpecialChar = true;
          }
          System.out.print("You entered: ");
          System.out.print(flightYear);
          System.out.print("\n");
          if(flightYearSpecialChar == true)
              System.out.print("Please try again and enter 'Flight Date Year': ");     
        }    

        //Prompts the user for the From_Airport
        System.out.print("Please enter 'From_Airport (XXX)': ");
        boolean fromAirportSpecialChar = true;
        while(fromAirportSpecialChar)
        {
          fromAirport = inputObj.next().toUpperCase();
         if (fromAirport.equals("/Q"))
            {
                rs.close();
                stmt.close();
                conn.close();
                }
          Pattern p = Pattern.compile("[^a-zA-Z]");
          fromAirportSpecialChar = p.matcher(fromAirport).find();
          int length = String.valueOf(fromAirport).length();
          if(length == 3 && fromAirportSpecialChar == false && checkFromAirport(fromAirport))
          {
              fromAirportSpecialChar = false;
          }
          else
          {
              fromAirportSpecialChar = true;
          }
          System.out.print("You entered: ");
          System.out.print(fromAirport);
          System.out.print("\n");
          if(fromAirportSpecialChar == true)
              System.out.print("Please try again and enter 'From_Airport': ");     
        }    
        
        
        //Prompts the user for the To_Airport
        System.out.print("Please enter 'To_Airport (XXX)': ");
        boolean toAirportSpecialChar = true;
        while(toAirportSpecialChar)
        {
          toAirport = inputObj.next().toUpperCase(); //Prompts the user to enter something
          if (toAirport.equals("/Q"))
            {
                rs.close();
                stmt.close();
                conn.close();
                }
          Pattern p = Pattern.compile("[^a-zA-Z]");
          toAirportSpecialChar = p.matcher(toAirport).find();
          int length = String.valueOf(toAirport).length();
          if(length == 3 && toAirportSpecialChar == false && checkToAirport(toAirport))
          {
              toAirportSpecialChar = false;
          }
          else
          {
              toAirportSpecialChar = true;
          }
          System.out.print("You entered: ");
          System.out.print(toAirport);
          System.out.print("\n");
          if(toAirportSpecialChar == true)
              System.out.print("Please try again and enter 'To_Airport': ");     
        }    
        
        //Prompts the user for the Seat_Class
        System.out.print("Please enter 'Seat_Class ( E or F )': ");
        boolean seatClassSpecialChar = true;
        while(seatClassSpecialChar)
        {
          seatClass = inputObj.next().toUpperCase();
          if (seatClass.equals("/Q"))
            {
                rs.close();
                stmt.close();
                conn.close();
                }
          Pattern p = Pattern.compile("[^e-fE-F]");
          seatClassSpecialChar = p.matcher(seatClass).find();
          int length = String.valueOf(seatClass).length();
          if(length == 1 && seatClassSpecialChar == false)
          {
              seatClassSpecialChar = false;
          }
          else
          {
              seatClassSpecialChar = true;
          }
          System.out.print("You entered: ");
          System.out.print(seatClass);
          System.out.print("\n");
          if(seatClassSpecialChar == true)
              System.out.print("Please try again and enter 'Seat_Class': ");     
        }  
      

//    System.out.println(":"+passengerName+":");
//    System.out.println(":"+phoneNumber+":");
    stmt.setString(1, passengerName);
    stmt.setString(2, phoneNumber);

    rs = stmt.executeQuery(); //Runs the query
    rs.next();
//    System.out.print("Number of rows is: ");
//    System.out.print(rs.getString("Existsifmorethan0"));
    
    //Gets the count of the rows from query 'sql'
    int countOfRows = Integer.parseInt(rs.getString("Existsifmorethan0"));
    
    //Finds the max id and auto increments by 1 to added new Passenger information

    String maxID = "select max(ID) MAXID from Passenger";
    Statement st = conn.prepareStatement(maxID);
    rs = st.executeQuery(maxID); //Runs the query
    rs.next();
    int maximumID = Integer.parseInt(rs.getString("MAXID"));
    maximumID += 1;
    String maxIDString = String.valueOf(maximumID);
    
        
    String dupID1 = null; 
    
    //Finds ID of person that is already in the system
    if (countOfRows > 0)
    {
        PreparedStatement  states = null;
        String dupID;
        dupID = "select ID DUPLICATEID from Passenger where name = ? and phone = ?";
        states = conn.prepareStatement(dupID);
        states.setString(1, passengerName);
        states.setString(2, phoneNumber);
        ResultSet rs1 = states.executeQuery(); //Runs the query
        rs1.next();
        int duplicate = Integer.parseInt(rs1.getString("DUPLICATEID"));
        dupID1 = String.valueOf(duplicate);
    }
//    System.out.println("The duplicated ID is");
//    System.out.println(dupID1);

    
    //Insert into Passenger values with new ID, P name and P number
    String insertSql;
    insertSql = "insert into Passenger values(?, ?, ?)";
    stmt = conn.prepareStatement(insertSql);
//    System.out.println("Trying to add new passenger");

    if ( countOfRows == 0 )
    {
        stmt.setString(1, maxIDString);
        stmt.setString(2, passengerName);
        stmt.setString(3, phoneNumber);
        stmt.executeUpdate();
        System.out.println("You have successfully added a new Passenger");
    }
    
    
    //If name and number exist exactly, show row of information 
    String retrieveDuplicate;
    retrieveDuplicate = "select ID, name, phone from Passenger where name = ? and phone = ?";
    PreparedStatement  state = null;
    state = conn.prepareStatement(retrieveDuplicate);
    if( countOfRows == 1)
    {
        state.setString(1, passengerName);
        state.setString(2, phoneNumber);
        state.executeQuery(); 
        System.out.println("This person was in the Database");
    }
    
    String date = new StringBuilder(flightYear).append(flightMonth).append(flightDay).toString();

    
    //Insert inputted values into Reservation table
    String insertReservation;
    insertReservation = "INSERT INTO `Reservation` VALUES(?,?,?,?,?,?,?,NULL)";
    state = conn.prepareStatement(insertReservation);
    
    if( countOfRows == 1)
    {
        state.setString(1, dupID1);
    }
    else
    {
        state.setString(1, maxIDString);
    }
    state.setString(2, flightNumber); 
    state.setString(3, "2015-10-06");
    state.setString(4, fromAirport);
    state.setString(5, toAirport);
    state.setString(6, seatClass);
    state.setString(7, "2016-12-08");

    state.executeUpdate();
    System.out.println("Reservation Created!");

    
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
   
public static boolean checkFlight(String flightNumber) throws SQLException
{
    String checkFlight;
    checkFlight = "select count(FLNO) COUNT from Flight where FLNO = ?";
    PreparedStatement stmt = conn.prepareStatement(checkFlight);
    stmt.setString(1, flightNumber);
    ResultSet rs = stmt.executeQuery();
    rs.next();
//    System.out.println("::" + rs.getString("COUNT"));
    
    if(rs.getString("COUNT").equals("0"))
    {
        return false;
    }
    return true;
}

public static boolean checkFromAirport(String fromAirport) throws SQLException
{
    String checkFromAirport;
    checkFromAirport = "select count(FromA) COUNT from Reservation where FromA = ?";
    PreparedStatement stmt = conn.prepareStatement(checkFromAirport);
    stmt.setString(1, fromAirport);
    ResultSet rs = stmt.executeQuery();
    rs.next();
//    System.out.println("::" + rs.getString("COUNT"));
    
    if(rs.getString("COUNT").equals("0"))
    {
        return false;
    }
    return true;
}


public static boolean checkToAirport(String toAirport) throws SQLException
{
    String checkToAirport;
    checkToAirport = "select count(FromA) COUNT from Reservation where ToA = ?";
    PreparedStatement stmt = conn.prepareStatement(checkToAirport);
    stmt.setString(1, toAirport);
    ResultSet rs = stmt.executeQuery();
    rs.next();
//    System.out.println("::" + rs.getString("COUNT"));
    
    if(rs.getString("COUNT").equals("0"))
    {
        return false;
    }
    return true;
}
}//end FirstExample