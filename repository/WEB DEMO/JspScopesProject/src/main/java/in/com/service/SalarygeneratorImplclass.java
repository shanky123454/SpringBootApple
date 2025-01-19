package in.com.service;

import in.com.dto.Employee;

public class SalarygeneratorImplclass implements SalaryGenerator {

	@Override
	public Employee salarygenerator(Employee emp) {
	    emp.gsalary= emp.bsalary + emp.bsalary*0.2f;
	    emp.nsalary = emp.gsalary + emp.bsalary;
	    
	    emp.setGsalary(emp.gsalary);
	    emp.setNsalary(emp.nsalary);
	    
	    
	    return emp;
	}
}
