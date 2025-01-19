package com.connectionpool.jdbc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;
// SELECT USING WEBROWSET
// WEBROWSET USES SERIALIZABLE SO IT CAN BE USED TO TRANSFER FILE OVER NETWORK
public class webrowset2 {

	public static void main(String[] args) {
		
		
		try {
			RowSetFactory rfs = RowSetProvider.newFactory();
			
			WebRowSet wrs = rfs.createWebRowSet();
			
			wrs.setUrl("jdbc:mysql:///movie");
			wrs.setUsername("root");
			wrs.setPassword("Shanky@123");
			
			wrs.setCommand("select * from movies");
			
			wrs.execute();
			
			try {
				File fi = new File("C:\\Users\\ASUS\\Downloads" , "movies.xml");
				FileWriter f = new FileWriter(fi);
				
				wrs.writeXml(f);
				f.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

}
