package in.url.main;

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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out =response.getWriter();
		String saddr= request.getParameter("saddr");
		String sphone = request.getParameter("sphone");
		
		HttpSession session = request.getSession();
		
		session.setAttribute("saddr", saddr);
		session.setAttribute("sphone", sphone);
		
		out.println("<html><head><title>output</title></head>");
		out.println("<body color='pink'>");
		out.println("<center>");
		out.println("<h1 style='color=red; text-align:center'> INFO ABOUT CRICKTER</h1>");
		out.println("<form method='get' action='"+ response.encodeURL("./third")+"'>");
		out.println("<table border='1'>");
		out.println("<tr><th>SSUBJECT</th>");
		out.println("<td><input type='text' name='ssub'/></td></tr>");
		out.println("<tr><th>SCLASS</th>");
		out.println("<td><input type='text' name='sclass'/></td></tr>");
		out.println("<tr><th></th>");
		out.println("<td><input type='submit' value='reg'/></td></tr>");
		
		out.println("</table>");
		out.println("</form>");
		out.println("</center>");
		out.println("</body");
		out.println("</html");
	}

}
