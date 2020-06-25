package com.projetocrud.model;

public enum Sexo {
	
	MASCULINO("Masculino"),
	FEMININO("Feminino");
	
	private String genero;
	
	Sexo(String genero){
		
		this.genero = genero;
		
	}

	public String getGenero() {
		return genero;
	}
	
	
	

}
