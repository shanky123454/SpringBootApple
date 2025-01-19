package in.com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.com.Dto.Student;
import in.com.util.Util;

public class IStudentDaoImplClass implements IStudentDao {
	Connection con =null;
	PreparedStatement pstmt =null;
	ResultSet res= null;
	int result = 0;
	

	@Override
	public Student searchStudent(int sid) {
		Student s= new Student();
		try {
			con=Util.getConnection();
			if(con!=null)
			{
				String query="select sid,sname,sage from student where sid=?";
				pstmt = con.prepareStatement(query);
			}
			if(pstmt!=null)
			{
				pstmt.setInt(1, sid);
				res= pstmt.executeQuery();
			}
			if(res!=null)
			{
				while(res.next())
				{
					int id = res.getInt(1);
					s.setSid(id);
					String name = res.getString(2);
					s.setSname(name);
					int age = res.getInt(3);
					s.setSage(age);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public String addStudent(int sid, String name, int age) {
		String ret="";
		try {
			
			con=Util.getConnection();
			if(con!=null)
			{
				String query="insert into student(sid,sname,sage) values(?,?,?)";
				pstmt = con.prepareStatement(query);
			}
			if(pstmt!=null)
			{
			pstmt.setInt(1, sid);
			pstmt.setString(2, name);
			pstmt.setInt(3, age);
			
			result=pstmt.executeUpdate();
			}
			
			if(result==1)
			{
				ret="success";
			}
			else {
				ret="failure";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}

	@Override
	public String deleteStudent(int sid) {
		String ret="";
		try {
			
			con=Util.getConnection();
			if(con!=null)
			{
				String query="delete from student where sid=?";
				pstmt = con.prepareStatement(query);
			}
			if(pstmt!=null)
			{
			pstmt.setInt(1, sid);
			result=pstmt.executeUpdate();
			}
			
			if(result==1)
			{
				ret="success";
			}
			else {
				ret="failure";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}

	@Override
	public String updateStudent(Student student) {
		String ret="";
		try {
			con=Util.getConnection();
			if(con!=null)
			{
				String query="update  student set sname=?, sage=? where sid=?";
				pstmt = con.prepareStatement(query);
			}
			if(pstmt!=null)
			{
				pstmt.setInt(3, student.getSid());
				pstmt.setString(1, student.getSname());
				pstmt.setInt(2, student.getSage());
				result= pstmt.executeUpdate();
			}
			if(result==1)
			{
				ret="success";
			}
			
			else {
				ret="failure";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

}
