package com.livraria.livros.model.autordto.factory;

import com.livraria.livros.model.AutorModel;
import com.livraria.livros.model.autordto.AutorResponse;

public class AutorResponseFactory {

    public static AutorResponse
    criar(AutorModel model) {
        return AutorResponse.builder()
                .id(model.getId())
                .nome(model.getNome())
                .descricao(model.getDescricao()).build();
    }
}
