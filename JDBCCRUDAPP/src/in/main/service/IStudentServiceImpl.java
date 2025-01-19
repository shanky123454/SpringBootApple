package in.main.service;

import in.main.daofactory.StudentDaoFactory;
import in.main.dto.Student;
import in.main.persistence.IStudentDao;

public class IStudentServiceImpl implements IStudentService {
	IStudentDao stdDao;
	
	
	@Override
	public Student searchStudent(int sid) {
		stdDao=StudentDaoFactory.getStudentDao(); 
		return stdDao.searchStudent(sid);
	}

	@Override
	public String deleteStudent(int sid) {
		stdDao=StudentDaoFactory.getStudentDao(); 
		return stdDao.deleteStudent(sid);
	}

	@Override
	public String addStudent(int sid, String name, int age) {
		stdDao=StudentDaoFactory.getStudentDao(); 
		return stdDao.addStudent(sid, name, age);
	}

	@Override
	public String updateStudent(Student student) {
		stdDao=StudentDaoFactory.getStudentDao();
		return stdDao.updateStudent(student);
	}

}
