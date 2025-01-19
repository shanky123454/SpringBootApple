package com.jdbc.demo;
import java.sql.*;


import java.util.Scanner;

import com.jdbc.in.Util1;

//  Non-Select Operation(DML,DDL,...)
public class jdbc15 {

	 public static void main(String[] args) throws ClassNotFoundException, SQLException
	    {
		  
		   PreparedStatement pstmt = null;
		   Connection connection =null;
		   ResultSet set= null;
		   Scanner sc = new Scanner(System.in);
		   int sid=0;
		   int rowcount=0;
		
		   	try {
		   		String sqlselectquery = "update student_info set name=? where id=?";
		   		connection = Util1.getconnection();
		   		if(connection!=null)
		   		{
		   			pstmt = connection.prepareStatement(sqlselectquery);
		   		}
		   		
		   		if(pstmt!=null)
		   		{
		   			System.out.println("enter the id");
		   			 sid = sc.nextInt();
		   			 System.out.println("enter the new name to update");
		   			String sname=sc.next();
		   			 pstmt.setString(1, sname);
		   			 pstmt.setInt(2, sid);
		   			 System.out.println();
		   		     rowcount =pstmt.executeUpdate();	
		   	    }
		   		if(rowcount!=0)
		   		{
		   			System.out.println("no of rows effected:"+rowcount);
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
		   		Util1.cleanup(connection, pstmt,set );
		   	}catch(Exception e1)
		   		{
		   		e1.printStackTrace();
		   		}
		   	}
	    
}
}
	    
	        
	        
	    


