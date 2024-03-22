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

import com.condominio.marajo.dto.usuario.UsuarioAtualizacaoDTO;
import com.condominio.marajo.dto.usuario.UsuarioCadastroDTO;
import com.condominio.marajo.dto.usuario.UsuarioDetalhesDTO;
import com.condominio.marajo.exception.RegraNegocioException;
import com.condominio.marajo.model.Usuario;
import com.condominio.marajo.service.UsuarioService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/condominio/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@PostMapping("/cadastrar")
	@Transactional
	public ResponseEntity<Object> cadastrar(@RequestBody @Valid UsuarioCadastroDTO dto,
			UriComponentsBuilder uriBuilder) {
		Usuario usuario = Usuario.builder().nome(dto.getNome()).email(dto.getEmail()).senha(dto.getSenha()).build();

		try {
			Usuario usuarioCadastrado = usuarioService.cadastrarUsuario(usuario);
			URI uri = uriBuilder.path("condominio/usuario/{id}").buildAndExpand(usuarioCadastrado.getId()).toUri();

			return ResponseEntity.created(uri).body(dto);
		} catch (RegraNegocioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping("/listar")
	public ResponseEntity<Page<Usuario>> listar(@PageableDefault(sort = { "nome" }) Pageable paginacao) {
		Page<Usuario> lsUsuario = usuarioService.listarUsuario(paginacao);
		return ResponseEntity.ok(lsUsuario);
	}

	@PutMapping("/atualizar")
	@Transactional
	public ResponseEntity<Object> atualizar(@RequestBody @Valid UsuarioAtualizacaoDTO dto) {
		Usuario usuario = usuarioService.buscarUsuarioPeloId(dto.getId());

		usuario.atualizaInformacoes(dto);

		return ResponseEntity.ok(dto);

	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Object> deletar(@PathVariable Long id) {
		Usuario usuario = usuarioService.buscarUsuarioPeloId(id);
		usuarioService.deletarUsuario(usuario);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> detalhar(@PathVariable Long id) {
		Usuario usuario = usuarioService.buscarUsuarioPeloId(id);
		return ResponseEntity
				.ok(UsuarioDetalhesDTO.builder().nome(usuario.getNome()).email(usuario.getEmail()).build());
	}
}
