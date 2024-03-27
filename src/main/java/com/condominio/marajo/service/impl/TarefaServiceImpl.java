package com.condominio.marajo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.condominio.marajo.exception.RegraNegocioException;
import com.condominio.marajo.model.Tarefa;
import com.condominio.marajo.repository.TarefaRepository;
import com.condominio.marajo.service.TarefaService;

@Service
public class TarefaServiceImpl implements TarefaService {

	@Autowired
	TarefaRepository tarefaRepository;

	@Override
	public Tarefa cadastrarTarefa(Tarefa tarefa) {
		Tarefa tarefaSalva = tarefaRepository.save(tarefa);
		return tarefaSalva;
	}

	@Override
	public Page<Tarefa> listarTarefa(Pageable page) {
		return tarefaRepository.findAll(page);
	}

	@Override
	public Tarefa detalharTarefa(Long id) {
		return tarefaRepository.findById(id)
				.orElseThrow(() -> new RegraNegocioException("Não foi possível identificar a tarefa na base de dados"));
	}

	@Override
	public void deletarTarefa(Tarefa tarefa) {
		tarefaRepository.delete(tarefa);
	}

}
