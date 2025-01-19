package in.com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

@Entity
@DynamicInsert(value = true)
public class Student {
	
	    @Id
        @GenericGenerator(name="gen1", strategy="in.com.id.generator.CustomOracleIdGenerator")
	    @GeneratedValue(generator="gen1")
	public String sid;
	
	public String getSid() {
			return sid;
		}

		public void setSid(String sid) {
			this.sid = sid;
		}

	public String sname;
	
	public int sage;
	
	public String saddress;
	
	public Student()
	{
		System.out.println("hibernate invoked non-parameterised constructor");
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
