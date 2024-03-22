package com.condominio.marajo.model;

import com.condominio.marajo.dto.usuario.UsuarioAtualizacaoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Usuario")
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;;
	private String senha;

	public void atualizaInformacoes(UsuarioAtualizacaoDTO dto) {
		this.nome = dto.getNome();
		this.email = dto.getEmail();
		this.senha = dto.getSenha();
	}
}
