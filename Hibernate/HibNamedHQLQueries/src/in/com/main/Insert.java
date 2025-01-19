package in.com.main;

import in.com.dao.IStudentDao;
import in.com.dao.IStudentDaoImplClass;

public class Insert {

	public static void main(String[] args) {
		
		IStudentDao dao = new IStudentDaoImplClass();
		String msg=dao.getage(22);
		System.out.println(msg);
		
}
}
