package com.jdbc.demo;
import java.sql.*;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//  Non-Select Operation(DML,DDL,...)
public class jdbc10 {

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
	       
	       System.out.println();
	       
	       Scanner sc = new Scanner(System.in);
	       int id = sc.nextInt();
	       String name = sc.next();
	       String city = sc.next();
	       String sqlquery = String.format("insert into student_info(id,name,city) values(%d,'%s','%s')",id,name,city);
	      // String sqlquery = "select id,name,city from student_info";
	       Statement statement = connection.createStatement();
	       boolean  roweffected = statement.execute(sqlquery);
	       
	       if(roweffected==false)
	       {
	    	   int count = statement.getUpdateCount();
	      System.out.println("no of row effected =" + count);
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
