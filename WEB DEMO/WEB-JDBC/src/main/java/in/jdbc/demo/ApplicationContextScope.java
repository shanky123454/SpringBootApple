package in.jdbc.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ApplicationContextScope")
public class ApplicationContextScope extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		ServletContext context = getServletContext();
		String name1 = (String) context.getAttribute("name");
		System.out.println(name1);
		Integer age1 = (Integer) context.getAttribute("age");
		System.out.println(age1);
		context.setAttribute("name","shanky");
		context.setAttribute("age", 25);
		out.println("<html><head><title> output</title></head>");
		out.println("<h1 style='color:red; text-align:centre'>ServletContext Information</h1>");
		out.println("<body>");
		out.println("<centre>");
		out.println("<table border='1'>");
		out.println("<tr><th> attributes name</th> <th> attribute values</th></tr>");
	
		
		     Enumeration<String> parameternames = context.getAttributeNames();
		     while(parameternames.hasMoreElements())
		     {
		    	                String parametername = (String)parameternames.nextElement();
		    	                Object value =  context.getAttribute(parametername);
		    	                out.println("<tr><td>"+ parametername+"</td> <td> "+ value+ " </td>");
		    	                out.println("</tr>");
		     }
		     out.println("</table>");
		     out.println("</centre>");
		     out.println("</body>");
		     out.println("</html>");
		
	}

}
