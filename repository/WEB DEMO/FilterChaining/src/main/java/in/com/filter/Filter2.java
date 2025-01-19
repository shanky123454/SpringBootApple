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
import javax.servlet.http.HttpFilter;

@WebFilter("/test")
public class Filter2  implements Filter {
	
	static {
		System.out.println("Filter2 .class is loaded");
	}
    
    public Filter2() {
    	
      System.out.println("Filter2 class object is created");
    }

	public void destroy() {
		System.out.println("Filter2 class object is destroyed");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	      PrintWriter out = response.getWriter();
	      out.println("<h1 style='color:red;text-align:center;'>BEFORE FORWADING THE REQUEST TO SERVLET</h1>"); 
		   chain.doFilter(request, response);
		   out.println("<h1 style='color:red;text-align:center;'> AFTER FORWADING THE REQUEST TO SERVLET</h1>");
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Filter2 object is initiated");
	}

}