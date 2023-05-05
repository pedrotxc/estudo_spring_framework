package model;

import jakarta.persistence.Entity;
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

    private Long id;
    private BigDecimal value;
    private String receiptDate;
    private String description;

}
