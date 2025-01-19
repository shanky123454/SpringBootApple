package in.com.employee;

public class Employee {

	public int eid;
	public String ename;
	public int eage;
	
	
	static {
		System.out.println("Employee.static block method()");
	}
	public Employee(int eid,String ename,int eage)
	{
		
		this.ename=ename;
		this.eage=eage;
		this.eid=eid;
		System.out.println("using 3-param constructor");
	}
	
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", eage=" + eage + "]";
	}

	
	
	
}
