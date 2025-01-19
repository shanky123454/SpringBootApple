package in.com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import in.com.DTO.EmployeeDTO;


@Repository
public class CustomerDaoImplClass implements CustomerDaoInterface {
	
	String sqlquery = "select count(*) from emp";
	String EmpName = "select empName from emp where empNo=?";
	String EmpObj = "select empNo,empName,job,sal,deptNo,mgrNo from emp where empNo IN(?,?)";
	String EmpObj1 = "select empNo,empName,job,sal,deptNo,mgrNo from emp where empNo IN(?,?)";
	String updateQurty="insert into emp(empNo,empName,job,sal,deptNo,mgrNo)values(?,?,?,?,?,?)";
	String updateQuery="update emp set sal=sal+? where job IN(?)";
	String sqlquery1="select empNo,empName,job,sal,deptNo,mgrNo from emp where empNo IN(?,?)";
	String sqlquery2="select empNo,empName,job,sal,deptNo,mgrNo from emp where empNo IN(?,?)";
	String sqlquery3="select empNo,empName,job,sal,deptNo,mgrNo from emp where empNo IN(?,?)";

	@Autowired
	public JdbcTemplate jdbcTemplate; 
	
	static {
		System.out.println("CustomerDaoImplClass.enclosing_method()");
	}
	
	public CustomerDaoImplClass()
	{
		System.out.println("CustomerDaoImplClass.CustomerDaoImplClass()");
	}

	@Override // by normal procedure
	public int getCustomerCount() {
	Integer i =  jdbcTemplate.queryForObject(sqlquery,new EmployeeMapper());
	   return i;
	}
	
	public static class EmployeeMapper implements RowMapper<Integer>
	{
		@Override
		public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
			System.out.println("CustomerDaoImplClass.EmployeeMapper.mapRow()");
			int res=0;
			res=rs.getInt(1);
			return res ;
		}
		
	}

	@Override // by lambda expression
	public String getEmployeeNameById(int empNo) {
		return jdbcTemplate.queryForObject(EmpName,(rs,num)->{
			String res= rs.getString(1);
			return res;
		},empNo);
	}


	@Override // by using anonymous inner class
	public List<List<EmployeeDTO>> getEmployeesDetailsById(int id1,int id2) {
		return jdbcTemplate.query(EmpObj,new RowMapper<List<EmployeeDTO>>(){

			@Override
			public List<EmployeeDTO> mapRow(ResultSet rs, int rowNum) throws SQLException {
				System.out.println("CustomerDaoImplClass.getEmployeesDetailsById(...).new RowMapper() {...}.mapRow()");
				List<EmployeeDTO> dtos = new ArrayList<>();
				EmployeeDTO dto = new EmployeeDTO();
				dto.setEmpNo(rs.getInt(1));
				dto.setEmpName(rs.getString(2));
				dto.setJob(rs.getString(3));
				dto.setSal(rs.getDouble(4));
				dto.setDeptNo(rs.getInt(5));  
				dto.setMgrNo(rs.getInt(6));
				dtos.add(dto);
				return dtos;	
			}
		},id1,id2);
	}
	
    

	@Override // by using rowmapper implementation class
	public List<EmployeeDTO> getEmployeeDetailsById(int id1,int id2) {
		return jdbcTemplate.query(EmpObj1, new BeanPropertyRowMapper<EmployeeDTO>(EmployeeDTO.class),id1,id2);
		
	}

//	@Override
//	public int insertEmployee(int empNo, String empName, String job, Float sal, int deptNo, int mgrNo) {
//		return jdbcTemplate.update(updateQurty, empNo,empName,job,sal,deptNo,mgrNo);
//	}

	@Override
	public int updateSalary(int increment, String job) {
		return jdbcTemplate.update(updateQuery,increment,job);
	}

@Override
public List<Map<String, Object>> getEmployeeListByJob(String job1,String job2) {
		// return jdbcTemplate.queryForList(sqlquery1, job);

	return jdbcTemplate.queryForList(sqlquery1,job1,job2);
}

@Override
public List<EmployeeDTO> getEmployeeListByUsingResultSetExtractor(int id1, int id2) {
	return  jdbcTemplate.query(EmpObj, (res)->{
		System.out.println("CustomerDaoImplClass.getEmployeeListByUsingResultSetExtractor()");
		List<EmployeeDTO> dtos = new ArrayList<>();
		while(res.next())
		{
			EmployeeDTO dto= new EmployeeDTO();
			dto.setEmpNo(res.getInt(1));
			dto.setEmpName(res.getString(2));
			dto.setJob(res.getString(3));
			dto.setSal(res.getDouble(4));
			dto.setDeptNo(res.getInt(5));
			dto.setMgrNo(res.getInt(6));
			dtos.add(dto);
		
		}
		return dtos;
	},id1,id2);
}

@Override
public List<EmployeeDTO> getEmployeeListByUsingResultSetExtractor1(int id1, int id2) {
//	return jdbcTemplate.query(sqlquery2, 
//			new RowMapperResultSetExtractor<EmployeeDTO>(new BeanPropertyRowMapper<EmployeeDTO>(EmployeeDTO.class)), id1,id2);
          return  jdbcTemplate.query(sqlquery2, new ResultSetExtractor<List<EmployeeDTO>>()
        		  {
					@Override
					public List<EmployeeDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
						System.out.println(
								"CustomerDaoImplClass.getEmployeeListByUsingResultSetExtractor1(...).new ResultSetExtractor() {...}.extractData()");
						List<EmployeeDTO> dtos = new ArrayList<>();
						while(rs.next())
						{
							EmployeeDTO dto= new EmployeeDTO();
							dto.setEmpNo(rs.getInt(1));
							dto.setEmpName(rs.getString(2));
							dto.setJob(rs.getString(3));
							dto.setSal(rs.getDouble(4));
							dto.setDeptNo(rs.getInt(5));
							dto.setMgrNo(rs.getInt(6));
							dtos.add(dto);
						}
						return dtos;
					}
        		  }, id1,id2);
       }

@Override
public List<EmployeeDTO> getEmployeeDetailsByUsingRowCallBackHandler(int id1, int id2) {
	   List<EmployeeDTO> dtos = new ArrayList<>();
	  jdbcTemplate.query(sqlquery3, new RowCallbackHandler()
			  {
				@Override
				public void processRow(ResultSet rs) throws SQLException {
					System.out.println(
"CustomerDaoImplClass.getEmployeeDetailsByUsingRowCallBackHandler(...).new RowCallbackHandler() {...}.processRow()");
						EmployeeDTO dto= new EmployeeDTO();
						dto.setEmpNo(rs.getInt(1));
						dto.setEmpName(rs.getString(2));
						dto.setJob(rs.getString(3));
						dto.setSal(rs.getDouble(4));
						dto.setDeptNo(rs.getInt(5));
						dto.setMgrNo(rs.getInt(6));
						dtos.add(dto);
				}
			   },id1,id2);
	  dtos.forEach(System.out::println);
	  return dtos;
    }

   

}
	    
	    
	    

	

