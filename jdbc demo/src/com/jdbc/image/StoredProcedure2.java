package com.jdbc.image;
import com.jdbc.in.Util;



import java.util.*;

import java.io.IOException;
import java.sql.*;

public class StoredProcedure2 {

	public static void main(String[] args) {
		
		Connection conn  = null;
		CallableStatement pstmt = null;
		ResultSet res = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			conn=Util.getconnection();
			String insertquery ="{CALL new_procedure_by_name(?,?)}";
			if(conn!=null)
			{
				pstmt =conn.prepareCall(insertquery);
			}
			if(pstmt!=null)
			{
				System.out.println("enter the name1 of the student");
				String n1= sc.next();
				
				System.out.println("enter the name1 of the student");
				String n2= sc.next();
				
				pstmt.setString(1, n1);
				pstmt.setString(2, n2);
			}
			
				// run the stored procedure
				if(pstmt!=null)
				{
					res=pstmt.executeQuery();
				}
				
				// Retrieve the result
				if(res!=null)
				{
					while(res.next())
					{
						System.out.println("SID \t SNAME \t SCITY \t SDOB \t SDOM");
						int id = res.getInt(1);
						String name = res.getString(2);
						String city = res.getString(3);
						java.util.Date d = res.getDate(4);
						java.util.Date d1 = res.getDate(5);
						
						System.out.println(id +"\t" + name +"\t" +city +"\t" + d +"\t" + d1);
					}
					
				}
	
		} catch (SQLException | IOException e) {
			
			e.printStackTrace();
		}catch(Exception e1)
		{
			e1.printStackTrace();
		}
		finally
		{
			try {
				Util.cleanup(conn, pstmt, null);
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}

	}

}
