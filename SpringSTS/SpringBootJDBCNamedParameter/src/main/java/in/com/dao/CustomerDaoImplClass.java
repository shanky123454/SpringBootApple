package in.com.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import in.com.DTO.EmployeeDTO;


@Repository
public class CustomerDaoImplClass implements CustomerDaoInterface {

	@Autowired
	public DataSource dataSource;
	@Override
	public List<EmployeeDTO> getEmployeesDetailsById(int id1, int id2) {
		SimpleJdbcCall call = new SimpleJdbcCall(dataSource);
		call.withProcedureName("shashank").returningResultSet("GetEDetails", 
		new BeanPropertyRowMapper<EmployeeDTO>(EmployeeDTO.class));
		
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("id1", 1);
		mapSqlParameterSource.addValue("id2", 2);
		Map<String,Object> map = call.execute(mapSqlParameterSource);
	@SuppressWarnings("unchecked")
	List<EmployeeDTO> dtos =(List<EmployeeDTO>) map.get("GetEDetails");
		return dtos;
	}
		
		
		@Override
		public void getEmployeesDetailsById1(int id1) {
		SimpleJdbcCall call1 = new SimpleJdbcCall(dataSource);
		call1.withProcedureName("adarsh");
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		//mapSqlParameterSource.addValue("id1", 1);
		mapSqlParameterSource.addValue("id2", 2);
		Map<String,Object> map = call1.execute(mapSqlParameterSource);
		
		String name =(String) map.get("_name");
		int age = (int) map.get("_age");
		
		System.out.println(name +" " +age);
		
		
		
		
		
	}
	
	
   

}
	    
	    
	    

	

