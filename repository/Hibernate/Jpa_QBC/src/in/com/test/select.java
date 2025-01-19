package in.com.test;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import in.com.model.Student2;
import in.com.util.Util;

public class select {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		Session session =null;
		
		
		//  Aggregate functions are defined on CriteriaBuilder
		//  CriteriaQuery defines a database select query i.e select,from,where

	
	try {
		session= Util.getSession();
		if(session!=null)
		{
	      CriteriaBuilder cb = session.getCriteriaBuilder();
		
		  CriteriaQuery<Student2>  cu = cb.createQuery(Student2.class);
	
		  Root<Student2> r = cu.from(Student2.class);
		  
		  CriteriaQuery<Student2> cq =  cu.select(r).where(cb.ge(r.get("sid"), 2));
		  
		  Query q = session.createQuery(cq);
		 List<Student2> list = q.getResultList();
	        list.forEach(System.out::println);
	 
//   List<Object[]> list = criteria.list();
//    
//    list.forEach(row->{
//                         for (Object student2 : row) {
//							System.out.println(student2);
//						}
//
//                     }
//    		);
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
