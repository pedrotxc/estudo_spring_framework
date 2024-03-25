package com.condominio.marajo.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.condominio.marajo.dto.condominio.CondominioCadastroDTO;
import com.condominio.marajo.exception.RegraNegocioException;
import com.condominio.marajo.model.Condominio;
import com.condominio.marajo.service.CondominioService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/condominio")
public class CondominioController {

	@Autowired
	CondominioService condominioService;

	@GetMapping("/cadastrar")
	@Transactional
	public ResponseEntity<Object> cadastrar(@RequestBody CondominioCadastroDTO dto, UriComponentsBuilder uriBuilder) {
		Condominio condominio = Condominio.builder().nome(dto.getNome()).cnpj(dto.getCnpj()).sindico(dto.getSindico())
				.build();

		try {
			Condominio condominioCadastrado = condominioService.cadastrarCondominio(condominio);
			URI uri = uriBuilder.path("/condominio/{id}").buildAndExpand(condominioCadastrado.getId()).toUri();
			return ResponseEntity.created(uri).body(condominioCadastrado);
		} catch (RegraNegocioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
