package com.jdbc.demo;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//  Non-Select Operation(DML,DDL,...)
public class jdbc3 {

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

	       String sqlquery = "alter table student_info add column email varchar(10) unique key";
	       Statement statement = connection.createStatement();
	       int roweffected = statement.executeUpdate(sqlquery);
	      System.out.println("no of row effected =" + roweffected);

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
