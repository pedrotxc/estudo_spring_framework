package com.condominio.marajo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.condominio.marajo.model.Condominio;
import com.condominio.marajo.repository.CondominioRepository;

@Service
public class CondominioServiceImpl {
	
	@Autowired
	CondominioRepository condominioRepository;
	
	
	public Condominio cadastrarCondominio(Condominio condominio) {
		return condominioRepository.save(condominio);
	}
}
