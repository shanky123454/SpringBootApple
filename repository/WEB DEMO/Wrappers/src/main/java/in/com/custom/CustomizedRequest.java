package in.com.custom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class CustomizedRequest extends HttpServletRequestWrapper {
	     HttpServletRequest request;
	    public CustomizedRequest(HttpServletRequest request) {
		super(request);
		this.request=request;
	}

	@Override
	 public String getParameter(String name) {
	
		String value1 = super.getParameter(name);
		 String value = request.getParameter(name);
		 if(value.equalsIgnoreCase("java")|| value.equalsIgnoreCase("spring"))
		 {
			 return "JOSH IS HIGH";
		 }
		 
		return value;
	}

}
