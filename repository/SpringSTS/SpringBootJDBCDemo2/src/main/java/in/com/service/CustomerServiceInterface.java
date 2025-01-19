package in.com.service;

import java.util.List;
import java.util.Map;

import in.com.DTO.EmployeeDTO;

public interface CustomerServiceInterface {
	
	
	public int getCustomerCount();
	public String getEmployeeNameById(int empNo);
	public List<Map<String, Object>> getEmployeesDetailsById(int id1,int id2);
	public Map<String,Object> getEmployeeDetailsById(int id1); 
	public int insertEmployee(int empNo, String empName,String job,Float sal,int deptNo,int mgrNo);
	public int updateSalary(int increment,String job);

	
	
}
