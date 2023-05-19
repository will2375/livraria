package com.livraria.livros.model.categoriadto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.livraria.livros.exception.Unique;
import com.livraria.livros.model.CategoriaModel;

import javax.validation.constraints.NotEmpty;

public class CategoriaRequest {

    @NotEmpty
    @Unique(entityClass = CategoriaModel.class, fieldName = "nome")
    private final String nome;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public CategoriaRequest(
            @NotEmpty @Unique(entityClass = CategoriaModel.class, fieldName = "nome") String nome) {
        super();
        this.nome = nome;
    }

    public CategoriaModel toModel() {return new CategoriaModel(this.nome);}

}
