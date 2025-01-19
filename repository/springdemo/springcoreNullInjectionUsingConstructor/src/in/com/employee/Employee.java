package in.com.employee;

import java.util.Date;

public class Employee {

	public int eid;
	public String ename;
	public int eage;
	public Address address;
	public Date dob;
	public Date doj;
	
	
	static {
		System.out.println("Employee.static block method()");
	}
	public Employee(int eid,String ename,int eage,Address address,Date dob,Date doj)
	{
		this.eid=eid;
		this.address=address;
		this.ename=ename;
		this.eage=eage;
		this.address=address;
		this.dob=dob;
		this.doj=doj;
		System.out.println("using zero-param constructor");
	}
	
	
	public int getEid() {
		return eid;
	}
	
	public String getEname() {
		return ename;
	}
	
	public int getEage() {
		return eage;
	}
	
	public Address getAddress() {
		return address;
	}

	public Date getDob() {
		return dob;
	}

	public Date getDoj() {
		return doj;
	}


	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", eage=" + eage + ", address=" + address + ", dob=" + dob
				+ ", doj=" + doj + "]";
	}
     
}
