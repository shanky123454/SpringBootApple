package com.connectionpool.jdbc;

import java.sql.SQLException;
import java.util.*;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;


//deleting using jdbcrowset

public class rowset4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
			RowSetFactory rfs = RowSetProvider.newFactory();
			
			JdbcRowSet j = rfs.createJdbcRowSet();
			
			//setting the connection
			
			j.setUrl("jdbc:mysql:///movie");
		     j.setUsername("root");
			j.setPassword("Shanky@123");
			
			j.setCommand("select id,name,actor_name,balance from movies");
			j.execute();
			j.first();
			j.deleteRow();
			j.beforeFirst();
			System.out.println("SID \t SNAME \t SANAME \t SBALANCE");
			while(j.next())
			{
				//System.out.println("SID \t SNAME \t Sbalance");
				
				System.out.println(j.getInt(1) +"\t" + j.getString(2)+ "\t" + j.getString(3)+"\t"+ j.getInt(4));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally
		{
		  
		}
		

	}

}
