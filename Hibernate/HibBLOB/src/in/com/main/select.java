package in.com.main;

import java.io.FileOutputStream;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.com.model.Student;
import in.com.util.Util;

public class select {

	public static void main(String[] args) {
		Session session =null;
		boolean flag = false;
		Student std = null;
		Student student=null;
		//Transaction transaction =null;
		byte[] imageReader =null;

	try {
		session= Util.getSession();
	
		 FileOutputStream fos = new FileOutputStream("C:\\Users\\ASUS\\Downloads\\shanky.png");
		
		std= (Student) session.get(Student.class, 1116);
		imageReader=std.getPhoto();
		 fos.write(imageReader);
		  fos.flush();
		
		   flag =true;
		 		
	}catch(Exception e)
	{
		e.printStackTrace();
	}finally {
		if(flag==true)
		{
		System.out.println("object value is " + std);}
		else {
			System.out.println("object is not present" + std);
		}
	}
	
	Util.closeSession(session);
	Util.closeSessionFactory();
	
	}
}
