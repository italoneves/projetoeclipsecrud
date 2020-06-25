package com.projetocrud.controller;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.projetocrud.model.Cliente;
import com.projetocrud.model.Sexo;
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
	public ModelAndView buscarClientes(String nome) {
		
	
		ModelAndView mv = new ModelAndView("clientes");
		
		if(!nome.isBlank()) { //Se a string passada nao for nula, vazia ou não tiver apenas espaço 
		
//			 Cliente cliente = cr.findByNome(nome);//Buscar por nome igual
			
			 List<Cliente> l =  cr.findByNomeContaining(nome); // LEMBRA DO NOME NO JPAHIBERNATE //buscar por like % %
			 mv.addObject("listacliente", l);
			 return mv;
		}
		
		return todosClientes(); // Caso nao seja passado um nome válido retorna a página com todos
	}
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/clientes")
	public ModelAndView todosClientes() {
		
		ModelAndView mv = new ModelAndView("clientes");
		
		List <Cliente> lista = cr.findAll();	 //Busca todos os clientes no banco
		System.out.println("teste");
		mv.addObject("listacliente", lista); // Adiciona lista com os clientes
		
		return mv;  //Retornar model and view com a lista
	}
	

	
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/novocadastro")
	public ModelAndView cadastro(Cliente c) { 
	
		List<Sexo> l_sexo = Arrays.asList(Sexo.values());
		
		ModelAndView mv = new ModelAndView("novocadastro");
		mv.addObject("en_sexo", l_sexo);
		
		return mv; // retorno a tela com o cliente c que possuir ou em branco se não tiver
	}
	
	
	
	@RequestMapping(method =RequestMethod.POST, path = "/novocadastro")
	public ModelAndView cadastrar(@Valid  Cliente c, BindingResult resultado) {
		
    //@Valid para dizer que é preciso validar // bindingresult mensagem de erro 
	//recebo os valores que devem ser cadastrados
	//caso tenha algo invalido entro no if
		
	  if (resultado.hasErrors()) {
		 
		  return cadastro(c); // retorno os dados cadastrados no objeto c para o usuário corrigir
		
	  }
	  
	    cr.save(c);   // caso nao tenha erro é salvo
	    
	    ModelAndView mv = new ModelAndView("redirect:/novocadastro"); // retorno uma tela em branco para novo cadastro
		return mv;
	}
	
	@RequestMapping(path = "/{codigo}" )
	public ModelAndView detalhesClientes(@PathVariable ("codigo") Long codigo) {
		
//		Scanner sc = new Scanner(System.in);
//		
//		String teste = sc.nextLine();
//	
//	  System.out.println("Digite uma entrada:");
	  
	  Cliente c = cr.findByCodigo(codigo);

	
	  
	  ModelAndView mv = new ModelAndView("clientedetalhado");
	  
	  mv.addObject(c);
	  
	  
	  return mv;
		
		
		
	}



	
		 
}
	
