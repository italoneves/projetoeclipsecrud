package com.projetocrud.model;

import java.util.Collection;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;




//@Column(nullable = true, columnDefinition = "TEXT", length = 10000)


@Entity
public class Usuario implements UserDetails{
	
	@Id
	private String login;

	private String senha;
	
	@Column(columnDefinition = "varchar(10)" )
	private String nome;

	
	
	
	public String getLogin() {
		
		return this.login;
	}

	public void setLogin(String login) {
		

		this.login = login;
	}

	public String getSenha() {
		
		return this.senha;
	}

	public void setSenha(String senha) {
		

		this.senha = senha;
	}

	public String getNome() {
	
		return nome;
	}

	public void setNome(String nome) {
		
		this.nome = nome;
	}

	
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public String getPassword() { 
		System.out.println("ENtrou em get passwrod ");
		// TODO Auto-generated method stub
		return this.getSenha();
	}

	@Override
	public String getUsername() {
		
		// TODO Auto-generated method stub
		return this.getLogin(); 	
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	

}
