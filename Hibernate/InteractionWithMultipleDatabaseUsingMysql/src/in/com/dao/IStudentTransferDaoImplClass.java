package in.com.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.com.model.Student;
import in.com.model.StudentDetails;
import in.com.util.Mysql2NDHibUtil;
import in.com.util.MysqlHibUtil;

public class IStudentTransferDaoImplClass implements IStudentTransferDao {

	
	@SuppressWarnings("finally")
	@Override
	public String transferstudentbyId(Student s) {
		
		Session mysql2session = Mysql2NDHibUtil.getSession();
		Session mysqlsession = MysqlHibUtil.getSession();
		Transaction transaction =null;
		Student id = null;
		Boolean flag = false;
		
		
		StudentDetails std = mysqlsession.get(StudentDetails.class, s);
		
		if(std==null)
		{
			return "record not available for copying with id::" + s;
		}
		else {
			try {
			transaction = mysql2session.beginTransaction();
			id =(Student) mysql2session.save(std);
			flag=true;
		}catch(Exception e)
			{
			e.printStackTrace();
			}finally
			{
				if(flag==true) {
			   transaction.commit();
				return "record  copied from mysql to mysql2::" +id;
			      }
				else {
					transaction.rollback();
					return "record not copied from mysql to mysql2::" +id;
				     }
				
			}
		}
		
	}
}
	
     

