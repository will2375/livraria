package com.livraria.livros.model.cupomdto;

import com.livraria.livros.model.CupomModel;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class CupomResponse {

    private Long id;
    private String codigo;
    private BigDecimal desconto;
    private LocalDate validade;

    public CupomResponse(CupomModel model) {
        this.id = model.getId();
        this.codigo = model.getCodigo();
        this.desconto = model.getDesconto();
        this.validade = model.getValidade();
    }
}
