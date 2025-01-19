package in.com.service;

import in.com.Dto.Student;

public interface IStudentService {
        
	    public String addStudent(int sid, String name,int age);
	    public String deleteStudent(int sid);
	    public String updateStudent(Student student);
		public Student searchStudent(int sid);
}
