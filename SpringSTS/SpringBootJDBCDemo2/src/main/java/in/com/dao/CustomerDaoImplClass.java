package in.com.dao;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class CustomerDaoImplClass implements CustomerDaoInterface {
	
	String sqlquery = "select count(*) from emp";
	String EmpName = "select empName from emp where empNo=?";
	String EmpObj = "select empNo,empName,job,sal,deptNo,mgrNo from emp where empNo IN(?,?)";
	String EmpObj1 = "select empNo,empName,job,sal,deptNo,mgrNo from emp where empNo IN(?)";
	String updateQurty="insert into emp(empNo,empName,job,sal,deptNo,mgrNo) values(?,?,?,?,?,?)";
	String updateQuery="update emp set sal=sal+? where job IN(?)";
	
	@Autowired
	public JdbcTemplate jdbcTemplate;   

	
	static {
		System.out.println("CustomerDaoImplClass.enclosing_method()");
	}
	
	public CustomerDaoImplClass()
	{
		System.out.println("CustomerDaoImplClass.CustomerDaoImplClass()");
	}

	@Override
	public int getCustomerCount() {
	return 	jdbcTemplate.queryForObject(sqlquery,Integer.class);
		
	}

	@Override
	public String getEmployeeNameById(int empNo) {
		return jdbcTemplate.queryForObject(EmpName, String.class,empNo);
	}

	@Override
	public List<Map<String, Object>> getEmployeesDetailsById(int id1,int id2) {
		return jdbcTemplate.queryForList(EmpObj,id1,id2);
	}

	@Override
	public Map<String, Object> getEmployeeDetailsById(int id1) {
		return jdbcTemplate.queryForMap(EmpObj1, id1);
		
	}

	@Override
	public int insertEmployee(int empNo, String empName, String job, Float sal, int deptNo, int mgrNo) {
		return jdbcTemplate.update(updateQurty, empNo,empName,job,sal,deptNo,mgrNo);
	}

	@Override
	public int updateSalary(int increment, String job) {
		return jdbcTemplate.update(updateQuery,increment,job);
	}
   
	
}
