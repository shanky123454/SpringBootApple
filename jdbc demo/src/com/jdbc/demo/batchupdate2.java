package com.jdbc.demo;
import com.jdbc.in.Util;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class batchupdate2 {
	public static void main(String[] args)
	{
	Connection con = null;
	Statement pstmt= null;
	Scanner sc = new Scanner (System.in);
//	java.sql.Date sdate =null;
//	java.sql.Date qwerty = null;
	ResultSet res= null;
	
	
	try
	{
		 con = Util.getconnection();
		 String Sqlquery1 = "insert into student_info(id,name,city,DateOfBirth,DateOfMarriage) values(78,'danny','usa','1234-12-31','2003-12-31')";
		 String Sqlquery2 = "insert into student_info(id,name,city,DateOfBirth,DateOfMarriage) values(88,'leon','mumbai','1234-12-31','2003-12-31')";

		 if(con!=null)
		 {
			pstmt = con.createStatement();
		 }
		 if(pstmt!=null)
		 {
			 
			 pstmt.addBatch(Sqlquery1);
			 pstmt.addBatch(Sqlquery2);
		 }	
			pstmt.executeBatch();
			System.out.println("record inserted successfully");
		
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
