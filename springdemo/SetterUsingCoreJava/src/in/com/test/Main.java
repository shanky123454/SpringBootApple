package in.com.test;

import in.com.employee.Address;
import in.com.employee.Employee;

public class Main {

	public static void main(String[] args) {
		
		Address ad = new Address();
		ad.setCity("blr");
		ad.setPincode(560066);
		ad.setState("karnataka");
		
		Employee emp = new Employee();
		emp.setAddress(ad);
		emp.setEage(22);
		emp.setEid(23083);
		emp.setEname("shashank Raj");
		
		System.out.println(emp);

	}

}
