package com.spring.boot.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.bind.annotation.RequestParam;
@Controller
@SessionAttributes("name")
public class WelcomeController1 {
	
/*	private AuthenticationService1 authentiate;
	
	public LoginController1(AuthenticationService1 authentiate) {
		super();
		this.authentiate = authentiate;
	}*/
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String goTOWelcome(ModelMap model) {
		model.put("name",getLoggedIn());
		return "welcome1";
	}
	
	private String getLoggedIn() {
	Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
	return authentication.getName();
	}
	
/*	@RequestMapping(value="login", method=RequestMethod.POST)
	public String goToWelcome(@RequestParam String name,@RequestParam String password,ModelMap model) {
		if(authentiate.validation(name, password)) {
			model.put("name", name);
			model.put("password", password);
			return "welcome1";
		}
		model.put("error", "invalid name or password");
		return "login1";
	}*/

}
