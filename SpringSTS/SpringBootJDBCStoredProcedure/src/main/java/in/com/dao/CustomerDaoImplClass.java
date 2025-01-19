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
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import in.com.DTO.EmployeeDTO;


@Repository
public class CustomerDaoImplClass implements CustomerDaoInterface {
	
	String sqlquery = "select count(*) from emp";
	String EmpName = "select empName from emp where empNo=:no";
	String EmpObj = "select empNo,empName,job,sal,deptNo,mgrNo from emp where empNo IN(:id1,:id2)";
	String EmpObj1 = "select empNo,empName,job,sal,deptNo,mgrNo from emp where empNo IN(:id1,:id2)";
	String updateQurty="insert into emp(empNo,empName,job,sal,deptNo,mgrNo)values(:empNo,:empName,:job,:sal,:deptNo,:mgrNo)";
	String updateQuery="update emp set sal=sal+:increment where job IN(:job)";
	String sqlquery1="select empNo,empName,job,sal,deptNo,mgrNo from emp where empNo IN(:id1,:id2)";
	String sqlquery2="select empNo,empName,job,sal,deptNo,mgrNo from emp where empNo IN(:id1,:id2)";
	String sqlquery3="select empNo,empName,job,sal,deptNo,mgrNo from emp where job IN(:job1,:job2)";

	@Autowired
	public NamedParameterJdbcTemplate jdbcTemplate; 
	
	static {
		System.out.println("CustomerDaoImplClass.enclosing_method()");
	}
	
	public CustomerDaoImplClass()
	{
		System.out.println("CustomerDaoImplClass.CustomerDaoImplClass()");
	}

//	@Override // by normal procedure
//	public int getCustomerCount() {
//	return  jdbcTemplate.query(sqlquery, (rs)->{
//		int res=0;
//		res=rs.getInt(1);
//		return res ;
//	});
//	 
//	}
	
//	public static class EmployeeMapper implements ResultSetExtractor<Integer>
//	{
//
//			@Override
//			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
//				
//				int res=0;
//				res=rs.getInt(1);
//				return res ;
//			}
//			
//		}

	@Override // by lambda expression
	public String getEmployeeNameById(int no) {
		Map<String,Integer> map = Map.of("no",no);
		return jdbcTemplate.query(EmpName, map, (rs)->{
			String res=null;
			while(rs.next()) {
			 res= rs.getString(1);
			}
			return res;
		});
	}


	@Override // by using anonymous class
	public List<EmployeeDTO> getEmployeesDetailsById(int id1,int id2) {
		MapSqlParameterSource sql = new MapSqlParameterSource();
		List<EmployeeDTO> dtos = new ArrayList<>();
		sql.addValue("id1", id1);
		sql.addValue("id2", id2);
	  return  jdbcTemplate.query(EmpObj,sql,(rs)->
		{
			while(rs.next()) {
				EmployeeDTO dto = new EmployeeDTO();
				dto.setEmpNo(rs.getInt(1));
				dto.setEmpName(rs.getString(2));
				dto.setJob(rs.getString(3));
			    dto.setSal(rs.getDouble(4));
			    dto.setDeptNo(rs.getInt(5));
			    dto.setMgrNo(rs.getInt(6));
			    dtos.add(dto);
			}
			return dtos;
		});
	
		
	}
	
    

	@Override 
	public List<EmployeeDTO> getEmployeeDetailsById(int id1,int id2) {
		MapSqlParameterSource sql = new MapSqlParameterSource();
		List<EmployeeDTO> dtos = new ArrayList<>();
		sql.addValue("id1", id1);
		sql.addValue("id2", id2);
	 jdbcTemplate.query(EmpObj1, sql, (rs)->
		{
			EmployeeDTO dto = new EmployeeDTO();
			dto.setEmpNo(rs.getInt(1));
			dto.setEmpName(rs.getString(2));
			dto.setJob(rs.getString(3));
		    dto.setSal(rs.getDouble(4));
		    dto.setDeptNo(rs.getInt(5));
		    dto.setMgrNo(rs.getInt(6));
		    dtos.add(dto);
		    
	});
			return dtos;
	}

	@Override
	public int insertEmployee(EmployeeDTO dto) {
		BeanPropertySqlParameterSource beanPropertySqlParameterSource = new BeanPropertySqlParameterSource(dto);
		return jdbcTemplate.update(updateQurty, beanPropertySqlParameterSource);
	}

