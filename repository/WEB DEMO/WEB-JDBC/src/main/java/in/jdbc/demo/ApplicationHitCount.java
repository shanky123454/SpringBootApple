package in.jdbc.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ApplicationHitCount")
public class ApplicationHitCount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		ServletContext context = getServletContext();
		Integer count = (Integer)context.getAttribute("hit count");
		
		if(count==null)
		{
			count=1;
		}
		else {
			count++;
		}
		context.setAttribute("hit count", count);
		
		out.println("<h2> Total hit count is ::"+ count+"</h2>");
		
		
	}

}
