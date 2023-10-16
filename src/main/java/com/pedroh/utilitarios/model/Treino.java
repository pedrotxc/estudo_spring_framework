package com.pedroh.utilitarios.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Treino {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String exercicio;
	private Integer series;
	private Integer repeticoes;
	private String observacao;
	@OneToMany
	private List<DetalheExercicio> detalheExercicio;

}
