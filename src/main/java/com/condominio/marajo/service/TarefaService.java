package com.condominio.marajo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.condominio.marajo.model.Tarefa;

public interface TarefaService{

	Tarefa cadastrarTarefa(Tarefa tarefa);

	Page<Tarefa> listarTarefa(Pageable page);

	Tarefa detalharTarefa(Long id);

	void deletarTarefa(Tarefa tarefa);

}
