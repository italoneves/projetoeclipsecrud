package com.projetocrud.model;


import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "clientes")
public class Cliente{
	
	
//@Column(nullable = true, columnDefinition = "TEXT", length = 10000)

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;
	
	@Column(unique = true)
	@CPF
	private String cpf;
	
	@Column(columnDefinition = "varchar(60)")
	@NotBlank(message = "Digite  um nome")
	private String nome;
	
	@Column(columnDefinition = "varchar(9)")
	@NotBlank(message = "Digite um cep")
	private String cep;
	
	@Column
	@javax.validation.constraints.NotEmpty(message = "Digite algo")
	private String rua;
	
	
	@Column(columnDefinition = "varchar(8)")
	private String numero; 
	@Column

	private String sexo;
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate datanasc; 
	
	@Column(columnDefinition = "varchar(20)")
	private String convenio;
	@Column(columnDefinition = "varchar(20)" )
	private String numerocarteira;


	public LocalDate getDatanasc() {
		return datanasc;
	}
	public void setDatanasc(LocalDate datanasc) {
		this.datanasc = datanasc;
	}
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getConvenio() {
		return convenio;
	}
	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}
	public String getNumerocarteira() {
		return numerocarteira;
	}
	public void setNumerocarteira(String numerocarteira) {
		this.numerocarteira = numerocarteira;
	}

	
	
	
	

	
	

}
