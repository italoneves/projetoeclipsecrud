package com.projetocrud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.projetocrud.security.ImplementsUserDetails;

@Configuration
@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	ImplementsUserDetails userDetailsService;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.authorizeRequests().antMatchers("/css/**","/js/**").permitAll()
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/login").permitAll().and().rememberMe();	
		
		//Vai ser necessário autenticar para ter acesso
		//pasta que pode ser acessada
		//qualquer requisação tem que autenticar antes
		//autenticaçao
		//tenho uma propria pagina de login e especifico a mesma
		//relembrar login
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

	
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder()); 
		//PEGAR USUARIO E AUTENTICAR GERANDO HASH DA SENHA PARA PODER COMPARAR COM O BD 
	}
	
//	 @Override
//	   public void configure(WebSecurity web) throws Exception {
//	        web.ignoring().antMatchers("/resources/**");
//	    }
	


}
