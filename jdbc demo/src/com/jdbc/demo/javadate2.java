package com.jdbc.demo;
import java.util.*;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import com.jdbc.in.Util;

//DateOfBirth
//DateOfMarriage
public class javadate2
{

public static void main(String[] args) 
{
	Connection conn= null;
	PreparedStatement pstmt = null;
	ResultSet res = null;
	Scanner sc = new Scanner(System.in);
	
	try {
		String selectquery = "select id,name,city,DateOfBirth,DateOfMarriage from student_info  where id =?";
		conn= Util.getconnection();
		
		if(conn!=null)
		{
			pstmt = conn.prepareStatement(selectquery);
		}
		if(pstmt!=null)
		{
			System.out.println("enter the id of the student");
			int sid = sc.nextInt();
			
			pstmt.setInt(1, sid);
			res= pstmt.executeQuery();
		}
		
		if(res!=null)
		{
			while(res.next())
			{
				System.out.println("SID\t SNAME\t SCITY\t SDOB\t SDOM");
				int sid =res.getInt("id");
				String sname = res.getString("name");
				String scity = res.getString("city");
				
			java.sql.Date sdob = res.getDate("DateOfBirth");
			java.sql.Date sdom = res.getDate("DateOfmarriage");
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				String ssdob = sdf.format(sdob);
				String ssdom = sdf.format(sdom);
				
				System.out.println(sid +"\t" + sname +"\t" + scity +"\t" + ssdob + "\t" + ssdom);
				System.out.println();
			}
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


	
