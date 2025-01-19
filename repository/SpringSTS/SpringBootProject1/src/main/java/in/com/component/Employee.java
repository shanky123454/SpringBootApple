package in.com.component;

public class Employee {
	static {
		System.out.println("Employee.static method()");
	}

	public Employee()
	{
		System.out.println("Employee.Customer()");
	}
	
	public int eid;
	public String eadd;
	public int eage;
	
	
	public int getEid() {
		return eid;
	}
	
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEadd() {
		return eadd;
	}
	public void setEadd(String eadd) {
		this.eadd = eadd;
	}
	public int getEage() {
		return eage;
	}
	public void setEage(int eage) {
		this.eage = eage;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", eadd=" + eadd + ", eage=" + eage + "]";
	}

}
