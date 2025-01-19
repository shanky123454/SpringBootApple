package in.com.employee;

import java.util.Arrays;
import java.util.Date;

public class Employee {

 public float[] marksInfo;
 public Date[] listDates;
	
	
	static {
		System.out.println("Employee.static block method()");
	}
	public Employee()
	{
		System.out.println("using zero-param constructor");
	}
	public float[] getMarksInfo() {
		return marksInfo;
	}
	public void setMarksInfo(float[] marksInfo) {
		this.marksInfo = marksInfo;
	}
	public Date[] getListDates() {
		return listDates;
	}
	public void setListDates(Date[] listDates) {
		this.listDates = listDates;
	}
	@Override
	public String toString() {
		return "Employee [marksInfo=" + Arrays.toString(marksInfo) + ", listDates=" + Arrays.toString(listDates) + "]";
	}
	
}
