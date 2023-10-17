package com.estudo.financas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudo.financas.model.Investidor;
import com.estudo.financas.repository.InvestidorRepository;

@Service
public class InvestidorService {
	
	@Autowired
	private InvestidorRepository investidorRepository;
	
	public List<Investidor> buscarInvestidores(){
		return investidorRepository.findAll();
	}
	
	public void cadastrarInvestidor(Investidor investidor) {
		investidorRepository.save(investidor);
	}
	
	public void deletarInvestidor(Long id) {
		Investidor investidor = investidorRepository.findById(id).get();
		investidorRepository.delete(investidor);
	}
}
