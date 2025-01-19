package com.connectionpool.jdbc;

import java.sql.*;
import com.mysql.cj.jdbc.*;

public class connectionpool {
	
	public static void main(String[] args)
	{
		ResultSet res= null;
		Statement stm = null;
		Connection con =null;
		
		
		try
		{
			MysqlConnectionPoolDataSource cpd = new MysqlConnectionPoolDataSource();
			cpd.setUrl("jdbc:mysql:///employee");
			cpd.setUser("root");
			cpd.setPassword("Shanky@123");
			
			
			// getting the connection object from Connection pool
			con =cpd.getConnection();
			
			if(con!=null)
			{
				stm =con.createStatement();
				
			}
			if(stm!=null)
			{
				res =stm.executeQuery("select * from employees");
			}
			if(res!=null)
			{
				System.out.println("SID \t SNAME \t SAGE");
				while(res.next())
				{
					System.out.println(res.getInt("id")+"\t" + res.getString("name") +" \t" + res.getInt("age"));
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			try {
				res.close();
			} catch (SQLException e) {
		
				e.printStackTrace();
			}
			try {
				stm.close();
			} catch (SQLException e) {
		
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
	}

}
