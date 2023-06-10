package com.pedroh.utilitarios.model;

import java.math.BigDecimal;

import com.pedroh.utilitarios.enums.Tipo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "registro")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String data;
    private String descricao;
    private Tipo tipo;
    private BigDecimal valor;
    
    public Registro(BigDecimal valor, String descricao, String data, Tipo tipo) {
    	this.data = data;
    	this.descricao = descricao;
    	this.tipo = tipo;
    	this.valor = valor;
    }
    
}
