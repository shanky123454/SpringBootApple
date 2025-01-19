package in.com.urlpattern;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test/test/*")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<h2 style='color:red;text-align:center;'> This is second servlet</h2>");
		out.close();
	}

}
