package in.neuron;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.SimpleLayout;

public class JdbcApp 
{
   public  static Logger logger = Logger.getLogger(JdbcApp.class);
    
    static {
    	
    	PropertyConfigurator.configure("src\\main\\java\\in\\com\\commons\\log4j.properties");
//    	SimpleLayout layout = new SimpleLayout();
//    	ConsoleAppender appender = new ConsoleAppender(layout);
//    	logger.addAppender(appender);
//    	logger.setLevel(Level.FATAL);
//    	// Appender appender2 = new ConsoleAppender();
//    	// Layout layout2 = new SimpleLayout();
    }
    
    public static void main(String[] args)
    {
    	logger.debug("start of main method......");
    	Connection connection =null;
    	Statement statement =null;
    	ResultSet resultSet =null;
    	
    try {
    	
    	Class.forName("com.mysql.cj.jdbc.Driver");
		logger.info("Driver class is uploaded");
		
        String SqlQuery= "select sid,sname,sage from student";
    	connection=DriverManager.getConnection("jdbc:mysql:///student", "root", "Shanky@123");
    	logger.info("connection established");
    	
    	statement=connection.createStatement();
    	logger.debug("statement object created");
    	
		resultSet =	statement.executeQuery(SqlQuery);
		logger.info("Query is executed and ResultSet object is created");
		
		System.out.println("sid"+ "\t" + "sname" +"\t" + "sage");
			while(resultSet.next())
			{
				String sid= resultSet.getString("sid");
				String sname = resultSet.getString("sname");
				int sage = resultSet.getInt("sage");
				System.out.println(sid +"\t" + sname+"\t" + sage);
			}
		
    	}catch(ClassNotFoundException e)
    {
    		e.printStackTrace();
    		logger.error("driver class not loaded");
    }
    catch(SQLException se)
    {
    	se.printStackTrace();
    	logger.info("some db related error");
    }
    catch(Exception e)
    {
    	e.printStackTrace();
    	logger.fatal("unexpected exception occurs");
    }
    finally
    {
    	try {
    		if(resultSet!=null)
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("error in closing resultset");
		}
    	
    	try {
    		if(statement!=null)
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("error in closing statement");
		}
    	
    	try {
    		if(connection!=null)
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("error in closing connection object");
		}	
    }
    logger.debug("end of main method");
    }
	
}
