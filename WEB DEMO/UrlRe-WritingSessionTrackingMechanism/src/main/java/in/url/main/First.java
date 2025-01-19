package in.url.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/first")
public class First extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		PrintWriter out =response.getWriter();
		String sname= request.getParameter("sname");
		String sid = request.getParameter("sid");
		
		HttpSession session = request.getSession();
		
		session.setAttribute("sname", sname);
		session.setAttribute("sid", sid);
		
		out.println("<html><head><title>output</title></head>");
		out.println("<body color='pink'>");
		out.println("<center>");
		out.println("<h1 style='color=red; text-align:center'> INFO ABOUT CRICKTER</h1>");
		out.println("<form method='post' action='"+ response.encodeURL("./second")+"'>");
		out.println("<table border='1'>");
		out.println("<tr><th>SADDR</th>");
		out.println("<td><input type='text' name='saddr'/></td></tr>");
		out.println("<tr><th>SPHONE</th>");
		out.println("<td><input type='text' name='sphone'/></td></tr>");
		out.println("<tr><th></th>");
		out.println("<td><input type='submit' value='reg'/></td></tr>");
		
		out.println("</table>");
		out.println("</form>");
		out.println("</center>");
		out.println("</body");
		out.println("</html");
	}

}
