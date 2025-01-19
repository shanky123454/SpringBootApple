package com.connectionpool.jdbc;

import java.sql.SQLException;
import java.util.*;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;


//Inserting using jdbcrowset

public class rowset2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
			RowSetFactory rfs = RowSetProvider.newFactory();
			
			JdbcRowSet jrs = rfs.createJdbcRowSet();
			
			//settinng the connection
			
			jrs.setUrl("jdbc:mysql:///movie");
			jrs.setUsername("root");
			jrs.setPassword("Shanky@123");
			
			jrs.setCommand("select id,name,actor_name,balance from movies");
			jrs.execute();
			
			
			System.out.println("enter the id ");
			int id = sc.nextInt();
			System.out.println("enter the name");
			String name = sc.next();
			
			System.out.println("enter the actor name");
			String aname= sc.next();
;
			System.out.println("enter the balance");
			int bal =sc.nextInt();
			
		
			
			jrs.moveToInsertRow();
			jrs.updateInt(1, id);
			jrs.updateString(2, name);
			jrs.updateString(3, aname);
			jrs.updateInt(4, bal);
			
			jrs.insertRow();
			
			
			//jrs.beforeFirst();
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
