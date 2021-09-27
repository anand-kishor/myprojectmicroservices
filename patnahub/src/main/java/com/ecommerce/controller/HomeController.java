package com.ecommerce.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	public static String uploadDirectory=System.getProperty("user.dir")+"/src/main/webapp/images";
	
	@GetMapping("/welcome")                     
    public String welcome() {
        return "welcome";           
    }
	
	@RequestMapping(value="/image",method=RequestMethod.GET)
    public String index(Map<String, Object> modal) {
       modal.put("message", "HowToDoInJava Reader !!");
        return "index";
    }
	@RequestMapping("/faishon-world")
    public String faishonWorld(Map<String, Object> model) {
        model.put("title","fashion world");
        return "faishon_world";
    }
	@RequestMapping("/home")
    public String home(Map<String, Object> model) {
        model.put("title","home");
        return "home";
    }
	@RequestMapping("/login")
    public String login(Map<String, Object> model) {
        model.put("title","login");
        return "login";
    }
	 @RequestMapping("/register")
	    public String register(Map<String, Object> model) {
	        model.put("title","register");
	        return "register";
	    }
	
	
	 @RequestMapping("/aboutus")
	    public String aboutUs(Map<String, Object> model) {
	        model.put("title","about us");
	        return "aboutus";
	    }
	 @RequestMapping("/contactus")
	    public String contactUs(Map<String, Object> model) {
	        model.put("title","catactus");
	        return "contactus";
	    }
	 @RequestMapping("/food")
	    public String food(Map<String, Object> model) {
	        model.put("title","food");
	        return "food";
	    }
	    @RequestMapping("/nonveg")
	    public String nonVeg(Map<String, Object> model) {
	        model.put("title","nonveg");
	        return "nonveg";
	    }
	    @RequestMapping("/header")
	    public String header(Map<String, Object> model) {
	        model.put("title","header");
	        return "header";
	    }
	
	
	 

}
