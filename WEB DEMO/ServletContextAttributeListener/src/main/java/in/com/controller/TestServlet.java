package in.com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/test")
public class TestServlet extends HttpServlet {
	ServletConfig config;
	
	static {
		System.out.println("testservlet .class file is loaded");
	}
	private static final long serialVersionUID = 1L;
	
	public TestServlet()
	{
		System.out.println("testServlet class object is created");
	}
	
	public void init(ServletConfig config)
	{
		System.out.println("testservlet object is initiated");
		this.config=config;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	//ServletConfig config = getServletConfig();
		
	ServletContext context = config.getServletContext(); 
		
		context.setAttribute("hyder", "java");
		context.setAttribute("shashank", "spring-boot");
		context.removeAttribute("hyder");
		context.setAttribute("shashank", "microservices");
		out.println("<h2 style='color:green;text-align:center'>THIS IS INSIDE SERVLET</h2>");
		
	}
	public void destroy()
	{
		System.out.println("testservlet object is destroyed");
	}

}

