package com.condominio.marajo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.condominio.marajo.model.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long>{

}
