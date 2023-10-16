package com.pedroh.utilitarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedroh.utilitarios.model.Treino;

@Repository
public interface TreinoRepository extends JpaRepository<Treino, Long>{

}
