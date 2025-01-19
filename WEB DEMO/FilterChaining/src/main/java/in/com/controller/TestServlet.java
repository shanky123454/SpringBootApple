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
		System.out.println("testservlet .class file is loaded");
	}
	
	public TestServlet()
	{
		System.out.println("testservlet class object is created");
	}
	
	public void init(ServletConfig config)
	{
		System.out.println("testservlet object is initiated");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<h2 style='color:red;text-align:center;'> This is first Chaining Filter program</h2>");
		System.out.println("inside testservlet servlet");
		
	}
	
	public void destroy()
	{
		System.out.println("testservlet object is destroyed");
	}

}
