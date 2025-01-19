package in.com.controller;

import java.io.IOException;
import in.com.listener.Demolistener;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	           
		         response.setContentType("text/html");
	            PrintWriter out =response.getWriter();
	            
	            out.println("<h2>INSIDE THE SERVLET</h2>");
	          

	            
	           // out.close();
		       
	}

}
