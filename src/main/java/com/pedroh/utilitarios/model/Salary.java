package com.pedroh.utilitarios.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Table(name = "Salary")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Salary {

    @Id
    private Long id;
    private BigDecimal value;
    private String receiptDate;
    private String description;

}
