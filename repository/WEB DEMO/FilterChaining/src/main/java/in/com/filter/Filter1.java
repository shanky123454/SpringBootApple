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
public class Filter1  implements Filter {
	
	static {
		System.out.println("Filter1 .class is loaded");
	}
    
    public Filter1() {
    	
      System.out.println("Filter1 class object is created");
    }

	public void destroy() {
		System.out.println("Filter1 class object is destroyed");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	      PrintWriter out = response.getWriter();
	      out.println("<h1 style='color:red;text-align:center;'> BEFORE CHAINING THE REQUEST IN FILTER1</h1>"); 
		   chain.doFilter(request, response);
		   out.println("<h1 style='color:red;text-align:center;'> AFTER CHAINING THE REQUEST IN FILTER1</h1>");
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Filter1 object is initiated");
	}

}
