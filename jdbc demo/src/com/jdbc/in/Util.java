package com.jdbc.in;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Util {

	//establishing the connection
	public static Connection  getconnection() throws SQLException, IOException{
		
		FileInputStream fis = new FileInputStream("application.properties");
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
	
	public static void cleanup(Connection con,Statement stm,ResultSet res) throws SQLException
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
		if(res!=null)
		{
			res.close();
		}
	}
}
