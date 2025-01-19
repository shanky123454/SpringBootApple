package in.com.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.com.DTO.EmployeeDTO;
import in.com.dao.CustomerDaoInterface;


@Service(value = "serviceimpl")
public class CustomerServiceImplClass implements CustomerServiceInterface {
	
	@Autowired
	public CustomerDaoInterface daointerface;
	
	static {
		System.out.println("CustomerImplClass.enclosing_method()");
	}
	
	public CustomerServiceImplClass(CustomerDaoInterface daointerface) 
	{
		System.out.println("CustomerServiceImplClass.CustomerServiceImplClass()");
		this.daointerface=daointerface;
	}


	@Override
	public  List<EmployeeDTO> getEmployeesDetailsById(int id1,int id2) {
		List<EmployeeDTO> dtos = daointerface.getEmployeesDetailsById(id1,id2);
		return dtos;
	}
	
	@Override
	public  void getEmployeesDetailsById1(int id1) {
		 daointerface.getEmployeesDetailsById1(id1);
		
	}

}
