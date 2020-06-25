package com.projetocrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetocrud.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
	
	Usuario findByLogin(String login);
	
	

}
