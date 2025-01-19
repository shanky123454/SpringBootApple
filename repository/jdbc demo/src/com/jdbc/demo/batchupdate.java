package com.jdbc.demo;
import com.jdbc.in.Util;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class batchupdate {
	public static void main(String[] args)
	{
	Connection con = null;
	PreparedStatement pstmt= null;
	int[] roweffected = new int[20];
	Scanner sc = new Scanner (System.in);
	java.sql.Date sdate =null;
	java.sql.Date qwerty = null;
	
	
	try
	{
		 con = Util.getconnection();
		 String Sqlquery = "insert into student_info(id,name,city,DateOfBirth,DateOfMarriage) values(?,?,?,?,?)";
		 if(con!=null)
		 {
			pstmt = con.prepareStatement(Sqlquery);
		 }
		 if(pstmt!=null)
		 {
			 while(true)
			 {
				 System.out.println("enter the id of the student");
				 int sid =sc.nextInt();
				 System.out.println("enter the name of the student");
				 String sname = sc.next();
				 System.out.println();
				 System.out.println("enter the city of the student");
				 String scity = sc.next();
				 System.out.println();
				 System.out.println("enter the D.O.B of the student :(MM-dd--yyyy)");
				 String ddob = sc.next();
				 if(ddob!=null)
				 {
					 SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
					  java.util.Date udate =sdf.parse(ddob);
					  long l =udate.getTime();
					   sdate =  new java.sql.Date(l);
					  System.out.println(sdate);
				 }
				 
				 System.out.println("enter the D.O.M of the student :(yyyy--MM-dd)");
				 String sdom = sc.next();
				 if(sdom!=null)
				 {
					 qwerty = java.sql.Date.valueOf(sdom);
					 System.out.println(qwerty);
				 }
				 pstmt.setInt(1, sid);
				 pstmt.setString(2, sname);
				 pstmt.setString(3, scity);
				 pstmt.setDate(4, sdate);
				 pstmt.setDate(5, qwerty);
				 
				 pstmt.addBatch();
				 
				 System.out.println("Do u want to insert more record [yes/no]");
				 String input = sc.next();
				 
				 if(input.equalsIgnoreCase("yes"))
				 {
					 continue;
				 }
				 
				 else
				 {
					 break;
				 }
				 
			 }
			 
			pstmt.executeBatch();
			System.out.println("record inserted successfully");
		 }
		 
	}catch(Exception er)
	{
		er.printStackTrace();
	}finally
	{
		try {
			Util.cleanup(con, pstmt, null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
}
