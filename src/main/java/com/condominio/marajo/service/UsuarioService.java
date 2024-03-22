package com.condominio.marajo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.condominio.marajo.model.Usuario;

public interface UsuarioService {

	Usuario cadastrarUsuario(Usuario usuario);

	Page<Usuario> listarUsuario(Pageable paginacao);
	
	Usuario buscarUsuarioPeloId(Long id);

	void deletarUsuario(Usuario usuario);
}
