package in.com.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
	public int getCustomerCount() {
	int result =daointerface.getCustomerCount();
	return result;
	}

	@Override
	public String getEmployeeNameById(int empNo) {
		String result = daointerface.getEmployeeNameById(empNo);
		return result;
	}

	@Override
	public List<Map<String, Object>> getEmployeesDetailsById(int id1,int id2) {
		List<Map<String, Object>> dtos = daointerface.getEmployeesDetailsById(id1,id2);
		return dtos;
	}

	@Override
	public Map<String, Object> getEmployeeDetailsById(int id1) {
		Map<String, Object> dtos = daointerface.getEmployeeDetailsById(id1);
		System.out.println(dtos);
		return dtos;
	}

	@Override
	public int insertEmployee(int empNo, String empName, String job, Float sal, int deptNo, int mgrNo) {
		int result = daointerface.insertEmployee(empNo, empName, job, sal, deptNo, mgrNo);
		return result;
	}

	@Override
	public int updateSalary(int increment, String job) {
		return daointerface.updateSalary(increment, job);
	}



}
