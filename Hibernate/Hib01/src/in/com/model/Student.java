package in.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stdtbl")
public class Student {
	
	@Id
	@Column(name="stdid")
	public int sid;
	@Column(name="stdname")
	public String sname;
	@Column(name="stdage")
	public int sage;
	@Column(name="stdaddress")
	public String saddress;
	
	public Student()
	{
		System.out.println("hibernate invoked non-parameterised constructor");
	}

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

	public int getAge() {
		return sage;
	}

	public void setAge(int age) {
		this.sage = age;
	}

	public String getSaddress() {
		return saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}

	public String toString() {
		 return sid+"" + sname+"" +sage +""+ saddress;
	}


}
