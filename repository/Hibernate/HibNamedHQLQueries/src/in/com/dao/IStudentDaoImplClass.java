package in.com.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.com.model.Student;
import in.com.util.Util;

public class IStudentDaoImplClass implements IStudentDao {

	@SuppressWarnings("finally")
	@Override
	public String getage(int age) {
		Session session =null;
		boolean flag = false;
		Transaction tr= null;

	try {
		session= Util.getSession();
		if(session!=null) 
		  {
			tr=session.beginTransaction();
	   // Query<Student> query = session.createQuery("INSERT into in.com.model.Student2 (sid,sname,sage,saddress) SELECT i.sid,i.sname,i.sage,i.saddress from in.com.model.Student as i WHERE i.sage>=:min");
	     
			Query query= session.getNamedQuery("APNA BHAI SUPERSTAR");
			query.setParameter("min",age);
	    int std= query.executeUpdate();
	          flag=true;
		  }		
	}catch(Exception e)
	{
		e.printStackTrace();
	}finally {
		if(flag==true)
		{
			tr.commit();
			return "updated successfully";
		}
		else {
			tr.rollback();
			Util.closeSession(session);
			Util.closeSessionFactory();
			return "not updated";
		}
	}

}
}
