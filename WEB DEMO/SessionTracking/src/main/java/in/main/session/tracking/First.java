
//  HTTPSESSION TRACKING CODE

package in.main.session.tracking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/first")
public class First extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		  response.setContentType("text/html");
		  PrintWriter out = response.getWriter();
		  
		  
		  String sname=request.getParameter("sname");
		  String sid = request.getParameter("sid");
		  
		  HttpSession session =request.getSession();
		  
		 PrintWriter writer = response.getWriter();
		 writer.println("<h1>"+session.getId()+"</h1>");
		 
		 System.out.println("********************");
		  System.out.println(session.getId());
		  
		  session.setAttribute("sname", sname);
		  session.setAttribute("sid", sid);
		  
		  RequestDispatcher dreq = request.getRequestDispatcher("./second.html");
		  dreq.forward(request, response);
	  
	}

}
