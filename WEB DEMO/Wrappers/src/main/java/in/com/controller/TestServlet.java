package in.com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static {
		System.out.println("Testservlet .class is loaded");
	}
	
	public TestServlet()
	{
		System.out.println("TestServlet class object is instatied");
	}
	
	public void init(ServletConfig congif)
	{
		System.out.println("test servlet is initialized ");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String value =request.getParameter("name");
		out.println("<h2 style='color:red;text-align:center;'>"+ value+"</h2>");
		
	}
	
	public void destroy()
	
	{
		System.out.println("object got destroyed");
	}

}
