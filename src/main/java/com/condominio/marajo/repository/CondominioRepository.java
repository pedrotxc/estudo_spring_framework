package com.condominio.marajo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.condominio.marajo.model.Condominio;

@Repository
public interface CondominioRepository extends JpaRepository<Condominio, Long>{
	
	Page<Condominio> findAll(Pageable page);
}
