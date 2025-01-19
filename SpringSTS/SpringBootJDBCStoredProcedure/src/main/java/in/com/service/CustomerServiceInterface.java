package in.com.service;

import java.util.List;
import java.util.Map;

import in.com.DTO.EmployeeDTO;

public interface CustomerServiceInterface {
	
	//public int getCustomerCount(); 
	public String getEmployeeNameById(int empNo);
	public  List<EmployeeDTO> getEmployeesDetailsById(int id1,int id2);
	public List<EmployeeDTO> getEmployeeDetailsById(int id1,int id2); 
	public int insertEmployee(EmployeeDTO dto);
	public int updateSalary(int increment,String job);
	public List<Map<String,Object>> getEmployeeListByJob(String job1,String job2);
	public List<Object> getEmployeeListByUsingResultSetExtractor(int id1,int id2);
//	public List<EmployeeDTO> getEmployeeListByUsingResultSetExtractor1(int id1,int id2);
//	public List<EmployeeDTO> getEmployeeDetailsByUsingRowCallBackHandler (int id1,int id2);
//	
//	
}
