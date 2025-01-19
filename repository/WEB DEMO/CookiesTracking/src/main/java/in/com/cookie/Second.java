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

@WebServlet("/second")
public class Second extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet
	(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String eaddr= request.getParameter("eaddr");
		String esal = request.getParameter("esal");
		
		Cookie c1 = new Cookie("eaddr", eaddr);
		Cookie c2 = new Cookie("esal",esal);
		
		response.addCookie(c1);
		response.addCookie(c2);
		
		RequestDispatcher req = request.getRequestDispatcher("./third");
		
		req.forward(request, response);
	}

}
