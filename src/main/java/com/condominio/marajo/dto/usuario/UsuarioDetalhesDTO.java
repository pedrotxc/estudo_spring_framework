package com.condominio.marajo.dto.usuario;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UsuarioDetalhesDTO {
	
	private String nome;
	private String email;
}
