package com.estudo.listacompras.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudo.listacompras.model.Produto;
import com.estudo.listacompras.repository.ListaComprasRepository;

@Service
public class ListaComprasService {
	
	@Autowired
	private ListaComprasRepository repository;
	
	public void salvar(Produto compras) {
		repository.save(compras);
	}
	
	public List<Produto> listarCompras(){
		return repository.findAll();
	}
	
	public Produto listarPeloId(Long id) {
		return repository.findById(id).get();
	}
	
	public void alterarListaCompras(Long id) {
		Produto compras = repository.findById(id).get();
		repository.save(compras);
	}
	
	public void deletarCompras(Long id) {
		repository.deleteById(id);
	}
}
