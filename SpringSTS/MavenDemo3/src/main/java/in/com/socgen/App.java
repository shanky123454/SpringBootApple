package in.com.socgen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App 
{
	
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    		    {
    			  
    			   PreparedStatement pstmt = null;
    			   Connection connection =null;
    			   ResultSet set= null;
    			  String url="jdbc:mysql:///student";
    			  String username="root";
    			  String password="Shanky@123";
    			  
    		      
    			   	try {
    			   		String sqlselectquery = "select id,name,city from student_info";
    			   		connection = DriverManager.getConnection(url, username, password);
    			   		if(connection!=null)
    			   		{
    			   			pstmt = connection.prepareStatement(sqlselectquery);
    			   		}
    			   		
    			   		if(pstmt!=null)
    			   		{
    			   		    set=pstmt.executeQuery();
    			   		}
    			   		
    			   	if(set!=null)
    			   	{

			   			System.out.println("SID\t SNAME\t SCITY");
    			   		while(set.next())
    			   		{
    			   			   int  id=   set.getInt(1);
    			   			  String name = set.getString(2);
    			   			  String city = set.getString(3);
    			   		
    			   			 System.out.println(id + "\t" + name +"\t" + city);
    			   		}
    			   			
    			   	}
    			   	}catch(SQLException e)
    			   	{
    			   		e.printStackTrace();
    			   	}catch(Exception e2)
    			   	{
    			   		e2.printStackTrace();
    			   	}
    			   	finally {
    			   		try {
    			   		connection.close();
    			   	}catch(Exception e1)
    			   		{
    			   		e1.printStackTrace();
    			   		}
    			   	}    
    	}

    }

