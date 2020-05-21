package com.projetocrud.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.projetocrud.model.Usuario;
import com.projetocrud.repository.UsuarioRepository;

@Repository
public class ImplementsUserDetails implements UserDetailsService{
	
	@Autowired
	UsuarioRepository ur;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		
		Usuario usuario = ur.findByLogin(username);
		
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuario nao encontrado");
		}
		
		return usuario;
		
	}

}
