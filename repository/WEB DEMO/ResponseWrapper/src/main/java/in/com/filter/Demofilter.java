package in.com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import in.com.custom.CustomResponse;


@WebFilter("/test")
public class Demofilter  implements Filter {
	
	   
    static {
    	System.out.println("flterdemo .class is loaded");
    }
 
    public Demofilter() {
    	System.out.println("filterdemo class object is created");
    }

	public void destroy() {
		System.out.println("filterdemo object is destroyed");

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletResponse httpresponse = (HttpServletResponse) response;
		CustomResponse cresponse = new CustomResponse(httpresponse);
		chain.doFilter(request, cresponse);
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("filterdemo object is initialized");

	}

}
