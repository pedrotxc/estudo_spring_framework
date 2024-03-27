package com.condominio.marajo.dto.tarefa;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TarefaAtualizacaoDTO {
	
	private Long id;
	private String descricaoTarefa;
	private Integer diaDeVencimentoContas;
	private Integer diaDeVencimentoBoleto;
	private BigDecimal valorBoleto;
}
