package com.jdbc.image;
import com.jdbc.in.Util;


import java.util.*;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.*;

public class file2 {

	public static void main(String[] args) {
		
		Connection conn  = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			conn=Util.getconnection();
			String insertquery ="select id,city_name,history from cities where id=?";
			if(conn!=null)
			{
				pstmt = conn.prepareStatement(insertquery);
			}
			if(pstmt!=null)
			{
				System.out.println("enter the id of the city");
				int id= sc.nextInt();
//				
//				System.out.println("enter the location of the pdf file:");
//				String loc = sc.next();
				
				pstmt.setInt(1, id);
				//pstmt.setString(2, loc);
//				pstmt.setCharacterStream(2, new FileReader(loc));
				res = pstmt.executeQuery();
			}
				if(res!=null)
				{
					if(res.next()) {
					System.out.println("ID\t CITY_NAME\t HISTORY");
				int sid =	res.getInt("id");
				String name = res.getString("city_name");
				Reader r = res.getCharacterStream("history");
				
				File fo= new File("C:\\Users\\ASUS\\Downloads\\hero.txt");
				FileWriter fw  = new FileWriter(fo);
				IOUtils.copy(r, fw);
				
				fw.flush();
				fw.close();
				
				System.out.println(sid +"\t" + name +"\t" + fo.getAbsolutePath());
			     }
				}
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
