package in.com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Version;

import org.hibernate.annotations.DynamicInsert;

@Entity
@DynamicInsert(value = true)
@NamedNativeQuery(name="Bhai_Insert_Kro",query = "INSERT into Student2 (sid,saddress,sage,sname) values(:id,:address,:age,:name)")
public class Student2 {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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