package in.com.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import in.com.dto.Student;
import in.com.util.Util;

public class IStudentDaoImplClass implements IStudentDao {
	Session session =null;
	ResultSet res= null;
	int result = 0;
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> searchStudent() {
		Student s= null;
		  List<Student> std = new ArrayList<>();
		try {
			session=Util.getSession();
			if(session!=null)
			{
			Query<Student> query = session.createQuery("FROM in.com.dto.Student");
		     List<Student> list = query.list();
		     for (Student student : list) {
		    	 s= new Student();
		    	 s.setSname(student.getSname());
		    	 s.setSid(student.getSid());
		    	 s.setSage(student.getSage());
		    	 std.add(s);
				 System.out.println(student);
			}
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return std;
	}


}
