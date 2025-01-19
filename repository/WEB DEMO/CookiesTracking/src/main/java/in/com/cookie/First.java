package in.com.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class First extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String ename= request.getParameter("ename");
		String eid = request.getParameter("eid");
		
		Cookie c1 = new Cookie("ename", ename);
		Cookie c2 = new Cookie("eid",eid);
		
		response.addCookie(c1);
		response.addCookie(c2);
		
		RequestDispatcher req = request.getRequestDispatcher("./second.html");
		
		req.forward(request, response);
	}

}
