package in.com.project;

import java.util.Arrays;
import java.util.Objects;

public class Employee {
	
	public Integer salary;
	public String name;
	
	
	public Employee(int salary, String name) {
		this.salary = salary;
		this.name = name;
	}
	public int getSalary() { 
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Employee [salary=" + salary + ", name=" + name + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(name, salary);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(name, other.name) && Objects.equals(salary, other.salary);
	}
	
	
}
