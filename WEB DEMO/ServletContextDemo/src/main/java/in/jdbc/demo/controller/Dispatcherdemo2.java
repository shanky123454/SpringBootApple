package in.jdbc.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Dispatcherdemo2")
public class Dispatcherdemo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<h2> In dispatched servlet ");
		
		out.println("<body>");
		out.println("<center>");
		out.println("<h1 style='color:red; text-align:center;'>REQUEST HEADER INFORMATION...</h1>");
		out.println("<table border='1'>");
		out.println("<tr><th>Header Name</th><th>Header Value</th></tr>");
		Enumeration<String> headerNames = request.getAttributeNames();
		while (headerNames.hasMoreElements()) {
			out.println("<tr>");
		String headerName = (String) headerNames.nextElement();
		Object value = request.getAttribute(headerName);
			out.println("<td>" + headerName + "</td>");
			out.println("<td>" + value + "</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		//out.close();

	}

}
