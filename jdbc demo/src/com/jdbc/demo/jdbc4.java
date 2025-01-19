package com.jdbc.demo;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//  Non-Select Operation(DML,DDL,...)
public class jdbc4 {

	 public static void main(String[] args) throws ClassNotFoundException, SQLException
	    {
		  Connection connection =null;
	        try{
//	        Class.forName("com.mysql.cj.jdbc.Driver");
//	        System.out.println("driver loaded sucessfully");
	        	
	        	//=================================================
	        connection = DriverManager.getConnection("jdbc:mysql:///student", "root", "Shanky@123");
	       System.out.println("connection get establish");
	       System.out.println(connection.getClass().getName());

	       String sqlquery = "update student_info set id=3 where id=5";
	       Statement statement = connection.createStatement();
	       int roweffected = statement.executeUpdate(sqlquery);

	      System.out.println("no of row effected =" + roweffected);
	      
	      System.out.println("=================================================");
	      
	      String sqlquery1 = "update student_info set id=4 where id=6";
	      int roweffected1 = statement.executeUpdate(sqlquery1);
	      System.out.println("no of row effected =" + roweffected1);

	    }catch(Exception cne)
	    {
	       cne.printStackTrace();
	    }
	        if(connection!=null)
	        {
	            try{
	            connection.close();
	            }catch(SQLException e)
	            {
	                e.printStackTrace();
	            }
	        }
	     
	        
	    }

}
