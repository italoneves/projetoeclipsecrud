package com.projetocrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetocrud.model.Cliente;

public interface ClientesRepository extends JpaRepository<Cliente, Long>{

}
