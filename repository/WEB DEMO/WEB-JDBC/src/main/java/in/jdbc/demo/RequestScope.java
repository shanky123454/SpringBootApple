package in.jdbc.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RequestScope")
public class RequestScope extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		
		request.setAttribute("name","shanky");
		request.setAttribute("age", "25");
		out.println("<html><head><title> output</title></head>");
		out.println("<h1 style='color:red; text-align:centre'>Request object Information</h1>");
		out.println("<body>");
		out.println("<centre>");
		out.println("<table border='1'>");
		out.println("<tr><th> request name</th> <th> request values</th></tr>");
	
		
		     Enumeration<String> parameternames = request.getAttributeNames();
		     while(parameternames.hasMoreElements())
		     {
		    	                String parametername = (String)parameternames.nextElement();
		    	                Object value =  request.getAttribute(parametername);
		    	                out.println("<tr><td>"+ parametername+"</td> <td> "+ value+ " </td>");
		    	                out.println("</tr>");
		     }
		     out.println("</table>");
		     out.println("</centre>");
		     out.println("</body>");
		     out.println("</html>");
	}

}
