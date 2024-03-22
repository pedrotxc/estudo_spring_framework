package com.condominio.marajo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.condominio.marajo.exception.RegraNegocioException;
import com.condominio.marajo.model.Usuario;
import com.condominio.marajo.repository.UsuarioRepository;
import com.condominio.marajo.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public Usuario cadastrarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public Page<Usuario> listarUsuario(Pageable paginacao) {
		return usuarioRepository.findAll(paginacao);
	}

	@Override
	public Usuario buscarUsuarioPeloId(Long id) {
		return usuarioRepository.findById(id)
				.orElseThrow(() -> new RegraNegocioException("Não foi possível encontrar o usuário na base de dados."));
	}

	@Override
	public void deletarUsuario(Usuario usuario) {
		usuarioRepository.delete(usuario);
	}

}
