package com.jdbc.demo;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc5 {

	 public static void main(String[] args) throws ClassNotFoundException, SQLException
	    {
		  Connection connection =null;
	        try{
//	      

	        connection = DriverManager.getConnection("jdbc:mysql:///student", "root", "Shanky@123");
	       System.out.println("connection get establish");
	       System.out.println(connection.getClass().getName());

	       String sqlquery = " drop table student_info";
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
