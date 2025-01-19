package in.com.hidden;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/third")
public class Third extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		
		String sname =request.getParameter("sname");
		String sid =request.getParameter("sid");
		String saddr =request.getParameter("saddr");
		String sphone=request.getParameter("sphone");
		String sgf=request.getParameter("sgf");
		String sfname=request.getParameter("sfname");
		
		
		out.println("<html><head><title>output</title></head>");
		out.println("<body color='pink'>");
		out.println("<center>");
		out.println("<h1 style='color=red; text-align:center'> INFO ABOUT ACTOR</h1>");
		out.println("<table border='1'>");
	    out.println("<tr><th>sname</th><td>"+ sname+"</td></tr>");
	    out.println("<tr><th>sid</th><td>"+ sid+"</td></tr>");
	    out.println("<tr><th>saddr</th><td>"+ saddr+"</td></tr>");
	    out.println("<tr><th>sphone</th><td>"+ sphone+"</td></tr>");
	    out.println("<tr><th>sgf</th><td>"+sgf+"</td></tr>");
	    out.println("<tr><th>sfname</th><td>"+sfname+"</td></tr>");
	    
		out.println("</table>");
		out.println("</center>");
		out.println("</body");
		out.println("</html");
	}

}