	@Override
	public int updateSalary(int increment, String job) {
		MapSqlParameterSource mapSqlParameterSource= new MapSqlParameterSource();
		mapSqlParameterSource.addValue("increment", increment);
		mapSqlParameterSource.addValue("job", job);
		return jdbcTemplate.update(updateQuery, mapSqlParameterSource);
	}

@Override
public List<Map<String, Object>> getEmployeeListByJob(String job1,String job2) {
		// return jdbcTemplate.queryForList(sqlquery1, job);
	MapSqlParameterSource mapSqlParameterSource1= new MapSqlParameterSource();
	mapSqlParameterSource1.addValue("job1", job1);
	mapSqlParameterSource1.addValue("job2", job2);
	return jdbcTemplate.queryForList(sqlquery3, mapSqlParameterSource1);
			//.queryForList(sqlquery1,job1,job2);
}

@Override
public List<Object> getEmployeeListByUsingResultSetExtractor(int id1, int id2) {
	MapSqlParameterSource parameterSource = new MapSqlParameterSource();
	parameterSource.addValue("id1", id1);
	parameterSource.addValue("id2", id2);
	return jdbcTemplate.query(sqlquery1, parameterSource, (res,num)->{
		System.out.println("CustomerDaoImplClass.getEmployeeListByUsingResultSetExtractor()");
		List<EmployeeDTO> dtos = new ArrayList<>();
			EmployeeDTO dto= new EmployeeDTO();
			dto.setEmpNo(res.getInt(1));
			dto.setEmpName(res.getString(2));
			dto.setJob(res.getString(3));
			dto.setSal(res.getDouble(4));
			dto.setDeptNo(res.getInt(5));
			dto.setMgrNo(res.getInt(6));
			dtos.add(dto);
		    return dtos;
	});
}

//@Override
//public List<EmployeeDTO> getEmployeeListByUsingResultSetExtractor1(int id1, int id2) {
////	return jdbcTemplate.query(sqlquery2, 
////			new RowMapperResultSetExtractor<EmployeeDTO>(new BeanPropertyRowMapper<EmployeeDTO>(EmployeeDTO.class)), id1,id2);
//          return  jdbcTemplate.query(sqlquery2, new ResultSetExtractor<List<EmployeeDTO>>()
//        		  {
//					@Override
//					public List<EmployeeDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
//						System.out.println(
//								"CustomerDaoImplClass.getEmployeeListByUsingResultSetExtractor1(...).new ResultSetExtractor() {...}.extractData()");
//						List<EmployeeDTO> dtos = new ArrayList<>();
//						while(rs.next())
//						{
//							EmployeeDTO dto= new EmployeeDTO();
//							dto.setEmpNo(rs.getInt(1));
//							dto.setEmpName(rs.getString(2));
//							dto.setJob(rs.getString(3));
//							dto.setSal(rs.getDouble(4));
//							dto.setDeptNo(rs.getInt(5));
//							dto.setMgrNo(rs.getInt(6));
//							dtos.add(dto);
//						}
//						return dtos;
//					}
//        		  }, id1,id2);
//       }
//
//@Override
//public List<EmployeeDTO> getEmployeeDetailsByUsingRowCallBackHandler(int id1, int id2) {
//	   List<EmployeeDTO> dtos = new ArrayList<>();
//	  jdbcTemplate.query(sqlquery3, new RowCallbackHandler()
//			  {
//				@Override
//				public void processRow(ResultSet rs) throws SQLException {
//					System.out.println(
//"CustomerDaoImplClass.getEmployeeDetailsByUsingRowCallBackHandler(...).new RowCallbackHandler() {...}.processRow()");
//						EmployeeDTO dto= new EmployeeDTO();
//						dto.setEmpNo(rs.getInt(1));
//						dto.setEmpName(rs.getString(2));
//						dto.setJob(rs.getString(3));
//						dto.setSal(rs.getDouble(4));
//						dto.setDeptNo(rs.getInt(5));
//						dto.setMgrNo(rs.getInt(6));
//						dtos.add(dto);
//				}
//			   },id1,id2);
//	  dtos.forEach(System.out::println);
//	  return dtos;
//    }

HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
 LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
 HibernateTemplate hibernateTemplate = new HibernateTemplate();
}
	    
	    
	    

	

