package in.com.main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import in.com.model.Student;
import in.com.model.StudentDetails;
import in.com.util.Util;

public class InsertApp {

	public static void main(String[] args) throws Exception {
		Session session =null;
		boolean flag = false;
		Student student=null;
		Transaction transaction =null;
		Student id = null;
		StudentDetails sd=null;
		
	try {
		session= Util.getSession();
		if(session!=null)
		{
		transaction= session.beginTransaction();
		}
		if(transaction!=null)
		{
			student = new Student();
	        student.setCid(121);
	        student.setSid(91);
			
	         sd = new StudentDetails();
	        sd.setSname("Ritu Raj");
	        sd.setSemester(8);
	       // sd.setDob(new Date(1998, 10, 14));
	        sd.setDob(LocalDate.of(1997, 10, 31));
	        sd.setDoj(LocalDateTime.of(2022, 8, 4, 7, 30));
	        sd.setStd_course("dbms");
	        sd.setStudent(student);
	       
	        
		id=	(Student)session.save(sd);
		    flag=true;
		}
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	finally {
		if(flag==true)
		{
			transaction.commit();
			System.out.println("object got inserted with id:" + id);
			System.out.println(sd);
	     }
		else {
			transaction.rollback();
			System.out.println("object not got inserted with id::" +id);
		    }
	Util.closeSession(session);
	Util.closeSessionFactory();
	}
	}
}

