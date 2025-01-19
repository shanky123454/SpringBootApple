package com.jdbc.image;
import com.jdbc.in.Util;

import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
public class file1 {

	public static void main(String[] args) {
		
		Connection conn  = null;
		PreparedStatement pstmt = null;
		int roweffected=0;
		Scanner sc = new Scanner(System.in);
		
		try {
			conn=Util.getconnection();
			String insertquery ="insert into cities(city_name,history) values(?,?)";
			if(conn!=null)
			{
				pstmt = conn.prepareStatement(insertquery);
			}
			if(pstmt!=null)
			{
				System.out.println("enter the name of the city");
				String name = sc.next();
//				
//				System.out.println("enter the location of the pdf file:");
//				String loc = sc.next();
				
				pstmt.setString(1, name);
				//pstmt.setString(2, loc);
//				pstmt.setCharacterStream(2, new FileReader(loc));
				//pstmt.setCharacterStream(2, new FileReader("C:\\Users\\ASUS\\Downloads\\1673667413655.pdf"));
				pstmt.setCharacterStream(2, new FileReader("C:\\Users\\ASUS\\shanky.txt"));


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
