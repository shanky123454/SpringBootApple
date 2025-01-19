package in.main.persistence;

import in.main.dto.Student;

public interface IStudentDao {
	
	public Student searchStudent(int sid);
	public String deleteStudent(int sid);
	public String addStudent(int sid,String name,int age);
	public String updateStudent(Student student);

}


//  DAO ===> DATA ACCESS OBJECT LAYER (MAINLY WE CALL PERSISTENCE LAYER OR DATABASE ACCESS LAYER)
//  DTO ===> DATA TRANSFER OBJECT 