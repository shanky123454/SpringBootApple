package com.jdbc.demo;
import java.sql.*;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//  Non-Select Operation(DML,DDL,...)
public class jdbc_8_copy {

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
//	       System.out.println("enter the id of the student");
//	       int id = sc.nextInt();
	       System.out.println("enter the name of the student");
	       String name1 = sc.next();
	       System.out.println("enter the city if the student");
	       String city1 = sc.next();
	      String sqlquery = String.format("select id,name,city from student_info where (name,city) IN('%s','%s')",name1,city1 );
	      //String sqlquery = "select count(*) from student_info where name= '"+ name1+"' and city='"+city1+"' ";
	       //String sqlquery = "select id,name,city from student_info where name= '"+ name1+"' and city='"+city1+"' ";
	        statement = connection.createStatement();
	       ResultSet  roweffected = statement.executeQuery(sqlquery);
	       
	       System.out.println(sqlquery);

//			ResultSet resultSet = statement.executeQuery(sqlquery);
//			int row = 0;
//			if (resultSet.next()) {
//				row = resultSet.getInt(1);
//			}
//			System.out.println("record present in table:"+row);
//
//			if (row>=0)
//				System.out.println("valid credentials");
//			else
//				System.out.println("invalid credentials");
	       
	       if(roweffected!=null)
	       {
	       System.out.println("SID\t SNAME\t SCITY");
	       
	    
//	    	   ResultSet resultset = statement.getResultSet();
	    	   while(roweffected.next())
	    	   {
	    		   int sid = roweffected.getInt("id");
	    		   String sname = roweffected.getString("name");
	    		   String scity = roweffected.getString("city");
	    		   
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
