package com.connectionpool.jdbc;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
// Select command using jdbcrowset
public class rowset1 {

	public static void main(String[] args) {
		
		try {
			RowSetFactory rfs = RowSetProvider.newFactory();
			
			JdbcRowSet jrs = rfs.createJdbcRowSet();
			
			//settinng the connection
			
			jrs.setUrl("jdbc:mysql:///movie");
			jrs.setUsername("root");
			jrs.setPassword("Shanky@123");
			
			jrs.setCommand("select * from movies");
			jrs.execute();
			//jrs.beforeFirst();
			System.out.println("SID \t SNAME \t SBALANCE");
			while(jrs.next())
			{
				//System.out.println("SID \t SNAME \t Sbalance");
				
				System.out.println(jrs.getInt(1) +"\t" + jrs.getString(2)+ "\t" + jrs.getInt(4));
			}
			
			System.out.println("==================================================================");
			
			jrs.afterLast();
			
			while(jrs.previous())
			{
				System.out.println(jrs.getInt(1) +"\t" + jrs.getString(2)+ "\t" + jrs.getInt(4));

			}
			
			System.out.println("====================================================================");
			
			jrs.relative(2);
			System.out.println(jrs.getInt(1) +"\t" + jrs.getString(2)+ "\t" + jrs.getInt(4));

				System.out.println("==========================");
				
				jrs.absolute(3);
				System.out.println(jrs.getInt(1) +"\t" + jrs.getString(2)+ "\t" + jrs.getInt(4));

				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		

	}

}
