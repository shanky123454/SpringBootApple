package com.jdbc.demo;
import java.sql.*;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//  Non-Select Operation(DML,DDL,...)
public class jdbc8 {

	 public static void main(String[] args) throws ClassNotFoundException, SQLException
	    {
		   Connection connection =null;
		   Statement statement = null;
	        try{
//	        Class.forName("com.mysql.cj.jdbc.Driver");
//	        System.out.println("driver loaded sucessfully");
	        	
	        	//=================================================
	        connection = DriverManager.getConnection("jdbc:mysql:///student", "root", "Shanky@123");
	       System.out.println("connection get establish");
	       System.out.println(connection.getClass().getName());
	       
	       System.out.println();
	       
	       Scanner sc = new Scanner(System.in);
	       System.out.println("enter the id of the student");
	       int id = sc.nextInt();
	       System.out.println("enter the name of the student");
	       String name = sc.next();
	       System.out.println("enter the city if the student");
	       String city = sc.next();
	       String sqlquery = "select id,name,city from student_info";
	 
	        statement = connection.createStatement();
	       boolean  roweffected = statement.execute(sqlquery);
	       
	       System.out.println("SID\t SNAME\t SCITY");
	       if(roweffected==true)
	       {
	    	   ResultSet resultset = statement.getResultSet();
	    	   while(resultset.next())
	    	   {
	    		   int sid = resultset.getInt("id");
	    		   String sname = resultset.getString("name");
	    		   String scity = resultset.getString("city");
	    		   
	    		  System.out.println(sid +"\t" + sname+ "\t" + scity); 
	    	   }
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
