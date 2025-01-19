package in.com.main;

import org.hibernate.Session;

import in.com.model.StudentDetails;
import in.com.util.Util;

public class SelectApp {

	public static void main(String[] args) throws Exception {
		Session session =null;

	try {
		session= Util.getSession();
		if(session!=null)
		{
			
		StudentDetails  sd1=session.get(StudentDetails.class,2);//gets from DB put in L2&L1-cache
        StudentDetails  sd2=session.get(StudentDetails.class, 2);//gets from L1-cache
        // Duplicates are not allowed in L1-Cache, it is identified through Id Property 
		session.evict(sd1);//Remove StudentDetails object from L1-cache with id=2. 
		StudentDetails  sd3=session.get(StudentDetails.class, 2);//gets from L2-Cache if not there then from DB put in L2&L1-cache
		System.out.println(sd3);
		StudentDetails  sd7=session.get(StudentDetails.class, 3);//gets from DB put in L2&L1-cache
		System.out.println(sd7);
		StudentDetails  sd4=session.get(StudentDetails.class,3);//gets from L1-cache
		System.out.println(sd4);
		session.clear();//remove all objects from the L1-cache
		StudentDetails  sd5=session.get(StudentDetails.class,2);//gets from L2-cache if not then from DB put in L1&L2-cache
		System.out.println(sd5);
		StudentDetails  sd6=session.get(StudentDetails.class,3);//gets from L2-cache if not then from DB put in L1&L2-cache
		System.out.println(sd6);

		}
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	finally {
	Util.closeSession(session);
	Util.closeSessionFactory();
	}
	}
}

