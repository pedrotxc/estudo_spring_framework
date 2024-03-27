package com.condominio.marajo.dto.tarefa;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TarefaDetalhesDTO {

	private String descricaoTarefa;
	private Integer diaDeVencimentoContas;
	private Integer diaDeVencimentoBoleto;
	private BigDecimal valorBoleto;
}
