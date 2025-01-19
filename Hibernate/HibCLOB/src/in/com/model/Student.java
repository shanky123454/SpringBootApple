package in.com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.DynamicInsert;

@Entity
@DynamicInsert(value = true)
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int sid;
	
	public String sname;
	
	public int sage;
	
	public String saddress;
	
	@Lob
	public char[] resume;

	@Lob
	public byte[] photo;
	
	public Student()
	{
		System.out.println("hibernate invoked non-parameterised constructor");
	}
	
	
	public char[] getResume() {
		return resume;
	}

	public void setResume(char[] resume) {
		this.resume = resume;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
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
		 return sid+" " + sname+" " +sage +" "+ saddress+" " +resume;
	}


}