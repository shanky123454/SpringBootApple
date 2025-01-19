package in.main.session.tracking;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/third")
public class Third extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	         
		
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		out.println("<html><head><title>OUTPUT</title></head>");
		out.println("<body bgcolor='red'>");
		out.println("<h1 style='color:red;text-align:centre;'> STUDENT INFORMATION</h1>");
		out.println("<center>");
		out.println("<table border='1'>");
		out.println("<tr><th> STUDENT ATTRIBUTES</th> <th>STUDENT ATTRIBUTES VALUE</th></tr>");
		Enumeration<String> attributenames=session.getAttributeNames();
		while(attributenames.hasMoreElements())
		{ 
		 String attributename=(String)  attributenames.nextElement();
			String name =(String)session.getAttribute(attributename);
			 
			out.println("<tr><td>"+attributename+"</td><td>"+ name+"</td></tr>");
		}
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
	}

	

}
