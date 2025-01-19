package in.com.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Demo2")
public class Demo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		response.setContentType("image/jpeg");
		//PrintWriter out =response.getWriter();
		// note ==> we cannot use printwriter and servletoutputstream together
		File f= new File("C:\\Users\\ASUS\\Downloads\\doraemon.jpg");
		FileInputStream fis = new FileInputStream(f);
		
		byte[] b = new byte[(int) f.length()];
		fis.read(b);
		
		
		ServletOutputStream sos= response.getOutputStream();
		sos.write(b);
		
		sos.flush();
		fis.close();
		sos.close();
		
		
	}

	

}
