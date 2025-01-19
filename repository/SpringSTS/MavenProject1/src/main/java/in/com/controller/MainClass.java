package in.com.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.com.dto.Student;
import in.com.StudentServiceFactory.StudentServiceFactoryClass;
import in.com.service.IStudentService;

@WebServlet("/controller/*")
public class MainClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
		public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doProcess(request, response);
		}

		public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doProcess(request, response);
		}
		
		public  void doProcess(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			   String uri = request.getRequestURI();
			   System.out.println(uri);
			   if(uri.endsWith("searchform"))
			   {
				   String path = request.getPathInfo();
				   System.out.println(path);
				   String path1 = request.getRequestURI();
				   System.out.println(path1);
                // PrintWriter out = response.getWriter();
             	//response.setContentType("text/html");
                String sid = request.getParameter("sid");
               //out.println("<h2>"+ uri+"</h2>");
		          
		         IStudentService Iss = null;
		         Iss = StudentServiceFactoryClass.getService();
		         List<Student> student = Iss.searchStudent();
		         System.out.println(student);
		         request.setAttribute("student",student);
		         RequestDispatcher rd= request.getRequestDispatcher("../display.jsp");
		         rd.forward(request,response);
		       
		         
			   }
		}
}