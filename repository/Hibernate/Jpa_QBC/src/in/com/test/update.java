package in.com.test;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import in.com.model.Student2;
import in.com.util.Util;

public class update {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		Session session =null;
		Transaction transaction =null;
		Boolean flag =false;
		
	try {
		session= Util.getSession();
		if(session!=null)
		{
			transaction = session.beginTransaction();
	        CriteriaBuilder cb = session.getCriteriaBuilder();

		  
		  CriteriaUpdate<Student2> cu1 = cb.createCriteriaUpdate(Student2.class);
		  
		  
		   Root<Student2> r1 = cu1.from(Student2.class);
		   
		  CriteriaUpdate<Student2> cu2 =  cu1.set("sage", 100).where(cb.ge(r1.get("sage"),30));
		  
		  
		  Query query = session.createQuery(cu2);
		  
		   query.executeUpdate();
		
			flag=true;
		

		 }		
	}catch(Exception e)
	{
		e.printStackTrace();
	}finally {
		if(flag==true)
		{
			transaction.commit();
			System.out.println("object got updated");
		}
		else
		{
			transaction.rollback();
			System.out.println("object dont got updated");
		}
	Util.closeSession(session);
	Util.closeSessionFactory();
	
	}
}
}
