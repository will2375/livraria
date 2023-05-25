package com.livraria.livros.model.cupomdto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.livraria.livros.exception.Unique;
import com.livraria.livros.model.CupomModel;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDate;

public class CupomRequest {


    @NotEmpty
    @Unique(entityClass = CupomModel.class, fieldName = "codigo")
    private final String codigo;

    private final BigDecimal desconto;

    private final LocalDate validade;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public CupomRequest(
            @NotEmpty @Unique(entityClass = CupomModel.class, fieldName = "codigo") String codigo, BigDecimal desconto, LocalDate validade) {
        this.codigo = codigo;
        this.desconto = desconto;
        this.validade = validade;
    }

    public CupomModel toModel() {
        return new CupomModel(this.codigo, this.desconto, this.validade);
    }
}
