package com.jdbc.in;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Util1 {

	//establishing the connection
	public static Connection  getconnection() throws SQLException, IOException{
		
		FileInputStream fis = new FileInputStream("C:\\Users\\ASUS\\git\\repository\\jdbc demo\\application.properties");
		Properties pro = new Properties();
		pro.load(fis);
	   	String url = pro.getProperty("url");
	   	String user =pro.getProperty("user");
	   	String password=pro.getProperty("password");
       Connection connection = DriverManager.getConnection(url,user,password);
       System.out.println("connection get establish");
       System.out.println(connection.getClass().getName());
	    return connection;
	}
	
	public static void cleanup(Connection con,PreparedStatement stm,ResultSet res) throws SQLException
	{
		//closing the resources
		if(con!=null)
		{
			con.close();
		}
		if(stm!=null)
		{
			stm.close();
		}
		
	}
}
