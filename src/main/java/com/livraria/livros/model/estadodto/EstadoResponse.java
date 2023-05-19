package com.livraria.livros.model.estadodto;

import com.livraria.livros.model.EstadoModel;
import lombok.Getter;

@Getter
public class EstadoResponse {

    private final Long id;

    private final String nome;

    public EstadoResponse(EstadoModel model) {
        this.id = model.getId();
        this.nome = model.getNome();
    }
}
