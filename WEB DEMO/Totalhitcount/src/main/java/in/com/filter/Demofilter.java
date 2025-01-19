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
	
	static {
		System.out.println("filter .class is loaded");
	}
 
    public Demofilter() {
     System.out.println("filter class object is created");
    }

	public void destroy() {
		System.out.println("filter object is destroyed");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		PrintWriter out =response.getWriter();
		out.println("<h2 style='color:green;text-align:centre;'>BEFORE FORWADING THE REQUEST TO FILTER</h2>");
		chain.doFilter(request, response);
		out.println("<h2 style='color:green;text-align:centre;'>AFTER RECEIVING THE REQUEST TO FILTER</h2>");
        
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("filter object got initialized");
	}

}
