package in.com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class controller {
	
	String name = "SHASHANK RAJ IS GOOD IN JAVA & JEE";
	
	@RequestMapping(path = "/",method = RequestMethod.GET)
	public String getMapping1() {
		return "dekho";
	}
	
	@RequestMapping(path = "/home",method = RequestMethod.GET)
	public String getMapping(Model model) {
		model.addAttribute("msg", name);
		return "display";
	}
//	
//	@RequestMapping(path = "/result", method =RequestMethod.GET)
//	public String getResult()
//	{
//		return "display2";
//	}
//	
//	@RequestMapping(path = "/result1", method =RequestMethod.GET)
//	public String getResult1()
//	{
//		return "display2";
//	}
//	
	/*
	 * @RequestMapping(path = "/", method =RequestMethod.GET) public ModelAndView
	 * getResult2(ModelAndView modelAndView) { ModelAndView modelAndView = new
	 * ModelAndView(); System.out.println(modelAndView.getClass().getName());
	 * modelAndView.addObject("msg", name); modelAndView.setViewName("display");
	 * return modelAndView; }
	 */
	
//	@RequestMapping(path = "/result", method =RequestMethod.GET)
//	public String getResult3( Model model)
//	{
//		System.out.println("SharedMemory object class name is :: " + 
//				model.getClass().getName());
//		model.addAttribute("msg", name);
//		return "display";
//	}
//	
//	@RequestMapping(path = "/result", method =RequestMethod.GET)
//	public String getResult4( Map<String,Object> model)
//	{
//		System.out.println("SharedMemory object class name is :: " + 
//				model.getClass().getName());
//		model.put("msg", name);
//		return "display";
//	}
	
	// Sending the response directly to the browser without using DispatcherServlet
	
//	@RequestMapping(value = "/result",method = RequestMethod.GET)
//	public void generateMessage(HttpServletResponse httpServletResponse) throws IOException
//	{
//		System.out.println(" object class name is :: " + 
//				httpServletResponse.getClass().getName());
//		PrintWriter printWriter = httpServletResponse.getWriter();
//		httpServletResponse.setContentType("text/html");
//		printWriter.println("<h1> Message is :: "+name+" </h1>");
//	}

	/*
	 * @RequestMapping(value="/result", method = RequestMethod.GET) public Model
	 * generateWishMessage(){ Model model = new ExtendedModelMap();
	 * model.addAttribute("msg",name); return model; }
	 */
	
	
	
//	@GetMapping(value={"/result"})
//	public String showReport(Map<String,Object> map, HttpServletResponse response, HttpServletRequest request, HttpSession session) {
//	System.out.println("TestController.showReport");
//	System.out.println(response.getClass().getName());
//	System.out.println(request.getClass().getName());
//	System.out.println("Session id is:" + session.getId());
//	return "display";
//	}
//	
//	@PostMapping(value="/result")
//	public String showReport1(Map<String,Object> map, HttpSession session) {
//	System.out.println("TestController.showReport1");
//	System.out.println("Session id is:" + session.getId());
//	return "display";
//	}


}
