package in.com.hidden;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/second")
public class Second extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out =response.getWriter();
		String sname = request.getParameter("sname");
		String sid = request.getParameter("sid");
		String saddr= request.getParameter("saddr");
		String sphone = request.getParameter("sphone");
	
		
		out.println("<html><head><title>output</title></head>");
		out.println("<body bgcolor='pink'>");
		out.println("<center>");
		out.println("<h1 style='color=red; text-align:center'> INFO ABOUT CRICKTER</h1>");
		out.println("<form method='post' action='./third'>");
		out.println("<input type='hidden' name='sname' value='"+ sname+"'/>");
		out.println("<input type='hidden' name='sid' value='"+ sid+"'/>");
		out.println("<input type='hidden' name='saddr' value='"+ saddr+"'/>");
		out.println("<input type='hidden' name='sphone' value='"+ sphone+"'/>");
		out.println("<table border='1'>");
		out.println("<tr><th>SGF</th>");
		out.println("<td><input type='text' name='sgf'/></td></tr>");
		out.println("<tr><th>SFNAME</th>");
		out.println("<td><input type='text' name='sfname'/></td></tr>");
		out.println("<tr><th></th>");
		out.println("<td><input type='submit' value='reg'/></td></tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</center>");
		out.println("</body");
		out.println("</html");

}
}
