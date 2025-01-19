package in.com.service;

import java.util.List;

import in.com.model.Student;

public interface IStudentService {

	public Student addStudent(Student student);
	public String updateStudent(Student s,Integer sid);
	public String deletestudent(Integer sid);
	public Student getOneStudent(Integer sid);
	public List<Student> getAllStudent();
	
}
