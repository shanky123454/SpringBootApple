package com.jdbc.image;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.jdbc.in.Util;

//public class Image2 {
//
//	public static void main(String[] args) {
//
//		Connection connection = null;
//		PreparedStatement pstmt = null;
//		ResultSet resultSet = null;
//		Scanner sc= new Scanner(System.in);
//		int id =0;
//
//		try {
//			connection = Util.getconnection();
//
//			String sqlSelectQuery = "select id,name,image from person where id=?";
//			if (connection != null)
//				pstmt = connection.prepareStatement(sqlSelectQuery);
//
//			if (pstmt != null) {
//				// setting input values
//				System.out.println("enter the id of the student");
//				 id = sc.nextInt();
//				pstmt.setInt(1, id);
//
//				// executing the query
//				resultSet = pstmt.executeQuery();
//			}
//
//			if (resultSet != null) {
//
//				// processing the resultSet
//				if (resultSet.next()) {
//					System.out.println("ID\tNAME\tIMAGE");
//					int sid = resultSet.getInt("id");
//					String name = resultSet.getString("name");
//					InputStream fis = resultSet.getBinaryStream("image");
//
//					FileOutputStream fos= new FileOutputStream(new File("C:\\Users\\ASUS\\Downloads","copy.jpg"));
//					 int a = fis.read();
//					while(a!=-1)
//					{
//						fos.write(a);
//						a = fis.read();
//					}
//					fos.close();
//					
//					System.out.println(sid +"\t" + name +"\t" + fis);
//				} else {
//					System.out.println("Record not available for the given id :: " + id);
//				}
//
//			}
//
//		} catch (SQLException | IOException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//
//			try {
//				Util.cleanup(connection, pstmt, resultSet);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//
//	}
//
//}

//======================================================================================


public class Image2 {

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		Scanner sc= new Scanner(System.in);
		int id =0;

		try {
			connection = Util.getconnection();

			String sqlSelectQuery = "select id,name,image from person where id=?";
			if (connection != null)
				pstmt = connection.prepareStatement(sqlSelectQuery);

			if (pstmt != null) {
				// setting input values
				System.out.println("enter the id of the student");
				 id = sc.nextInt();
				pstmt.setInt(1, id);

				// executing the query
				resultSet = pstmt.executeQuery();
			}

			if (resultSet != null) {

				// processing the resultSet
				if (resultSet.next()) {
					System.out.println("ID\tNAME\tIMAGE");
					int sid = resultSet.getInt("id");
					String name = resultSet.getString("name");
					InputStream fis = resultSet.getBinaryStream("image");
					byte[] b= new byte[1024];
					FileOutputStream fos= new FileOutputStream(new File("C:\\Users\\ASUS\\Downloads","copy.jpg"));
					while(fis.read(b)>0)
					{
						
						fos.write(b);
					}
					fos.close();
					
					System.out.println(sid +"\t" + name +"\t" + fis);
				} else {
					System.out.println("Record not available for the given id :: " + id);
				}

			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				Util.cleanup(connection, pstmt, resultSet);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}

//========================================================================================================
//import org.apache.commons.io.IOUtils;
//public class Image2 {
//
//	public static void main(String[] args) {
//
//		Connection connection = null;
//		PreparedStatement pstmt = null;
//		ResultSet resultSet = null;
//		Scanner sc= new Scanner(System.in);
//		int id =0;
//
//		try {
//			connection = Util.getconnection();
//
//			String sqlSelectQuery = "select id,name,image from person where id=?";
//			if (connection != null)
//				pstmt = connection.prepareStatement(sqlSelectQuery);
//
//			if (pstmt != null) {
//				// setting input values
//				System.out.println("enter the id of the student");
//				 id = sc.nextInt();
//				pstmt.setInt(1, id);
//
//				// executing the query
//				resultSet = pstmt.executeQuery();
//			}
//
//			if (resultSet != null) {
//
//				// processing the resultSet
//				if (resultSet.next()) {
//					System.out.println("ID\tNAME\tIMAGE");
//					int sid = resultSet.getInt("id");
//					String name = resultSet.getString("name");
//					InputStream fis = resultSet.getBinaryStream("image");
//				
//					FileOutputStream fos= new FileOutputStream(new File("C:\\Users\\ASUS\\Downloads","copy.jpg"));
//					IOUtils.copy(fis, fos);
//					
//					fos.close();
//					
//					System.out.println(sid +"\t" + name +"\t" + fis);
//				} else {
//					System.out.println("Record not available for the given id :: " + id);
//				}
//
//			}
//
//		} catch (SQLException | IOException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//
//			try {
//				Util.cleanup(connection, pstmt, resultSet);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//
//	}
//
//}
