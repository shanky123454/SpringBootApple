package in.com.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DemoFilter implements Filter {
	static {
		System.out.println("filter .class is loaded");
	}
   
    public DemoFilter() {
       System.out.println("filter class object is created");
    }

  public void destroy() {
		System.out.println("filter object is destroyed");
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter out =response.getWriter();
		out.println("<h2 style='color:green;text-align:center'>THIS IS BEFORE SENDING REQUEST TO SERVLET</h2>");
		chain.doFilter(request, response);
		out.println("<h2 style='color:green;text-align:center'>THIS IS AFTER RECEIVING OUTPUT FROM SERVLET</h2>");
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("filter object got initiated");
	}

}
