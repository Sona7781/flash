package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class LoginController {
	
	@Autowired
	LoginService service;
	
	@RequestMapping(value = "/login", method=RequestMethod.GET)	
	public String showMessage()
	{
		return "login";
	}

	@RequestMapping(value = "/login", method=RequestMethod.POST)	
	public String loginMessage(ModelMap model,@RequestParam String name,@RequestParam String password )
	{
		boolean check=service.validateUser(name, password);
		if(!check)
		{
			model.put("errormessage", "Invalid Credentials");
			return "login";
		}
		
		model.put("name",name);
		model.put("password", password);
		return "welcome";
	}
}
