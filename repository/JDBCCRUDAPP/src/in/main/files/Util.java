package in.main.files;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

//public class Util {

//	//establishing the connection
//	public static Connection  getconnection() throws SQLException, IOException{
//		
//		FileInputStream fis = new FileInputStream("C:\\Users\\ASUS\\git\\repository\\JDBCCRUDAPP\\src\\in\\main\\files\\application.properties");
//		Properties pro = new Properties();
//		pro.load(fis);
//	   	String url = pro.getProperty("url");
//	   	String user =pro.getProperty("user");
//	   	String password=pro.getProperty("password");
//       Connection connection = DriverManager.getConnection(url,user,password);
//       System.out.println("connection get establish");
//       System.out.println(connection.getClass().getName());
//	    return connection;
//	}
//	
//	public static void cleanup(Connection con,Statement stm,ResultSet res) throws SQLException
//	{
//		//closing the resources
//		if(con!=null)
//		{
//			con.close();
//		}
//		if(stm!=null)
//		{
//			stm.close();
//		}
//		if(res!=null)
//		{
//			res.close();
//		}
//	}
//}

public class Util{
	
	
	private Util()
	{
		
	}
                  
	static{
	    try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver class got loaded");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getconnection() throws SQLException
	{
		
	//String stringconfig=("C:\\Users\\ASUS\\git\\repository\\JDBCCRUDAPP\\src\\in\\main\\files\\application.properties");
	HikariConfig config = new HikariConfig("C:\\Users\\ASUS\\git\\repository\\JDBCCRUDAPP\\src\\in\\main\\files\\application.properties");
	
	HikariDataSource hdk = new HikariDataSource(config);
		 return hdk.getConnection();

	}
	
 }

 
 
