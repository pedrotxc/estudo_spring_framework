package com.condominio.marajo.model;

import com.condominio.marajo.dto.condominio.CondominioAtualizacaoDTO;

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

@Entity(name = "Condominio")
@Table(name = "condominio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Condominio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cnpj;
	private String sindico;

	
	public void atualizarCondominio(CondominioAtualizacaoDTO dto) {
		this.nome = dto.getNome();
		this.cnpj = dto.getCnpj();
		this.sindico = dto.getSindico();
	}
}
