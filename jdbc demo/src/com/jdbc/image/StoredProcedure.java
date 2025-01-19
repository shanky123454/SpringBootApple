package com.jdbc.image;
import com.jdbc.in.Util;



import java.util.*;

import java.io.IOException;
import java.sql.*;

public class StoredProcedure {

	public static void main(String[] args) {
		
		Connection conn  = null;
		CallableStatement pstmt = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			conn=Util.getconnection();
			String insertquery ="{CALL new_procedure(?,?,?,?,?)}";
			if(conn!=null)
			{
				pstmt =conn.prepareCall(insertquery);
			}
			if(pstmt!=null)
			{
				System.out.println("enter the id of the student");
				int id= sc.nextInt();
				// Set the value of the id
				pstmt.setInt(1, id);
			}
			
			
			// setting the datatypes of the output values
				if(pstmt!=null)
				{
					pstmt.registerOutParameter(2, Types.VARCHAR);
					pstmt.registerOutParameter(3, Types.VARCHAR);
					pstmt.registerOutParameter(4, Types.DATE);
					pstmt.registerOutParameter(5, Types.DATE);
			    }
				// run the stored procedure
				if(pstmt!=null)
				{
					pstmt.execute();
				}
				
				// Retrieve the result
				if(pstmt!=null)
				{
					System.out.println("student name is:" + pstmt.getString(2));
					System.out.println("student city is :" +pstmt.getString(3));
					System.out.println("srudent dob is:" + pstmt.getDate(4));
					System.out.println("student dom is :" +pstmt.getDate(5));
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
