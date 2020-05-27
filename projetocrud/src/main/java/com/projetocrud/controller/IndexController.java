package com.projetocrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projetocrud.repository.UsuarioRepository;


@Controller
public class IndexController {

	@RequestMapping(method = RequestMethod.GET, path = "/login")
	public String login() {
		

		return "login";
		
	}
	
	@RequestMapping("/home")
	public String home() {
		
		return "index";
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/agenda")
	public String agenda() {
		
		return "agenda";
	}
	
	@RequestMapping("/clientes")
	public String clientes() {
		
		return "clientes";
	}


}