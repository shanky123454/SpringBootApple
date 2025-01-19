package com.jdbc.demo;
import java.sql.*;

import com.jdbc.in.Util1;

//  Non-Select Operation(DML,DDL,...)
public class jdbc11 {

	 public static void main(String[] args) throws ClassNotFoundException, SQLException
	    {
		  
		   PreparedStatement pstmt = null;
		   Connection connection =null;
		  
	      
		   	try {
		   		String sqlinsertquery = "insert into student_info (id,name,city)values(?,?,?)";
		   		connection = Util1.getconnection();
		   		if(connection!=null)
		   		{
		   			pstmt = connection.prepareStatement(sqlinsertquery);
		   		}
		   		
		   		if(pstmt!=null)
		   		{
		   			pstmt.setInt(1,5);
		   			pstmt.setString(2, "marwari");
		   			pstmt.setString(3, "dhanbad");
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
	    
	        
	        
	    


