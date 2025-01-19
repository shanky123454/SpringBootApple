package in.com.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.hibernate.query.NativeQuery;

import in.com.model.Student2;
import in.com.util.Util;

public class select2 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session =null;
	
	try {
		session= Util.getSession();
		if(session!=null)
		{
		 Criteria criteria = session.createCriteria(Student2.class);
		 
		 Criterion c1 = Restrictions.ge("sage",2);
		 Criterion c2 = Restrictions.le("sage",40);
		 
		 criteria.add(c2);
		 criteria.add(c1);
		 
	    List<Student2> list = criteria.list();
	    
	     for (Student2 student2 : list) {
			System.out.println(student2);
		         }
		 }		
	}catch(Exception e)
	{
		e.printStackTrace();
	}finally {
	Util.closeSession(session);
	Util.closeSessionFactory();
	
	}
}
}
