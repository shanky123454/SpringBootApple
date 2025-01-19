package in.com.Handler;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class TagHandlerClass implements Tag {
	PageContext pageContext = null;
	public String names;
	

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	static {
		System.out.println("TagHandlerClass .class file is loaded");
	}
	
	public TagHandlerClass()
	{
		System.out.println("TagHandlerClass.TagHandlerClass()");
	}

	@Override
	public int doEndTag() throws JspException {
		System.out.println("TagHandlerClass.doEndTag()");
		return EVAL_PAGE;
		
	}

	@Override
	public int doStartTag() throws JspException {
		System.out.println("TagHandlerClass.doStartTag()");
		JspWriter out =pageContext.getOut();
		if(names==null)
		{
			try {
				out.println("<h1> GOOD MORNING" +names+"</h1>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				out.println("<h1> GOOD MORNING " +names+"</h1>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			out.println("<h1>this is inside the doStartTag</h1>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_BODY_INCLUDE;
	}

	@Override
	public Tag getParent() {
		System.out.println("TagHandlerClass.getParent()");
		return null;
	}

	@Override
	public void release() {
		System.out.println("TagHandlerClass.release()");
		

	}

	@Override
	public void setPageContext(PageContext pageContext) {
		System.out.println("TagHandlerClass.setPageContext()");
		this.pageContext=pageContext;

	}

	@Override
	public void setParent(Tag arg0) {
		System.out.println("TagHandlerClass.setParent()");

	}

}
