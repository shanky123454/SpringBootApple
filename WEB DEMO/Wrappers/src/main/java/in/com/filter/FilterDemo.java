package in.com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import in.com.custom.CustomizedRequest;

@WebFilter("/test")
public class FilterDemo  implements Filter {
       
    static {
    	System.out.println("flterdemo .class is loaded");
    }
    public FilterDemo() {
    	System.out.println("filterdemo class object is created");
    
    }

	public void destroy() {
		System.out.println("filterdemo object is destroyed");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		HttpServletRequest httprequest = (HttpServletRequest) request;
		CustomizedRequest creq = new CustomizedRequest(httprequest);
		chain.doFilter(creq, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("filterdemo object is initialized");
	}

}
