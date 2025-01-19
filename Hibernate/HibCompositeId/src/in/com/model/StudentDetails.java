package in.com.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Version;

@Entity
public class StudentDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	public Student student;
	
	
	public String sname;
	public int Semester;
	
	@Version
	public int versioncount;

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
	@Override
	public String toString() {
		return "StudentDetails [student=" + student + ", sname=" + sname + ", Semester=" + Semester + ", versioncount="
				+ versioncount + "]";
	}

	
	

}
