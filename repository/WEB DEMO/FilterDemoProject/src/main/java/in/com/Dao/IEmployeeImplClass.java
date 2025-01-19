package in.com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.com.Dto.Employee;

public class IEmployeeImplClass implements IEmployee {
	Connection con =null;
	PreparedStatement pstmt = null;
	int res=0;
	String result="";
public String add(Employee e1) {
	
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("driver class is loaded");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			try {
				con =DriverManager.getConnection("jdbc:mysql:///Ineuron", "root", "Shanky@123");
				
				if(con!=null)
				{
					 String query="insert into employees(eid,ename,eage,eemail,emobile) values(?,?,?,?,?)";
					 
					 pstmt= con.prepareStatement(query);
					 
					 if(pstmt!=null)
							{
								pstmt.setString(1, e1.eid);
								pstmt.setString(2, e1.ename);
								pstmt.setInt(3, e1.eage);
								pstmt.setString(4, e1.eemail);
								pstmt.setString(5, e1.emobile);
								res = pstmt.executeUpdate();
							}
					 if(res==1)
						{
							result="success";
						}
						else {
							result="failure";
						}
					 
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return result;
	
		}
}


