package com.connectionpool.jdbc;

import java.sql.SQLException;
import java.util.*;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;


//Updating using jdbcrowset

public class rowset3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
			RowSetFactory rfs = RowSetProvider.newFactory();
			
			JdbcRowSet jrs = rfs.createJdbcRowSet();
			
			//setting the connection
			
			jrs.setUrl("jdbc:mysql:///movie");
			jrs.setUsername("root");
			jrs.setPassword("Shanky@123");
			
			jrs.setCommand("select id,name,actor_name,balance from movies");
			jrs.execute();
			
			while(jrs.next())
			{
				int bal = jrs.getInt(4);
				if(bal<15000)
				{
					int newbal = bal+1000;
					jrs.updateInt(4, newbal);
					jrs.updateRow();
				}
			}
			
			jrs.beforeFirst();
			System.out.println("SID \t SNAME \t SBALANCE");
			while(jrs.next())
			{
				//System.out.println("SID \t SNAME \t Sbalance");
				
				System.out.println(jrs.getInt(1) +"\t" + jrs.getString(2)+ "\t" + jrs.getInt(4));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		

	}

}
