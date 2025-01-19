package in.com.employee;

public class Employee {

	public int eid;
	public String ename;
	public int eage;
	public Address address; // HAS-A Relationship
	
	static {
		System.out.println("Employee.static block method()");
	}
	public Employee()
	{
		System.out.println("using zero-param constructor");
	}
	
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getEage() {
		return eage;
	}
	public void setEage(int eage) {
		this.eage = eage;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", eage=" + eage + ", address=" + address + "]";
	}
	
	
}
