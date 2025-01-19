package com.connectionpool.jdbc;

import java.sql.Connection;

import java.sql.ResultSet;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class hikaricp {

	public static void main(String[] args) {
		
		String stringconfig="C:\\Users\\ASUS\\git\\repository\\jdbc demo\\src\\com\\connectionpool\\jdbc\\db.properties";
		HikariConfig config = new HikariConfig(stringconfig);
		
//		try(HikariDataSource hdc = new HikariDataSource(config)){
//		
//			try(Connection con = hdc.getConnection()){
//				
//				try(java.sql.Statement stm = con.createStatement()){
//				
//				try(ResultSet res= stm.executeQuery("select * from employees")){
//					
//					if(res!=null)
//					{
//						System.out.println("SID \t SNAME \t SAGE");
//					}
//						while(res.next())
//						{
//							System.out.println(res.getInt("id") +"\t" + res.getString("name") +"\t" + res.getInt("age"));
//						}
//					}
//				}
//			
//			} 
//	}
		
		try(HikariDataSource hdc = new HikariDataSource(config);
			
			Connection con = hdc.getConnection();
				
				java.sql.Statement stm = con.createStatement();
				
				ResultSet res= stm.executeQuery("select * from employees"))
				{
					
					if(res!=null)
					{
						System.out.println("SID \t SNAME \t SAGE");
					}
						while(res.next())
						{
							System.out.println(res.getInt("id") +"\t" + res.getString("name") +"\t" + res.getInt("age"));
						}
			
	}catch(Exception main)
		{
		main.printStackTrace();
		}

}
}
