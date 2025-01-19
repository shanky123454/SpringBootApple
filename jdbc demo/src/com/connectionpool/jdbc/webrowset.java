package com.connectionpool.jdbc;

import java.sql.SQLException;

import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;
// SELECT USING WEBROWSET
public class webrowset {

	public static void main(String[] args) {
		
		
		try {
			RowSetFactory rfs = RowSetProvider.newFactory();
			
			WebRowSet wrs = rfs.createWebRowSet();
			
			wrs.setUrl("jdbc:mysql:///movie");
			wrs.setUsername("root");
			wrs.setPassword("Shanky@123");
			
			wrs.setCommand("select * from movies");
			
			wrs.execute();
			
			System.out.println("SID \t SNAME \t SANAME \t SBALANCE");
			while(wrs.next())
			{
				System.out.println(wrs.getInt(1)+"\t" + wrs.getString(2) +"\t" + wrs.getString(3) +"\t" + wrs.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

}
