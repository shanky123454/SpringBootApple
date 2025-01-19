package in.com.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "dekho")
public class StudentDetails2 implements Serializable {


	private static final long serialVersionUID = 1L;
	
	
	public StudentDetails2() {
		System.out.println("StudentDetails2.StudentDetails2()");
	}

	@EmbeddedId
	public Student1 student;
	
	
	public String sname;
	public int Semester;
	public LocalDate dob;
	public LocalDateTime doj;
	public String Std_course;
	
	@Version
	public int versionCount;
	

	public String getStd_course() {
		return Std_course;
	}
	public void setStd_course(String std_course) {
		Std_course = std_course;
	}
	public Student1 getStudent() {
		return student;
	}
	public void setStudent(Student1 student) {
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
		return student+"" +sname+" " + Std_course +" " + versionCount+" " +Semester +" " + dob+" " + doj;
	}
	

}
