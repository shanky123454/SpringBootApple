package com.connectionpool.jdbc;
import java.sql.*;
import java.util.Scanner;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

//Inserting using cachedrowset

/*
 * WE ARE GETTING ERRORS IN THIS PROGRAM SO BASICALLY WE ONLY USE RESULTSET OR JDBCROWSET ONLY 
 * NOTE:  USing Disconnected RowSet we can only perform select command inserting and any other we dont use because it leads to error 
 */
public class CachedRowset3 {

	public static void main(String[] args) {
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet res= null;
		Scanner sc = new Scanner(System.in);
		
		
		try {
			
			RowSetFactory rsf = RowSetProvider.newFactory();
			CachedRowSet crs = rsf.createCachedRowSet();// because cachedrowset works in disconnected mode
			
			
			// setting the connection
			crs.setUrl("jdbc:mysql:///movie");
			crs.setUsername("root");
			crs.setPassword("Shanky@123");
			
			crs.setCommand("select * from movies");
			crs.execute();
			
//			while(true)
//			{
				System.out.println("enter the id");
				int id = sc.nextInt();
				System.out.println("enter the name");
				String name = sc.next();
				System.out.println("enter the actor_name");
				String aname = sc.next();
				System.out.println("enter the balance");
				int bal =sc.nextInt();
				
				crs.moveToInsertRow();
				
				crs.updateInt(1, id);
				crs.updateString(2, name);
				crs.updateString(3, aname);
				crs.updateInt(4, bal);
				
				
				crs.insertRow();
				
				crs.moveToCurrentRow();
				crs.acceptChanges();
			
			//}
			
			if(crs!=null)
			{
				System.out.println("SID \t SNAME \t SANAME \t SBALANCE");
				while(crs.next())
				{
					System.out.println(crs.getInt(1)+ "\t" + crs.getString(2)+"\t" + crs.getString(3) +"\t" + crs.getInt(4));
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		

	}

}
