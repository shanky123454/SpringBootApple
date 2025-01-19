package in.com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import in.com.BO.EmployeeBO;

@Component(value = "employeeDAOImpl")
@Profile({"test","dev"})
public class EmployeeDAOImpl implements IEmployeeDao {
	static {
		System.out.println("EmployeeDAOImpl.static_method()");
	}

	public EmployeeDAOImpl()
	{
		System.out.println("EmployeeDAOImpl.EmployeeDAOImpl()");
	}
	
	@Autowired
	public DataSource dataSource;
	
	@Override
	public List<EmployeeBO> getEmpByDesg(String cond) {
		
//		Connection connection = null;
//		Statement statement =null;
//		ResultSet resultSet =null;
		String Sqlquery="SELECT EMPNO,EMPNAME,JOB,SAL,DEPTNO,MGRNO FROM EMP  WHERE JOB IN";
		System.out.println("datasource obj class name :" + dataSource.getClass().getName());
		List<EmployeeBO> bos = new ArrayList<>();
		try( Connection connection  = dataSource.getConnection();
			Statement statement  = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(Sqlquery+ cond + "ORDER BY JOB"))
		{
			if(resultSet!=null)
			{
			
				while(resultSet.next())
				{
					EmployeeBO bo = new EmployeeBO();
				   bo.setEmpNo(resultSet.getInt("empNo"));	
				   bo.setEmpName(resultSet.getString("empName"));	
				   bo.setJob(resultSet.getString("job"));
				   bo.setSal(resultSet.getDouble("sal"));
				   bo.setDeptNo(resultSet.getInt("deptNo"));
				   bo.setMgrNo(resultSet.getInt("mgrNo"));
				   bos.add(bo);
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return bos;
	}
	
	

}
