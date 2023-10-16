package com.pedroh.utilitarios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedroh.utilitarios.model.DetalheExercicio;
import com.pedroh.utilitarios.model.Treino;

public interface DetalheExercicioRepository extends JpaRepository<DetalheExercicio, Long>{
	
	List<DetalheExercicio> findByTreino(Treino treino);
}
