package in.com.test;

import org.hibernate.Session;


import org.hibernate.Transaction;

import in.com.model.Student3;
import in.com.util.Util2;



public class insert{

	public static void main(String[] args) {
		Session session =null;
		Transaction transaction = null;
		Integer id1 =0;
		Integer id2 =0;
	try {
		
		session=Util2.getSession();

		Student3 s1 = new Student3(69,"chutiya",55,"patna");
//		s1.setAge(55);
//		s1.setSaddress("patna");
//		s1.setSid(2);
//		s1.setSname("chutiya1");
//		
		
		Student3 s2 = new Student3(96,"jitendra",55,"ranchi");
//		s1.setAge(5);
//		s1.setSaddress("ranchi");
//		s1.setSid(1);
//		s1.setSname("jitendra");
	
		transaction= session.beginTransaction();
	
	     id1 =  (Integer) session.save(s1); 
	     id2 =  (Integer) session.save(s2); 
	 
	     System.out.println(id1);
	     System.out.println(id2);

	}catch(Exception e)
	{
		e.printStackTrace();
	}finally {
		if((id1!=0)&&(id2!=0))
		{
			 transaction.commit();
		}
		else{
			transaction.rollback();
		}
	Util2.closeSession(session);
	Util2.closeSessionFactory();
	
	}
}
}
