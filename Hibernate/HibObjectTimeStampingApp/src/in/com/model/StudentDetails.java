package in.com.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class StudentDetails implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	public Student student;
	
	
	public String sname;
	public int Semester;
	public LocalDate dob;
	public LocalDateTime doj;
	public String Std_course;
	
	@Version
	public int versionCount;
	
	@CreationTimestamp
	public LocalDateTime creationDateTime;
	
	@UpdateTimestamp
	public LocalDateTime updatedDateTime;
	
	public LocalDateTime getCreationDateTime() {
		return creationDateTime;
	}
	public void setCreationDateTime(LocalDateTime creationDateTime) {
		this.creationDateTime = creationDateTime;
	}
	public LocalDateTime getUpdatedDateTime() {
		return updatedDateTime;
	}
	public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}
	

	public int getVersionCount() {
		return versionCount;
	}
	public void setVersionCount(int versionCount) {
		this.versionCount = versionCount;
	}
	public String getStd_course() {
		return Std_course;
	}
	public void setStd_course(String std_course) {
		Std_course = std_course;
	}
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
		return student+"" +sname+" " + Std_course +" " + versionCount+" " +Semester +" " + dob+" " + doj
				+" "+creationDateTime+" "+updatedDateTime ;
	}
	

}
