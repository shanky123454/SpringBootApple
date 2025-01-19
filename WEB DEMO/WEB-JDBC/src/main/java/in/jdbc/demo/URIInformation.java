package in.jdbc.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/URIInformation/test/ineuron/*")
public class URIInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       
		response.setContentType("text");
		PrintWriter out = response.getWriter();
		
		out.println("<h1> REQUEST URI IS::"+ request.getRequestURI()+"</h1>");
		out.println("<h2> Request ContextPath is::"+ request.getContextPath()+"</h2>");
		out.println("<h2> Request PathInfo::"+ request.getPathInfo()+"</h2>");
		out.println("<h2> QueryString path is::"+ request.getQueryString()+"</h2>");
		out.println("<h2> Servlet path is::"+ request.getServletPath()+"</h2>");
	}
	

}
// output is in photos for reference