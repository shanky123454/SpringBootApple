package in.com.Dto;

import java.io.Serializable;

public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	public int  sid;
	public String sname;
	public int sage;
	
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	@Override
	public String toString() {
		return sid+" "+sname+" "+sage;
		}

}
