package in.com.Handler;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.IterationTag;
import javax.servlet.jsp.tagext.Tag;

public class TagHandlerClass implements IterationTag {
	PageContext pageContext = null;
	public int count;
	


	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		System.out.println("TagHandlerClass.setCount()");
		this.count = count;
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
		try {
			out.println("<h1>this is inside the doStartTag</h1>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(count>0)
		return EVAL_BODY_INCLUDE;
		else
		return SKIP_BODY;
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

	@Override
	public int doAfterBody() throws JspException {
		System.out.println("TagHandlerClass.doAfterBody()");
		count--;
		if(count>0)
		return EVAL_BODY_AGAIN;
		else
		return SKIP_BODY;
	}

}
