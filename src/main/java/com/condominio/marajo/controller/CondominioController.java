package com.condominio.marajo.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.condominio.marajo.dto.condominio.CondominioAtualizacaoDTO;
import com.condominio.marajo.dto.condominio.CondominioCadastroDTO;
import com.condominio.marajo.dto.condominio.CondominioDetalhesDTO;
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

	@GetMapping("/listar")
	public ResponseEntity<Page<Condominio>> listar(@PageableDefault(sort = "nome") Pageable pageable) {
		Page<Condominio> lsCondominio = condominioService.listarCondominio(pageable);
		return ResponseEntity.ok(lsCondominio);
	}

	@PutMapping("/atualizar")
	@Transactional
	public ResponseEntity<Condominio> atualizar(@RequestBody CondominioAtualizacaoDTO dto) {
		Condominio condominio = condominioService.detalharCondominio(dto.getId());
		condominio.atualizarCondominio(dto);
		return ResponseEntity.ok(condominio);
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Object> deletar(@RequestParam Long id) {
		Condominio condominio = condominioService.detalharCondominio(id);
		condominioService.removerCondominio(condominio);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<CondominioDetalhesDTO> detalhar(@RequestParam Long id) {
		Condominio condominio = condominioService.detalharCondominio(id);
		CondominioDetalhesDTO condominioDetalhado = CondominioDetalhesDTO.builder().nome(condominio.getNome())
				.cnpj(condominio.getCnpj()).sindico(condominio.getSindico()).build();

		return ResponseEntity.ok(condominioDetalhado);
	}
}
