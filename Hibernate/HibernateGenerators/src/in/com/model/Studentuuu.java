package in.com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

@Entity
@DynamicInsert(value = true)
public class Studentuuu {

//	@GenericGenerator(name="gen1", strategy="increment")
//	@GeneratedValue(generator="gen1")
	
	
//	@GenericGenerator(name="gen1", strategy="assigned")
//	@GeneratedValue(generator="gen1")// it is default

	
//	@GenericGenerator(name="den1", strategy="identity")
//	@GeneratedValue(generator="den1")
	
//	@GenericGenerator(name = "gen1", strategy = "sequence", parameters = {
//                          @Parameter(value = "sid_seq", name = "sequence_name") })
//  @GeneratedValue(generator = "gen1")     // for custom id generator by sequence strategy
//	
//	@GenericGenerator(name="gen1", strategy="sequence")
//	@GeneratedValue(generator="gen1")
//	
//	@GenericGenerator(name="gen1", strategy="native")
//	@GeneratedValue(generator="gen1")
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int sid;
	
	public String sname;
	
	public int sage;
	
	public String saddress;
	
	public Studentuuu()
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
