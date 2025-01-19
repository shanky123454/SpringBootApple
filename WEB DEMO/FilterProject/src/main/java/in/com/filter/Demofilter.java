package in.com.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Demofilter implements Filter {
	
	
	static {
		System.out.println("Demofilter.class is loaded");
	}

    public Demofilter() {	
    	
    	System.out.println("Demofilter class object is initited");
       
    }

	public void destroy() {
		System.out.println("object got destroyed");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		
	PrintWriter out = response.getWriter();
	
	out.println("<h1 style='color:yellow;text-align:center;'> IN FILTER BEFORE PROCESSING THE  SERVLET REQUEST");
		chain.doFilter(request, response);
		
		out.println("<h1 style='color:yellow;text-align:center;'> IN FILTER AFTER PROCESSING THE SERVLET REQUEST");
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
		System.out.println("Demofilter object is initialized");
	}

}
