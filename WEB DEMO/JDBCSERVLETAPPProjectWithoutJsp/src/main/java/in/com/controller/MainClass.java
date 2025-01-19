package in.com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.com.Dto.Student;
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
			   
			   if(uri.endsWith("searchform"))
			   {
                 PrintWriter out = response.getWriter();
             	response.setContentType("text/html");
                String sid = request.getParameter("sid");
               out.println("<h2>"+ uri+"</h2>");
		          
		         IStudentService Iss = null;
		         Iss = StudentServiceFactoryClass.getService();
		         Student std = Iss.searchStudent(Integer.parseInt(sid));
		         
		         out.println("<h2 style='color:yellow;text-align:center;'>"+ std.getSid()+"</h2>");
		         out.println("<h2 style='color:yellow;text-align:center;'>"+ std.getSname()+"</h2>");
		         out.println("<h2 style='color:yellow;text-align:center;'>"+ std.getSage()+"</h2>");
			   }
	   
		   if(uri.endsWith("addform"))
		   {
		       PrintWriter out = response.getWriter();
            	response.setContentType("text/html");
               String sid = request.getParameter("sid");
               String sname = request.getParameter("sname");
               String sage = request.getParameter("sage");
               out.println("<h2>"+ uri+"</h2>");
               
		         IStudentService Iss = null;
		         Iss = StudentServiceFactoryClass.getService();
		         String str = Iss.addStudent(Integer.parseInt(sid),sname,Integer.parseInt(sage));
			   out.println("<h2 style='color:lightgreen;text-align:center;'>"+str+"</h2>");
			   
		   }
		   
		   if(uri.endsWith("deleteform"))
		   {
			    PrintWriter out = response.getWriter();
            	response.setContentType("text/html");
               String sid = request.getParameter("sid");
               out.println("<h2>"+ uri+"</h2>");

		         IStudentService Iss = null;
		         Iss = StudentServiceFactoryClass.getService();
		         String str = Iss.deleteStudent(Integer.parseInt(sid));
			   out.println("<h2 style='color:lightgreen;text-align:center;'>"+str+"</h2>");
			    
			   
		   }
		   
		   if(uri.endsWith("editform"))
		   {
			   String sid = request.getParameter("sid");

			   IStudentService Iss = null;
		         Iss = StudentServiceFactoryClass.getService();
		         Student student = Iss.searchStudent(Integer.parseInt(sid));
				PrintWriter out = response.getWriter();
				if (student != null) {
					// display student records as a form data so it is editable
					out.println("<body>");
					out.println("<center>");
					out.println("<form method='post' action='./controller/updateRecord'>");
					out.println("<table>");
					out.println("<tr><th>ID</th><td>"+student.getSid()+"</td></tr>");
					out.println("<input type='hidden' name='sid' value='" + student.getSid() + "'/>");
					out.println("<tr><th>NAME</th><td><input type='text' name='sname' value='" + student.getSname()
							+ "'/></td></tr>");
					out.println("<tr><th>AGE</th><td><input type='text' name='sage'  value='" + student.getSage()
							+ "'/></td></tr>");
					out.println("<tr><td></td><td><input type='submit'  value='update'/></td></tr>");
					out.println("</table>");
					out.println("</form>");
					out.println("</center>");
					out.println("</body>");
				} else {
					// display not found message
					out.println("<body>");
					out.println("<h1 style='color:red;text-align:center;'>Record not avaialable for the give id :: " + sid
							+ "</h1>");
					out.println("</body>");
				}
				out.close();
			}
		   
		   if(uri.endsWith("updateRecord"))
		   {
			   PrintWriter out = response.getWriter();
             	response.setContentType("text/html");
			   
			 String sid = request.getParameter("sid");
			 String sname = request.getParameter("sname");  
			 String sage = request.getParameter("sage");
			 
			 Student s = new Student();
			 s.setSage(Integer.parseInt(sage));
			 s.setSname(sname);
			  s.setSid(Integer.parseInt(sid));
			 
			   IStudentService Iss = null;
		         Iss = StudentServiceFactoryClass.getService();
		         String std = Iss.updateStudent(s);
			 
				out.println("<h2 style='color:red;text-align:center;'>"+std+"</h2>");
			 
			 
		   }
		
		
		}

}
