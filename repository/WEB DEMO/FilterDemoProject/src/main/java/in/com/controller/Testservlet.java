package in.com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Enumeration;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.com.Dao.IEmployee;
import in.com.Dao.IEmployeeImplClass;
import in.com.Dto.Employee;

@WebServlet("/test")
public class Testservlet extends HttpServlet {
	Connection con =null;
	PreparedStatement pstmt = null;
	int res = 0;

	private static final long serialVersionUID = 1L;
	
//	"com.mysql.cj.jdbc.Driver"
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   PrintWriter out= response.getWriter();
	       response.setContentType("text/html");
	       String eid = request.getParameter("eid");
	       String ename = request.getParameter("ename");
	       String eage= request.getParameter("eage");
	       String eemail = request.getParameter("eemail");
	       String emobile = request.getParameter("emobile");
	       
	       IEmployee emp = new IEmployeeImplClass();
	       Employee e = new Employee();
	       
	       e.setEid(eid);
	       e.setEname(ename);
	       e.setEage(Integer.parseInt(eage));
	       e.setEemail(eemail);
	       e.setEmobile(emobile);
	       
	      String wow = emp.add(e);
	      out.println("<h1 style='color:red;text-align:center'>Insertion "+wow+"</h1>");
				
	       
		  
		     out.println("<html><head><title>output</title></head>");
		     out.println("<body bgcolor='lightgreen'>");
		     out.println("<center>");
		     out.println("<h1 style='color:lightpink ;text-align:center'>EMPLOYEE INFORMATION</h1>");
		     out.println("<table border='1'>");
		     out.println("<tr><th>parameternames</th><th>parametervalues</th></tr>");
		     
		     Enumeration<String> parameternames=request.getParameterNames();
		     
		   while(parameternames.hasMoreElements())
		   {
			     String parametername=parameternames.nextElement();
			     Object value = request.getParameter(parametername);

			    
			     out.println("<tr><td>"+parametername+"</td><td>"+value+"</td></tr>");     
		   }
		   
		   out.println("</table>");
		   out.println("</center>");
		   out.println("</body>");
		   out.println("</html>");
	}

}
