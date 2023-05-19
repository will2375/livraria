package com.livraria.livros.model.estadodto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.livraria.livros.exception.Unique;
import com.livraria.livros.exception.ValidId;
import com.livraria.livros.model.EstadoModel;
import com.livraria.livros.model.PaisModel;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EstadoRequest {

    @NotNull
    @ValidId(entityClass = PaisModel.class)
    private final Long paisId;

    @NotEmpty
    @Unique(entityClass = EstadoModel.class, fieldName = "nome")
    private final String nome;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public EstadoRequest(@NotNull @ValidId(entityClass = PaisModel.class) Long paisId,
                         @NotEmpty @Unique(entityClass = EstadoModel.class, fieldName = "nome") String nome) {
        this.paisId = paisId;
        this.nome = nome;
    }

    public EstadoModel toModel(EntityManager entityManager) {
        return new EstadoModel(nome, entityManager.find(PaisModel.class, this.paisId));
    }
}
