package in.com.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class StudentDetails implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	public Student student;
	
	
	public String sname;
	public int Semester;
	public LocalDate dob;
	public LocalDateTime doj;
	
	

	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSemester() {
		return Semester;
	}
	public void setSemester(int semester) {
		Semester = semester;
	}

	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public LocalDateTime getDoj() {
		return doj;
	}
	public void setDoj(LocalDateTime doj) {
		this.doj = doj;
	}
	
	public String toString()
	{
		return student+"" +sname+" " +Semester +" " + dob+" " + doj;
	}
	

}
