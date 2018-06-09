package com.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/*@Controller*/
public class MyController implements Controller {

	
	private String uname;
	private String pass;
	@RequestMapping(value="/log")
	public String m1(@RequestParam String uname, @RequestParam String pass, ModelMap m) {
		System.out.println(uname);
		System.out.println(pass);
		m.addAttribute("un", uname);
		m.addAttribute("ps", pass);
		
		return "display";
		
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Welcome main");
        return new ModelAndView("main");
	}
	
}
