package in.com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

@Entity
@DynamicInsert(value = true)
public class Student {
	
	    @Id
// 1.   @GeneratedValue(strategy=GenerationType.IDENTITY)
	 
// 2.  Hibernate: create sequence hibernate_sequence start with 1 increment by 1
//	   @GeneratedValue(strategy=GenerationType.SEQUENCE)

// 3.  (hibernate creates a sequence called SID_SEQ_GEN with initialValue=1, allocationSize=50)
	   @SequenceGenerator(name = "gen1", sequenceName = "SID_SEQ_GEN")
	   @GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	  
	  
// 4. (sequence already exists if not then creates with initialValue=5, allocationSize=5 )
//	   @SequenceGenerator(name = "gen1", sequenceName = "JPA_SID_SEQ", initialValue = 5, allocationSize = 5)
//	   @GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)

// 5.  Hibernate: create sequence hibernate_sequence start with 1 increment by 1
//	   @GeneratedValue(strategy=GenerationType.AUTO)
	  
	public int sid;
	
	public String sname;
	
	public int sage;
	
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
		 return sid+" " + sname+" " +sage +" "+ saddress;
	}


}
