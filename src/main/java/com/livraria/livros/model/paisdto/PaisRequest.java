package com.livraria.livros.model.paisdto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.livraria.livros.exception.Unique;
import com.livraria.livros.model.PaisModel;

import javax.validation.constraints.NotEmpty;

public class PaisRequest {

    @NotEmpty
    @Unique(entityClass = PaisModel.class, fieldName = "nome")
    private final String nome;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public PaisRequest(
            @NotEmpty @Unique(entityClass = PaisModel.class, fieldName = "nome") String nome) {
        this.nome = nome;
    }

    public PaisModel toModel() {return new PaisModel(this.nome);}
}
