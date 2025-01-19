package in.com.service;

import java.util.List;
import java.util.Map;

import in.com.DTO.EmployeeDTO;

public interface CustomerServiceInterface {
	
	public  List<EmployeeDTO> getEmployeesDetailsById(int id1,int id2);
	public  void getEmployeesDetailsById1(int id1);
}
