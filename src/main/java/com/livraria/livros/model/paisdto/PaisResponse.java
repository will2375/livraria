package com.livraria.livros.model.paisdto;

import com.livraria.livros.model.PaisModel;
import lombok.Getter;

@Getter
public class PaisResponse {

    private final Long id;
    private final String nome;

    public PaisResponse(PaisModel model) {
        this.id = model.getId();
        this.nome = model.getNome();
    }
}
