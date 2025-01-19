package in.com.filter;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/test")
public class Demofilter  implements Filter {
    

   
    public Demofilter() {
     System.out.println("filter class object is created");
    }

	public void destroy() {
	     System.out.println("filter class object is destroyed");

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	       PrintWriter out = response.getWriter();
	       response.setContentType("text/html");
	       

	    String error_eid="";
	   	String error_ename="";
	   	String error_eage="";
	   	String error_eemail="";
	   	String error_emobile="";
	   	boolean flag =false;
	  
	       
	       String eid = request.getParameter("eid");
	       String ename = request.getParameter("ename");
	       String eage= request.getParameter("eage");
	       String eemail = request.getParameter("eemail");
	       String emobile = request.getParameter("emobile");
	       
	       if(eid==null || eid.equals(""))
	       {
	    	   error_eid = "employee id is required";
	    	   flag=true;
	       }
	       if(ename==null || ename.equals(""))
	       {
	    	   error_ename = "employee name is required";
	    	   flag=true;
	       }
	       if(eage==null || eage.equals(""))
	       {
	    	   error_eage = "employee age is required";
	    	   flag=true;
	       }
	       if(eemail==null || eemail.equals(""))
	       {
	    	   error_eemail = "employee email is required";
	    	   flag=true;
	       }
	       if(emobile==null || emobile.equals(""))
	       {
	    	   error_emobile = "employee mobile is required";
	    	   flag=true;
	       }
	       
	       if(flag==true)
	       {
	    	   out.println("<html><head><title>output</title></head>");
	    	   out.println("<body bgcolor='lightgreen'>");
	    	   out.println("<center>");
	    	   out.println("<h1 style='color:red;text-align:centre;'>Employee registration details</h1>");
	    	   out.println("<form method='get' action='./test'>");
	    	   out.println("<table border='1'>");
	    	   out.println("<tr><th>EID</th>");
	    	   out.println("<td><input type='text' name='eid' value='"+eid+"'/></td><td>"+ error_eid+"</td></tr>");
	    	   out.println("<tr><th>ENAME</th>");
	    	   out.println("<td><input type='text' name='ename' value='"+ename+"'/></td><td>"+ error_ename+"</td></tr>");
	    	   out.println("<tr><th>EAGE</th>");
	    	   out.println("<td><input type='text' name='eage' value='"+eage+"'/></td><td>"+ error_eage+"</td></tr>");
	    	   out.println("<tr><th>EEMAIL</th>");
	    	   out.println("<td><input type='text' name='eemail' value='"+eemail+"'/></td><td>"+ error_eemail+"</td></tr>");
	    	   out.println("<tr><th>EMOBILE</th>");
	    	   out.println("<td><input type='text' name='emobile' value='"+ emobile+"'/></td><td>"+ error_emobile+"</td></tr>");
	    	   out.println("<tr><th></th>");
	    	   out.println("<td><input type='submit' value='reg'/></td></tr>");
	    	   out.println("</table>");
	    	   out.println("</form>");
	    	   out.println("</center>");
	    	   out.println("</body>");
	    	   out.println("</html>");
	       }
	       
	       else {
	    	     
		       chain.doFilter(request, response);
	       }
	  
	}

	public void init(FilterConfig Config) throws ServletException {
	    System.out.println("filter object is initiated");
	}

}
