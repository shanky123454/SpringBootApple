package com.jdbc.demo;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc6 {

	 public static void main(String[] args) throws ClassNotFoundException, SQLException
	    {
		  Connection connection =null;
	        try{
//	      

	        connection = DriverManager.getConnection("jdbc:mysql:///student", "root", "Shanky@123");
	       System.out.println("connection get establish");
	       System.out.println(connection.getClass().getName());

	       String sqlquery =  "create table student_info ( id int(10) primary key,name varchar(10), city varchar(10));"; 
	       		
	       Statement statement = connection.createStatement();
	       int a = statement.executeUpdate(sqlquery);
	     System.out.println("no of rows affected=" + a);

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
