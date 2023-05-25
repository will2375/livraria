package com.livraria.livros.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class CupomModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String codigo;

    private BigDecimal desconto;

    private LocalDate validade;

    @Deprecated
    public CupomModel(){}

    public CupomModel(String codigo, BigDecimal desconto, LocalDate validade) {
        this.codigo = codigo;
        this.desconto = desconto;
        this.validade = validade;
    }
}
