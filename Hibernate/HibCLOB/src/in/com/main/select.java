package in.com.main;

import java.io.File;
import java.io.FileWriter;

import org.hibernate.Session;

import in.com.model.Student;
import in.com.util.Util;

public class select {

	public static void main(String[] args) {
		Session session =null;
		boolean flag = false;
		Student std = null;
		
		char[] imageReader =null;

	try {
		session= Util.getSession();
		std=session.get(Student.class, 1117);
		imageReader= std.getResume();
		File f = new File("C:\\Users\\ASUS\\Downloads", "hero1.txt");
		 FileWriter fr = new FileWriter(f);
		 fr.write(imageReader);
		 fr.flush();
		
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
