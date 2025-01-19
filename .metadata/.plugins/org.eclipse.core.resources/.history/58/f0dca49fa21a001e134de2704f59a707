package com.jdbc.demo;
import java.sql.*;

import java.util.Scanner;

import com.jdbc.in.Util1;

//  Non-Select Operation(DML,DDL,...)
public class jdbc13 {

	 public static void main(String[] args) throws ClassNotFoundException, SQLException
	    {
		  
		   PreparedStatement pstmt = null;
		   Connection connection =null;
		   ResultSet set= null;
		   Scanner sc = new Scanner(System.in);
		   int sid=0;
		  
	      
		   	try {
		   		String sqlselectquery = "select id,name,city from student_info where id=?";
		   		connection = Util1.getconnection();
		   		if(connection!=null)
		   		{
		   			pstmt = connection.prepareStatement(sqlselectquery);
		   		}
		   		
		   		if(pstmt!=null)
		   		{
		   			System.out.println("enter the id");
		   			 sid = sc.nextInt();
			   		pstmt.setInt(1, sid);
		   		    set=pstmt.executeQuery();
		   		}
		   		
		   	if(set!=null)
		   	{
		   		if(set.next())
		   		{
		   			System.out.println("SID\t SNAME\t SCITY");
		   			   int  id=   set.getInt(1);
		   			  String name = set.getString(2);
		   			  String city = set.getString(3);
		   			
		   		//System.out.println();
		   			 System.out.println(id + "\t" + name +"\t" + city);
		   		}
		   		else
		   		{
		   			System.out.println("invalid id please enter the correct id");
		   		}
		   			
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
	    
	        
	        
	    


