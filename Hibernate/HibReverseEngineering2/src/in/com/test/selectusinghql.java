package in.com.test;


import java.util.List;


import org.hibernate.Session;
import org.hibernate.query.Query;
import in.com.model.Student2;
import in.com.util.Util;


public class selectusinghql {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Session session =null;
		try {
			session=Util.getSession();
			if (session!=null)
			{
				
		Query<Student2>  query = session.createQuery("FROM in.com.model.Student2");

		List<Student2> list = query.getResultList();
		    list.forEach(System.out::println);
			}
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}finally
			{

			Util.closeSession(session);
			Util.closeSessionFactory();
		    }
		}

}
