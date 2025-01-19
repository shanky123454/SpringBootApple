package in.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.com.component.Employee;

@Component(value = "dao")
public class IDaoImplClass implements IDao {

	static {
		System.out.println("IDaoImplClass.static method()");
	}
	
	public IDaoImplClass() {
	System.out.println("IDaoImplClass.IDaoImplClass()");
	}

	@Autowired
	public DataSource dataSource;
    
	String Sql="select * from employee";
	List<Employee> emp = new ArrayList<>(); 
	@Override
	public List<Employee> getEmployeeDetails() {
		try(Connection con = dataSource.getConnection();
		PreparedStatement pstmt =	con.prepareStatement(Sql);
		ResultSet res= pstmt.executeQuery()){
			while(res.next())
			{
				Employee e = new Employee();
				e.setEid(res.getInt("eid"));
				e.setEadd(res.getString("eadd"));
				e.setEage(res.getInt("eage"));
				emp.add(e);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return emp;
	}

}
