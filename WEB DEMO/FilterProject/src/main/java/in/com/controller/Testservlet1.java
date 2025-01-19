package in.com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Testservlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static {
		System.out.println("testservlet1 .class file is loaded");
	}
	
	public Testservlet1()
	{
		System.out.println("testservlet1 class object is created");
	}
	
	public void init(ServletConfig config)
	{
		System.out.println("testservlet1 object is initiated");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<h2 style='color:red;text-align:center;'> This is first Filter program</h2>");
		System.out.println("inside testservlet1 servlet");
		
	}
	
	public void destroy()
	{
		System.out.println("testservlet1 object is destroyed");
	}

}
