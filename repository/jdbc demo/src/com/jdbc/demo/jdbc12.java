package com.jdbc.demo;
import java.sql.*;
import java.util.Scanner;

import com.jdbc.in.Util1;

//  Non-Select Operation(DML,DDL,...)
public class jdbc12 {

	 public static void main(String[] args) throws ClassNotFoundException, SQLException
	    {
		  
		   PreparedStatement pstmt = null;
		   Connection connection =null;
		   Scanner sc = new Scanner(System.in);
		  
	      
		   	try {
		   		String sqlinsertquery = "insert into student_info (id,name,city)values(?,?,?)";
		   		connection = Util1.getconnection();
		   		if(connection!=null)
		   		{
		   			pstmt = connection.prepareStatement(sqlinsertquery);
		   		}
		   		
		   		if(pstmt!=null)
		   		{
		   			System.out.println("enter the id");
		   			int Id = sc.nextInt();
		   			System.out.println("enter the name");
		   			String name =sc.next();
		   			System.out.println("enter the city");
		   			String city = sc.next();
		   			
		   			pstmt.setInt(1,Id);
		   			pstmt.setString(2, name);
		   			pstmt.setString(3, city);
		   				System.out.println(sqlinsertquery);		
		   				
		   				int row = pstmt.executeUpdate();
		   				System.out.println("NO OF ROW EFFECTED IS:" + row);
		   		}
		   	}catch(SQLException e)
		   	{
		   		e.printStackTrace();
		   	}catch(Exception e2)
		   	{
		   		e2.printStackTrace();
		   	}
		   	finally {
		   		try {
		   		Util1.cleanup(connection, pstmt, null);
		   	}catch(Exception e1)
		   		{
		   		e1.printStackTrace();
		   		}
		   	}
	    }
}
	    
	        
	        
	    


