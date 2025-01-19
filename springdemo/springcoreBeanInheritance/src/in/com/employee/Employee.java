package in.com.employee;

public class Employee {

	public String companyname;
	public int companyid;
	public String companyaddress;
	public int eid;
	public String ename;
	public int eage;
    
	
	static {
		System.out.println("Employee.static block method()");
	}
	public Employee()
	{
		System.out.println("using zero-param constructor");
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public int getCompanyid() {
		return companyid;
	}
	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}
	public String getCompanyaddress() {
		return companyaddress;
	}
	public void setCompanyaddress(String companyaddress) {
		this.companyaddress = companyaddress;
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
	@Override
	public String toString() {
		return "Employee [companyname=" + companyname + ", companyid=" + companyid + ", companyaddress="
				+ companyaddress + ", eid=" + eid + ", ename=" + ename + ", eage=" + eage + "]";
	}

}
