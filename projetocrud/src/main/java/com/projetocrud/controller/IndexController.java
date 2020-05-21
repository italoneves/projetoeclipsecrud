package com.projetocrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class IndexController {
	
	@RequestMapping("/teste")
	public String teste() {
		
		return "index";
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/login")
	public String login() {
		

		return "login";
		
	}

}
