package in.com.main;

import javax.persistence.ParameterMode;
import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;
import in.com.model.Student2;
import in.com.util.Util;

public class StoredProcedure2 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session =null;
		Integer std = null;
	try {
		session= Util.getSession();
		if(session!=null)
		{
		    
	      ProcedureCall call =   session.createStoredProcedureCall("new_procedure_by_SID",Student2.class);
	      Integer id=2;
	       call.registerParameter(1, Integer.class, ParameterMode.IN).bindValue(id);
	       call.registerParameter(2, String.class, ParameterMode.OUT);
	       call.registerParameter(3, Integer.class, ParameterMode.OUT);
	       call.registerParameter(4, String.class, ParameterMode.OUT);
	       
	       
	       String name =(String) call.getOutputParameterValue(2);
	       Integer age =(Integer) call.getOutputParameterValue(3);
	       String address =(String) call.getOutputParameterValue(4);
	      
	       System.out.println(id +" "+name+" " + age + " "+address);
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
