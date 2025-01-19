package in.com.neuron;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JdbcApp 
{
   public  static Logger logger = LoggerFactory.getLogger(JdbcApp.class);

  	Connection connection =null;
	Statement statement =null;
	ResultSet resultSet =null;
	
	
   @Autowired
   public DataSource dataSource;

   public void getResult() {
    try {
    String sql ="select sid,sname,sage from student";
    connection	=  dataSource.getConnection();
    logger.debug("connection got established");
     statement = connection.createStatement();
     logger.info("statement createdddddd successfully");
     resultSet= statement.executeQuery(sql);
     logger.info("resultset got executed");
		System.out.println("sid"+ "\t" + "sname" +"\t" + "sage");
			while(resultSet.next())
			{
				String sid= resultSet.getString("sid");
				String sname = resultSet.getString("sname");
				int sage = resultSet.getInt("sage");
				System.out.println(sid +"\t" + sname+"\t" + sage);
			}
		
    	}catch(ClassCastException e1)
    {
    		e1.printStackTrace();
    		logger.error(" class cast exception");
    }
    catch(SQLException se)
    {
    	se.printStackTrace();
    	logger.info("some db related error");
    }
    catch(Exception e)
    {
    	e.printStackTrace();
    	logger.error("unexpected exception occurs");
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
	

