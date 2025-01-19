package in.com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/qwerty")
public class Demo4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		response.setContentType("text/html");
		
		out.println("<html><head><title> output</title></head>");
		out.println("<h1 style='color:red; text-align:centre'>READING THE VALUES FROM THE WEB.XML FILE</h1>");
		out.println("<body>");
		out.println("<centre>");
		out.println("<table border='1'>");
		out.println("<tr><th> parameters name</th> <th> parameters value</th></tr>");
		ServletConfig  config = getServletConfig();
		     Enumeration<String> parameternames =  config.getInitParameterNames();
		     while(parameternames.hasMoreElements())
		     {
		    	                String parametername = parameternames.nextElement();
		    	                String value = config.getInitParameter(parametername);
		    	                out.println("<tr><td>"+ parametername+"</td> <td> "+ value+ " </td>");
		    	                out.println("</tr>");
		     }
		     out.println("</table>");
		     out.println("</centre>");
		     out.println("</body>");
		     out.println("</html>");
		     out.close();
	}
	
}
