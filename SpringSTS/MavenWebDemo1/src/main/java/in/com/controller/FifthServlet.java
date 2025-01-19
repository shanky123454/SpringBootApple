package in.com.controller;

import java.io.PrintWriter;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.com.App;

@WebServlet(urlPatterns="/test")
public class FifthServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest req , HttpServletResponse res)
{
    try {
		doprocess(req,res);
	} catch (Exception e) {
		e.printStackTrace();
	}
}   

public void doPost(HttpServletRequest req , HttpServletResponse res)
{
    try {
		doprocess(req,res);
	} catch (Exception e) {
		e.printStackTrace();
	}
}

public void doprocess(HttpServletRequest req, HttpServletResponse res) throws Exception
{
	PrintWriter out = res.getWriter();
App app = new App();

   System.out.println("Requested method is of type ::" + req.getMethod());
   
   String username = req.getParameter("username");
   out.println("username is:: " + username);
	int result=app.sum(3,5);
	out.println("result:" + result);
}
    
}