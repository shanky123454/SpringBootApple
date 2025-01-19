package in.jdbc.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		
		ServletConfig congif = getServletConfig();
		ServletContext context = getServletContext();
		
		out.println("<h2>config implementation class is::"+ congif.getClass().getName()+"</h2>" );
		out.println("<h2>context implementation class is::"+ context.getClass().getName()+"</h2>" );
		out.println("<h2>request implementation class is::"+ request.getClass().getName()+"</h2>" );
		out.println("<h2>response implementation class is::"+ response.getClass().getName()+"</h2>" );

		
	}

}
