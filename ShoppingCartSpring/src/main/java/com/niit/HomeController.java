package com.niit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.UserDAO;
//This class we have to convert into a controller(MVC)
//we have to simple annotion
@Controller
public class HomeController {

	//want to navigate to home page
	///http://localhost:8080/ShoppingCart/
	@RequestMapping ("/")
	public String homepage()
	{
		System.out.println("executing the main page");
		return "home";	
	}
		@RequestMapping("/login")
		public ModelAndView showLoginPage()
		{
			ModelAndView mv=new ModelAndView("home");
		 mv.addObject("msg","you clicked login link");
		 mv.addObject("showLoginPage","true" );
		 // in login page-${msg}
		 return mv;
		}
		
	@RequestMapping("/registration")
	public ModelAndView showRegistrationPage()
	{
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("msg","you clicked registration link");
		 mv.addObject("showRegistrationPage","true" );
		return mv;
	}
	
	@RequestMapping("/validate")
	public ModelAndView validate(@RequestParam("id")String id,@RequestParam("password") String pwd)
	{
	System.out.println("in validate method");
	System.out.println("id:" + id);
	System.out.println("pwd:" + pwd);
	ModelAndView mv=new ModelAndView("home");
	
	UserDAO userDAO=new UserDAO();
	if(userDAO.isValidCredentials(id,pwd)==true)
	{
		mv.addObject("successMsg","you logged in successfully");
	}
	else
	{
		mv.addObject("errorMsg","invalid credentials.please try again");
	}
	return mv;
	
}
}




		
	
	

