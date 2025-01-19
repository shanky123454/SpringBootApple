package in.main.service;

import in.main.dto.Student;

public interface IStudentService {

	public Student searchStudent(int sid);
	public String deleteStudent(int sid);
	public String addStudent(int sid,String name,int age);
	public String updateStudent(Student student);
}
