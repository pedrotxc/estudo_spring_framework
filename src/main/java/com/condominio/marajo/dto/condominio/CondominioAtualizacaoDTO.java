package com.condominio.marajo.dto.condominio;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CondominioAtualizacaoDTO {

	private Long id;
	private String nome;
	private String cnpj;
	private String sindico;
}
