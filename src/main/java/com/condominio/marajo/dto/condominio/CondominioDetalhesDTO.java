package com.condominio.marajo.dto.condominio;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CondominioDetalhesDTO {
	
	private String nome;
	private String cnpj;
	private String sindico;
}
