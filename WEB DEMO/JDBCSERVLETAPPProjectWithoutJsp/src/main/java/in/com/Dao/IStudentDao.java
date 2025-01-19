package in.com.Dao;

import in.com.Dto.Student;

public interface IStudentDao {

	    public Student searchStudent(int sid);
	    public String updateStudent(Student student);
	    public String deleteStudent(int sid);
	    public String addStudent(int sid, String name, int age);
	    
}
