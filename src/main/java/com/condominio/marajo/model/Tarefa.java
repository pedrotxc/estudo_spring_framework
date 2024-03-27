package com.condominio.marajo.model;

import java.math.BigDecimal;

import com.condominio.marajo.dto.tarefa.TarefaAtualizacaoDTO;

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

@Entity(name = "Tarefa")
@Table(name = "tarefa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tarefa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String descricaoTarefa;
	private Integer diaDeVencimentoContas;
	private Integer diaDeVencimentoBoleto;
	private BigDecimal valorBoleto;

	public void atualizarTarefa(TarefaAtualizacaoDTO dto) {
		this.descricaoTarefa = dto.getDescricaoTarefa();
		this.diaDeVencimentoBoleto = dto.getDiaDeVencimentoBoleto();
		this.diaDeVencimentoContas = dto.getDiaDeVencimentoContas();
		this.valorBoleto = dto.getValorBoleto();
	}
}
