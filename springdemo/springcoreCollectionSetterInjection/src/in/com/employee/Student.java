package in.com.employee;
import java.util.Date;
import java.util.List;

public class Student {
	
	public List<String> courses;
	public List<Date> listDate;

	static {
		System.out.println("Employee.static block method()");
	}
	public Student()
	{
		System.out.println("using zero-param constructor");
	}
	public List<String> getCourses() {
		return courses;
	}
	public void setCourses(List<String> courses) {
		this.courses = courses;
	}
	public List<Date> getListDate() {
		return listDate;
	}
	public void setListDate(List<Date> listDate) {
		this.listDate = listDate;
	}
	@Override
	public String toString() {
		return "Student [courses=" + courses + ", listDate=" + listDate + "]";
	}
	
	
}
