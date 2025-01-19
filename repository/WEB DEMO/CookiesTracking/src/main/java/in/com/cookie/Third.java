package in.com.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/third")
public class Third extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();

		Cookie[] session=request.getCookies();
		
	       String ename = session[0].getValue();
	       String eid = session[1].getValue();
	       String eaddr = session[2].getValue();
	       String esal= session[3].getValue();
		out.println("<html><head><title>output</title></head");
		out.println("<body bgcolor='red'>");
		out.println("<h1 style='color:red;text-align:center;'> Employee Information</h1>");
		out.println("<center>");
		out.println("<table border='1'>");

		out.println("<tr><th>ENAME</th><td>"+ ename+"</td></tr>");
		out.println("<tr><th>EID</th><td>"+ eid+"</td></tr>");
		out.println("<tr><th>EADDR</th><td>"+ eaddr+"</td></tr>");
		out.println("<tr><th>ESAL</th><td>"+ esal+"</td></tr>");
		
	  out.println("</table");
	  out.println("</center>");
	  out.println("</body>");
	  out.println("</html>");
	}

}
