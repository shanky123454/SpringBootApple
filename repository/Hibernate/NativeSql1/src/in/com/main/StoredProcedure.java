package in.com.main;

import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.query.NativeQuery;

import in.com.model.Student2;
import in.com.util.Util;

public class StoredProcedure {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session =null;
		boolean flag = false;
		Integer std = null;
		Student2 student=null;

	try {
		session= Util.getSession();
		if(session!=null)
		{
			  Integer id1=1;
		      Integer id2=4;
	      ProcedureCall call =   session.createStoredProcedureCall("new_procedure_by_id", Student2.class);
	    
	       call.registerParameter(1, Integer.class, ParameterMode.IN).bindValue(id1);
	       call.registerParameter(2, Integer.class, ParameterMode.IN).bindValue(id2);
	       
	       List<Student2> list =call.getResultList();
	       
	       list.forEach(System.out::println);
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
