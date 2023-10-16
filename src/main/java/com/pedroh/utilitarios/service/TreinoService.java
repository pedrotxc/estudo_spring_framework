package com.pedroh.utilitarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedroh.utilitarios.model.Treino;
import com.pedroh.utilitarios.repository.TreinoRepository;

@Service
public class TreinoService {
	
	@Autowired
	private TreinoRepository repository;
	
	public void cadastrarTreino(Treino treino) {
		repository.save(treino);
	}
	
	public List<Treino> buscarTreinos(){
		return repository.findAll();
	}
	
	public Treino buscarTreinoPeloId(Long id) {
		return repository.findById(id).get();
	}
}
