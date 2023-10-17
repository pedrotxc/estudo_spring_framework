package com.estudo.financas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estudo.financas.model.Investidor;

@Repository
public interface InvestidorRepository extends JpaRepository<Investidor, Long>{

}
