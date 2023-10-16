package com.pedroh.utilitarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedroh.utilitarios.model.DetalheExercicio;
import com.pedroh.utilitarios.model.Treino;
import com.pedroh.utilitarios.repository.DetalheExercicioRepository;

@Service
public class DetalheExercicioService {
	
	@Autowired
	private DetalheExercicioRepository detalheExercicioRepository;
	
	public void salvar(DetalheExercicio detalheExercicio) {
		detalheExercicioRepository.save(detalheExercicio);
	}
	
	public List<DetalheExercicio> encontrarDetalhePeloTreino(Treino treino){
		return detalheExercicioRepository.findByTreino(treino);
	}
}
