package com.pedroh.utilitarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedroh.utilitarios.model.Registro;

@Repository
public interface IndexRepository extends JpaRepository<Registro, Long>{

}
