package in.com.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Demo3")
public class Demo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out =response.getWriter();
		response.setContentType("text");
		
		LocalDateTime d= LocalDateTime.now();
		          int hour = d.getHour();
		          
		          String msg="";
		          if(hour<12)
		          {
		        	 msg+="good morning";
		          }
		          else if(hour <18)
		          {
		        	  msg+="good evening";
		          }
		          else if(hour< 22)
		          {
		        	  msg+="good night";
		          }
		          else
		          {
		        	  msg+="not in zone";
		          }
		out.println("<h1 style='color:red; text-align: centre;'>"+ msg+"<h1/");
		out.println("<html><head><title> OUTPUT </title></head>");
		out.println("<h1 style= 'color:red; text-align:centre;'</h1>");
		out.println("<h1>MULTITHREADING DEMO</h1>");
		out.println("<body>");
		out.println("<centre>");
		out.println("<table border='1'>");
		out.println("<tr> <th>Servlet request object address:</th><td>"+ request.hashCode()+ "</td></tr> ");
		out.println("<tr> <th>Servlet response object address:</th> <td>"+ response.hashCode()+ "</td></tr> ");
		out.println("<tr> <th>Servlet object address:</th> <td>"+ this.hashCode()+ "</td></tr> ");
		out.println("<tr> <th>Servlet request thread address:</th> <td>"+ Thread.currentThread().hashCode()+ "</td></tr> ");
		out.println("</table></centre></body></html>");
		out.close();
	}	
	

}
