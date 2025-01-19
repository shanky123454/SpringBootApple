
package in.com.main;

import in.com.dao.IStudentTransferDao;
import in.com.dao.IStudentTransferDaoImplClass;
import in.com.model.Student;

public class InsertApp {

	public static void main(String[] args) throws Exception {
		
		Student s = new Student();
		s.setCid(121);
		s.setSid(91);
		IStudentTransferDao dao = new IStudentTransferDaoImplClass();
		String str =dao.transferstudentbyId(s);
		System.out.println(str);
		
  }
}

