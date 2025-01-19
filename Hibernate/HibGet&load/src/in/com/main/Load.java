package in.com.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import in.com.model.Student;
import in.com.util.Util;

public class Load {

	public static void main(String[] args) {
		Session session =null;
		boolean flag = false;
		Student student = null;
		Integer id =95;
	try {
		session= Util.getSession();
		if(session!=null)
	 student = session.load(Student.class,id);
	 if(student!=null) {
		flag =true;
		System.out.println("student present with id" + student.getSid());
		System.in.read();
		System.out.println("student age is" +student.getAge());
		System.out.println("student name is" +student.getSname());
		System.out.println("student address is" +student.getSaddress());
		}
	 else {
		 System.out.println("student record is not present with id" + id);
	 }
			
	}catch(Exception e)
	{
		e.printStackTrace();
	}finally {
		if(flag==true)
		{
		System.out.println(student);}
		else {
			System.out.println("data not present with given id" + id);
		}
	}
	
	Util.closeSession(session);
	Util.closeSessionFactory();
	
	}
}
