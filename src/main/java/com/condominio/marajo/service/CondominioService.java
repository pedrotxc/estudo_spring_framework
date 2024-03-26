package com.condominio.marajo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.condominio.marajo.model.Condominio;

public interface CondominioService {
	
	Condominio cadastrarCondominio(Condominio condominio);

	Page<Condominio> listarCondominio(Pageable pageable);

	Condominio detalharCondominio(Long id);

	void removerCondominio(Condominio condominio);
}
