package com.jdbc.demo;
import com.jdbc.in.Util;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class batchupdate3 {
	public static void main(String[] args)
	{
	Connection con = null;
	PreparedStatement pstmt= null;
	Scanner sc = new Scanner (System.in);
	java.sql.Date sdate =null;
	java.sql.Date qwerty = null;
	ResultSet res =null;
	
	
	try
	{
		 con = Util.getconnection();
		 String Sqlquery = "select name,city,DateOfBirth,DateOfMarriage from student_info where id=?";
		 if(con!=null)
		 {
			pstmt = con.prepareStatement(Sqlquery);
		 }
		 if(pstmt!=null)
		 {
			 
				 System.out.println("enter the id of the student");
				 int sid =sc.nextInt();
				 
				 pstmt.setInt(1, sid);
			
				 
				// pstmt.addBatch();
				
			//AddBatch() is for 'delete'/'insert'/' update' statements, and not 'select' statements.
		 }
		 if(pstmt!=null)
		 {
			 System.out.println("SNAME \t SCITY\t SDOB \t SDOM");
			 
			res =pstmt.executeQuery();
			if(res!=null)
			{
				while(res.next())
				{
//					int id= res.getInt("id");
					String name = res.getString("name");
					String city = res.getString("city");
					java.sql.Date dob = res.getDate("DateOfBirth");
					java.sql.Date dom = res.getDate("DateOfMarriage");
					
					
					System.out.println( name+ "\t" + city+"\t" + dob +"\t" + dom);
				} 
			}
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
