package com.condominio.marajo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.condominio.marajo.exception.RegraNegocioException;
import com.condominio.marajo.model.Condominio;
import com.condominio.marajo.repository.CondominioRepository;
import com.condominio.marajo.service.CondominioService;

@Service
public class CondominioServiceImpl implements CondominioService {

	@Autowired
	CondominioRepository condominioRepository;

	public Condominio cadastrarCondominio(Condominio condominio) {
		return condominioRepository.save(condominio);
	}

	@Override
	public Page<Condominio> listarCondominio(Pageable pageable) {
		return condominioRepository.findAll(pageable);
	}

	@Override
	public Condominio detalharCondominio(Long id) {
		return condominioRepository.findById(id).orElseThrow(
				() -> new RegraNegocioException("Não foi possível encontra o condomínio na base de dados."));
	}

	@Override
	public void removerCondominio(Condominio condominio) {
		condominioRepository.delete(condominio);
	}
}
