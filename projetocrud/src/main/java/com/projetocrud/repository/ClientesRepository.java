package com.projetocrud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.projetocrud.model.Cliente;

public interface ClientesRepository extends JpaRepository<Cliente, Long>{
	
	Cliente findByNome(String nome);
	
	List<Cliente> findByNomeContaining(String nome); //Busca com like % %
	
	Cliente findByCodigo(Long codigo);
	
	
	
	//	@Query("SELECT u.nome FROM clientes u WHERE u.nome LIKE CONCAT('%',:nome,'%')")
	//	List<String> findNomeComLike(@Param("username") String nome);
}
