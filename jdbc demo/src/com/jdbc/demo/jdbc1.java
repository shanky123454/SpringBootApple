package com.jdbc.demo;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc1 {

	 public static void main(String[] args) throws ClassNotFoundException, SQLException
	    {
		  Connection connection =null;
	        try{
//	        Class.forName("com.mysql.cj.jdbc.Driver");
//	        System.out.println("driver loaded sucessfully");
	        	
	        	//=================================================
//	        	Q> What is autoloading in JDBC?
//	        			Loading and register the driver is done automatically,based on the url
//	        			supplied by the user.
//	        			Behind the scenes
//	        			a. check the url
//	        			b. based on the url supplied, go to classpath environmental variable
//	        			c. open the relevant jar
//	        			d. go to META-INF/services folder
//	        			e. open java.sql.Driver file
//	        			f. read the file and load the class supplied in the file
//
//	        			Note:
//	        			Using resultSet object, we can retrieve the records based on the column names
//	        			also.
//	        			If java pgm and database engine is running in the same machine with the default
//	        			port no for database then
//	        			url can be of the following type
//
//	        			String url = "jdbc:mysql:///octbatch".

	        connection = DriverManager.getConnection("jdbc:mysql:///student", "root", "Shanky@123");
	       System.out.println("connection get establish");
	       System.out.println(connection.getClass().getName());

	       String sqlquery = "select id,name,city,phone_number from student_info";
	       Statement statement = connection.createStatement();
	       ResultSet resultSet = statement.executeQuery(sqlquery);
	       System.out.println("Id\t\tName\t\tCity\t\tPhone_number");

	       while(resultSet.next())
	       {
	         Integer sid= resultSet.getInt("id");
	         String sname=resultSet.getString("name");
	         String scity=resultSet.getString("city");
	         String sphone=resultSet.getString("phone_number");

	         System.out.println(sid+"\t\t"+sname+"\t\t"+scity+"\t\t"+sphone );
	       }

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
