package in.url.main;

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
		
		PrintWriter out =response.getWriter();
		String ssub= request.getParameter("ssub");
		String sclass = request.getParameter("sclass");
		
		HttpSession session = request.getSession();
		
		session.setAttribute("ssub", ssub);
		session.setAttribute("sclass", sclass);
		
		out.println("<html><head><title>output</title></head>");
		out.println("<body color='pink'>");
		out.println("<center>");
		out.println("<h1 style='color=red; text-align:center'> INFO ABOUT CRICKTER</h1>");
		out.println("<table border='1'>");
	    out.println("<tr><th>STUDENT INFO</th> <th>STUDENT VALUES</th></tr>");
         Enumeration<String> attributenames = session.getAttributeNames();
         while(attributenames.hasMoreElements())
         {
        	     String parametername= attributenames.nextElement();
        	     String value =(String)session.getAttribute(parametername);
        	 
        	     out.println("<tr><td>"+ parametername+"</td><td>"+ value+"</td></tr>");
         }
	
		out.println("</table>");
		out.println("</center>");
		out.println("</body");
		out.println("</html");
	}

}
