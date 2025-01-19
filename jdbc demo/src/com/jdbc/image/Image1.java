package com.jdbc.image;
import com.jdbc.in.Util;
import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
public class Image1 {

	public static void main(String[] args) {
		
		Connection conn  = null;
		PreparedStatement pstmt = null;
		int roweffected=0;
		Scanner sc = new Scanner(System.in);
		
		try {
			conn=Util.getconnection();
			String insertquery ="insert into person(name,image) values(?,?)";
			if(conn!=null)
			{
				pstmt = conn.prepareStatement(insertquery);
			}
			if(pstmt!=null)
			{
				System.out.println("enter the name of the person");
				String name = sc.next();
				
				System.out.println("enter the location of the image file:");
				String loc = sc.next();
				
				pstmt.setString(1, name);
				pstmt.setBinaryStream(2, new FileInputStream(new File("C:\\Users\\ASUS\\Downloads\\5bd2b866832bf-wallpaper-preview.jpg")));
				roweffected = pstmt.executeUpdate();
				
			}
			System.out.println("no of rowseffected is: " + roweffected);
		} catch (SQLException | IOException e) {
			
			e.printStackTrace();
		}catch(Exception e1)
		{
			e1.printStackTrace();
		}
		finally
		{
			try {
				Util.cleanup(conn, pstmt, null);
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}

	}

}
