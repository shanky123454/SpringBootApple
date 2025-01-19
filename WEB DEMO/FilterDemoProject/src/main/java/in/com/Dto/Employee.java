package in.com.Dto;

public class Employee {
	
	public String eid;
	public String ename;
	public int eage;
	public String eemail;
	public String emobile;
	
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
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
	public String getEemail() {
		return eemail;
	}
	public void setEemail(String eemail) {
		this.eemail = eemail;
	}
	public String getEmobile() {
		return emobile;
	}
	public void setEmobile(String emobile) {
		this.emobile = emobile;
	}
	
	@Override
	public String toString() {
	// return "Employee [ ename="+ename+" , eid="+eid+", eage="+eage+",eemail="+eemail+",emobile="+emobile+"]";
	
	return eid+" "+ename+" "+eage+" "+eemail+" "+emobile;
	}
	
	
	
	
	
	

}
