package com.projetocrud.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.projetocrud.model.Cliente;
import com.projetocrud.repository.ClientesRepository;


@Controller
public class IndexController {
	
	@Autowired
	ClientesRepository cr;

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
	
	
	
	
	@RequestMapping(method = RequestMethod.POST, path = "/clientes")
	public ModelAndView cliente(String nome) {
		
	
		ModelAndView mv = new ModelAndView("clientes");
		
		if(nome!=null && !nome.isBlank()) {
		
//			 Cliente cliente = cr.findByNome(nome);
			
			 List<Cliente> l =  cr.findByNomeContaining(nome); // LEMBRA DO NOME NO JPAHIBERNATE
			 mv.addObject("listacliente", l);
			 return mv;
		}
		
		return clienteg();
	}
	@RequestMapping(method = RequestMethod.GET, path = "/clientes")
	public ModelAndView clienteg() {
		
		ModelAndView mv = new ModelAndView("clientes");
		
		List<Cliente> lista = cr.findAll();	
		mv.addObject("listacliente", lista);
		
		return mv;
	}
	

	
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/novocadastro")
	public ModelAndView cadastro(Cliente c) { 
	
		ModelAndView mv = new ModelAndView("novocadastro");
		return mv; // retorno a tela com o cliente c que possuir ou em branco se não tiver
	}
	
	
	
	@RequestMapping(method =RequestMethod.POST, path = "/novocadastro")
	public ModelAndView cadastrar(@Valid  Cliente c, BindingResult resultado) {
	//recebo os valores que devem ser cadastrados
	//caso tenha algo invalido entro no if
	  if (resultado.hasErrors()) {
		  
		  return cadastro(c); // retorno os dados cadastrados no objeto c 
		
	  }
	  
	    cr.save(c);   // caso nao tenha erro é salvo
	    
	    ModelAndView mv = new ModelAndView("redirect:/novocadastro"); // retorno uma tela em branco para novo cadastro
		return mv;
	}



	
		 
}
	
