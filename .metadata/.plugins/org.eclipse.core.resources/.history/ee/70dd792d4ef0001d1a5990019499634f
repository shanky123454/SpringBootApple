package in.main.persistence;
import java.io.IOException;
import java.sql.*;

import in.main.dto.Student;
import in.main.files.*;

public class IStudentDaoImpl implements IStudentDao {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet res = null;
	int resu=0;
	Student std;
	boolean flag =false;
	@Override
	//@SuppressWarnings("unused")
	public Student searchStudent(int sid) {
		
	   try {
		con=Util.getconnection();
		String Stringquery ="select id,name,age from student where id=?";
		
		if(con!=null)
		{
			pstmt = con.prepareStatement(Stringquery);
			
			pstmt.setInt(1, sid);
		}
		if(pstmt!=null)
		{
			res= pstmt.executeQuery();
		}
		if(res!=null)
		{
			if(res.next())
			{
			 std = new Student();
			
			   std.setId(res.getInt(1));
			   std.setName(res.getString(2));
			   std.setAge(res.getInt(3));
			 
		    }
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
		return std;
	}

	@SuppressWarnings("unused")
	@Override
	public String deleteStudent(int sid) {
		
		 try {
			     
				con=Util.getconnection();
				String Stringquery ="delete from student where id=?";
				
				if(con!=null)
				{
					pstmt = con.prepareStatement(Stringquery);
					
					pstmt.setInt(1, sid);
				}
				if(pstmt!=null)
				{
					resu= pstmt.executeUpdate();
				}
				if(resu==1)
				{
					flag=true;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(flag==true)
			{
				return "success";
			}
			else
				
				return "record unavailable to delete";
	}

	@Override
	@SuppressWarnings("unused")
	public String addStudent(int id, String name, int age) {
		
		try {
			con = Util.getconnection();
			
			if(con!=null)
			{
				String insertquery = "insert into student values (?,?,?)";
				pstmt=con.prepareStatement(insertquery);
				pstmt.setInt(1, id);
				pstmt.setString(2, name);
				pstmt.setInt(3, age);
			}
			
			if(pstmt!=null)
			{
				resu= pstmt.executeUpdate();
			}
			if(resu==1)
			{
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(flag==true)
		{
			return "success";
		}
		else
			
			return "record unavailable to insert";
	}

	@Override
	public String updateStudent(Student student) {
		try {
			con= Util.getconnection();
			
			if(con!=null)
			{
				String query="update student set name=?,age=? where id=?";
				pstmt= con.prepareStatement(query);
				pstmt.setInt(3, student.getId());
				pstmt.setString(1, student.getName());
				pstmt.setInt(2, student.getAge());
			}
			if(pstmt!=null)
			{
				resu=pstmt.executeUpdate();
			}
			if(resu==1)
			{
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(flag==true)
		{
			return "success";
			
		}
		else
			
			return "record unavailable to insert";
	}

}
