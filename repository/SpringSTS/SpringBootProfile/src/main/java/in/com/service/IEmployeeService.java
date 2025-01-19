package in.com.service;

import java.util.List;

import in.com.DTO.EmployeeDTO;

public interface IEmployeeService {
	
	public List<EmployeeDTO> getEmpByDesg(String[] desg);

}
