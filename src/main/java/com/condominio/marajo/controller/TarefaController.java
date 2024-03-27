package com.condominio.marajo.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.condominio.marajo.dto.tarefa.TarefaAtualizacaoDTO;
import com.condominio.marajo.dto.tarefa.TarefaCadastroDTO;
import com.condominio.marajo.dto.tarefa.TarefaDetalhesDTO;
import com.condominio.marajo.exception.RegraNegocioException;
import com.condominio.marajo.model.Tarefa;
import com.condominio.marajo.service.TarefaService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/condominio/tarefa")
public class TarefaController {

	@Autowired
	TarefaService tarefaService;

	@PostMapping("/cadastrar")
	@Transactional
	public ResponseEntity<Object> cadastrar(@RequestBody TarefaCadastroDTO dto, UriComponentsBuilder uriBuilder) {
		Tarefa tarefa = Tarefa.builder().descricaoTarefa(dto.getDescricaoTarefa())
				.diaDeVencimentoBoleto(dto.getDiaDeVencimentoBoleto())
				.diaDeVencimentoContas(dto.getDiaDeVencimentoContas()).valorBoleto(dto.getValorBoleto()).build();
		try {
			Tarefa tarefaSalva = tarefaService.cadastrarTarefa(tarefa);
			URI uri = uriBuilder.path("/condominio/tarefa/{id}").buildAndExpand(tarefaSalva.getId()).toUri();
			return ResponseEntity.created(uri).body(dto);
		} catch (RegraNegocioException e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping("/listar")
	public ResponseEntity<Page<Tarefa>> listar(@PageableDefault(sort = "nome") Pageable page) {
		Page<Tarefa> lsTarefas = tarefaService.listarTarefa(page);
		return ResponseEntity.ok(lsTarefas);
	}

	@PutMapping("/atualizar")
	@Transactional
	public ResponseEntity<TarefaAtualizacaoDTO> atualizar(@RequestBody TarefaAtualizacaoDTO dto) {
		Tarefa tarefaDetalhada = tarefaService.detalharTarefa(dto.getId());
		tarefaDetalhada.atualizarTarefa(dto);
		return ResponseEntity.ok(dto);
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Object> deletar(@PathVariable Long id) {
		Tarefa tarefaDetalhada = tarefaService.detalharTarefa(id);
		tarefaService.deletarTarefa(tarefaDetalhada);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<TarefaDetalhesDTO> detalhar(@PathVariable Long id) {
		Tarefa tarefaDetalhada = tarefaService.detalharTarefa(id);
		return ResponseEntity.ok(TarefaDetalhesDTO.builder().descricaoTarefa(tarefaDetalhada.getDescricaoTarefa())
				.diaDeVencimentoContas(tarefaDetalhada.getDiaDeVencimentoContas())
				.diaDeVencimentoBoleto(tarefaDetalhada.getDiaDeVencimentoBoleto())
				.valorBoleto(tarefaDetalhada.getValorBoleto()).build());
	}
}
