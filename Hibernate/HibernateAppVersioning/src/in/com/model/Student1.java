package in.com.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Student1 implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public Student1()
	{
		System.out.println("Student1.Student1()");
	}
public int sid;
public int cid;

public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}

public String toString()
{
	return sid+" " +cid; 
}

}
