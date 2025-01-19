package com.jdbc.demo;
import java.sql.*;
//import com.jdbc.in.*;
import java.util.*;

import com.jdbc.in.Util1;

//  Non-Select Operation(DML,DDL,...)
public class jdbc9 {

	 public static void main(String[] args) throws ClassNotFoundException, SQLException
	    {
		  
		   PreparedStatement pstmt = null;
		   Connection connection =null;
		   ResultSet resultset =null;
	      
		   	try {
		   		String sqlselectquery = "select id,name,city from student_info";
		   		connection = Util1.getconnection();
		   		if(connection!=null)
		   		{
		   			pstmt = connection.prepareStatement(sqlselectquery);
		   		}
		   		
		   		if(pstmt!=null)
		   		{
		   			System.out.printf("%5s %5s %5s","id","name","city");
		   			System.out.println();
		   			
		   		
		   				ResultSet id = pstmt.executeQuery(sqlselectquery);
		   				while(id.next())
		   				{
		   					int Id = id.getInt("id");
		   				String name = id.getString("name");
		   				String city = id.getString("city");
		   				System.out.printf("%5d %5s %5s",Id,name,city);
		   				System.out.println();
		   				}
		   			
		   		}
		   	}catch(Exception e)
		   	{
		   		e.printStackTrace();
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
	    
	        
	        
	    


