package in.com.service;

import in.com.Dao.IStudentDao;
import in.com.Dto.Student;
import in.com.StudentDaoFactory.StudentDaoFactoryClass;


public class IStudentServiceImplClass implements IStudentService {

	IStudentDao Isdao =null;
	public Student searchStudent(int sid) {
		Isdao = StudentDaoFactoryClass.getDao();
		 Student std =Isdao.searchStudent(sid);
		 return std;
	 }

	public String addStudent(int sid, String name,int age) {
		Isdao = StudentDaoFactoryClass.getDao();
		String str =Isdao.addStudent(sid,name,age);
		return str;
	}

	public String deleteStudent(int sid) {
		Isdao = StudentDaoFactoryClass.getDao();
		String str =Isdao.deleteStudent(sid);
		return str;
		
	}

	public String updateStudent(Student student) {
		Isdao = StudentDaoFactoryClass.getDao();
		String std=Isdao.updateStudent(student);
		return std;
		
	}

}
