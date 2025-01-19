package com.jdbc.demo;
import java.util.*;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import com.jdbc.in.Util;

//DateOfBirth
//DateOfMarriage
public class javadate
{

public static void main(String[] args) 
{
	Connection conn= null;
	PreparedStatement pstmt = null;
	int res = 0;
	java.sql.Date dateu =null;
	java.sql.Date qwerty =null;
	Scanner sc = new Scanner(System.in);
	
	try {
		String insertquery = "update student_info set DateOfBirth=? ,DateOfMarriage=? where id =?";
		conn= Util.getconnection();
		
		if(conn!=null)
		{
			pstmt = conn.prepareStatement(insertquery);
		}
		if(pstmt!=null)
		{
			
		System.out.println("enter the D.O.B : (yyyy-MM-dd)");
	    String date = sc.next();
	    if(date!=null)
	    {
	    SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date d = sdf.parse(date);
			long l = d.getTime();
	     dateu  = new java.sql.Date(l);
	    System.out.println(dateu);
	    }
	    System.out.println("enter the D.O.M : (yyyy-MM-dd)");
	    String date1 = sc.next();
	    if(date1!=null)
	    {
	    	 qwerty = java.sql.Date.valueOf(date1);
	    	 System.out.println(qwerty);
	    }
	    
		System.out.println("enter the id :");
		int sid = sc.nextInt();
	    pstmt.setDate(1,dateu );
	    pstmt.setDate(2, qwerty);
	    pstmt.setInt(3, sid);
	    res= pstmt.executeUpdate();
	    System.out.println("no of roweffected is:" + res);
		
		}
	} catch (SQLException | IOException e) {
		e.printStackTrace();
	}
	catch(Exception pe)
	{
		pe.printStackTrace();
	}
	finally {
		try {
			Util.cleanup(conn, pstmt, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sc.close();
	}
}	
}


	
