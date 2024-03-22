package com.condominio.marajo.dto.usuario;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioAtualizacaoDTO {
	
	@NotNull
	private Long id;
	private String nome;
	private String email;
	private String senha;
}
