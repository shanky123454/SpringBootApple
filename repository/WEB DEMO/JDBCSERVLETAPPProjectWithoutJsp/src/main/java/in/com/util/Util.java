package in.com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Util {
            
	  public static Connection getConnection() throws Exception
	  {
		  Connection con =null;
		  
		 try {
			  Class.forName("com.mysql.cj.jdbc.Driver");
			FileInputStream fis = new FileInputStream("C:\\Users\\ASUS\\git\\WEB DEMO\\JDBCSERVLETAPPProjectWithoutJsp\\src\\main\\java\\in\\com\\properties\\application.properties");
			Properties p = new Properties();
			p.load(fis);
			String url =p.getProperty("url");
			String user =p.getProperty("user");
			String password= p.getProperty("password");
			
			con=DriverManager.getConnection(url, user, password);
			if(con!=null)
			{
				System.out.println("connection got established");
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return con;
		  
	  }
	  
	  public static void cleanup(Connection con ,Statement stm, ResultSet res) throws SQLException, IOException
	  {
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
