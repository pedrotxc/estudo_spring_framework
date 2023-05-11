package com.pedroh.utilitarios.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "Investment")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Investment {

    @Id
    private Long id;
    private BigDecimal value;
    private LocalDate investmentDate;
    private String description;
    private String category;

}
