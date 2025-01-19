package in.com.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import in.com.model.Student;
import in.com.util.Util;

public class HibMerge {

	public static void main(String[] args) {
		Session session =null;
		boolean flag = false;
		Student student = null;
		Student std1=null;
		Student std2=null;
		Transaction transaction =null;

	try {
		session= Util.getSession();
		if(session!=null)
		{
		std1=session.get(Student.class, 1);
		System.out.println("after loading the data into L1-Cache" + std1);
		}
		transaction = session.beginTransaction();
		  if(transaction!=null)  
		  {
	     student = new Student();
	     student.setSid(1);
		 student.setSname("SHASHANK RAJ Madhu");
		 student.setAge(28);
		 student.setSaddress("BLR");
		 std2=(Student) session.merge(student);
		
		System.out.println("After merging in L1Cache :: "+std2);
		System.out.println("After merging in L1Cache :: "+std1);

		System.out.println(student.hashCode() + ":: " + std1.hashCode() + ":: " + std2.hashCode());
		   flag =true;
		  }		
	}catch(Exception e)
	{
		e.printStackTrace();
	}finally {
		if(flag==true)
		{
			transaction.commit();
		System.out.println("object got saved ");}
		else {
			transaction.rollback();
			System.out.println("object not got saved");
		}
	}
	
	Util.closeSession(session);
	Util.closeSessionFactory();
	
	}
}
