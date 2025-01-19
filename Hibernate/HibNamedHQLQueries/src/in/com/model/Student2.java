package in.com.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import org.hibernate.annotations.DynamicInsert;

@Entity
@DynamicInsert(value = true)
@NamedQuery(name="APNA BHAI SUPERSTAR", query="INSERT into in.com.model.Student2 (sid,sname,sage,saddress) SELECT i.sid,i.sname,i.sage,i.saddress from in.com.model.Student as i WHERE i.sage>=:min")
public class Student2 implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	public int sid;
	
	public String sname;
	
	public int sage;
	
	public String saddress;

	public Student2()
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
		 return sid+" " + sname+" " +sage +" "+ saddress;
	}


}
