package com.projetocrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projetocrud.model.Cliente;
import com.projetocrud.repository.ClientesRepository;
import com.projetocrud.repository.UsuarioRepository;


@Controller
public class IndexController {
	
	@Autowired
	ClientesRepository cl;

	@RequestMapping(method = RequestMethod.GET, path = "/login")
	public String login() {
		

		return "login";
		
	}
	
	@RequestMapping("/index")
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
	
	@RequestMapping(method = RequestMethod.GET, path = "/novocadastro")
	public String cadastro() {
		
		return "novocadastro";
	}
	
	@RequestMapping(method =RequestMethod.POST, path = "/novocadastro")
	public String cadastrar(Cliente c) {
		
		cl.save(c);
		
		return "redirect:/novocadastro";
	}





}