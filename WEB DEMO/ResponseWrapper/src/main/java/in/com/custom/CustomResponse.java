package in.com.custom;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import in.com.CustomWriter.Mywriter;

public class CustomResponse extends HttpServletResponseWrapper {

	HttpServletResponse response;
	public CustomResponse(HttpServletResponse httpresponse) {
		super(httpresponse);
		this.response=httpresponse;
	
	}
	@Override
	public PrintWriter getWriter() throws IOException {
	
		PrintWriter out = response.getWriter();
		     
		     Mywriter mywriter = new Mywriter(out);
		return mywriter;
	}
	
	

}
