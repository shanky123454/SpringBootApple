package in.com.service;

import in.com.dao.IStudentDao;
import in.com.dto.Student;

import java.util.List;

import in.com.StudentDaoFactory.StudentDaoFactoryClass;


public class IStudentServiceImplClass implements IStudentService {

	IStudentDao Isdao =null;
	public List<Student> searchStudent() {
		Isdao = StudentDaoFactoryClass.getDao();
		 List<Student> std =Isdao.searchStudent();
		 System.out.println(std);
		 return std;
	 }

}
