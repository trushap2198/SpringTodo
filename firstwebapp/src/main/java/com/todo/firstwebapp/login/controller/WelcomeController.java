package com.todo.firstwebapp.login.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goToWelcomePage(ModelMap model) {
		model.put("name", getLoggeruser());
		return "welcome"; //same as the jsp file name
	}
	
	private String getLoggeruser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
	//csrf disable
	//frames allow 
	//this both for h2
}