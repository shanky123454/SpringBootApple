package in.com.employee;

public class Employee {

	public int eid;
	public String ename;
	public int eage;
	public Address address; 
	
	static {
		System.out.println("Employee.static block method()");
	}
	public Employee(int eid,String ename,Address address,int eage)
	{
		this.address=address;
		this.ename=ename;
		this.eage=eage;
		this.eid=eid;
		System.out.println("using 4-param constructor");
		System.out.println(this);
		System.out.println(this.hashCode());
	}
	
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", eage=" + eage + ", address=" + address + "]";
	}

	
	
	
}
