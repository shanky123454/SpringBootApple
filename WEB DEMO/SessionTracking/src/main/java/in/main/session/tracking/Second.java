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

@WebServlet("/second")
public class Second extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  PrintWriter out =response.getWriter();
		  String sage =request.getParameter("sage");
		  String saddr =request.getParameter("saddr");
		  
		  HttpSession session = request.getSession();
		  out.println("<h1>"+session.getId()+"</h1>");
		  
			 System.out.println("********************");
			  System.out.println(session.getId());
			  
			  
		  session.setAttribute("sage", sage);
		  session.setAttribute("saddr", saddr);
		  
		  RequestDispatcher reqd= request.getRequestDispatcher("./third");
		  reqd.forward(request, response);
	}

}
