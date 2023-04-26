package com.livraria.livros.model.autordto.factory;

import com.livraria.livros.model.AutorModel;
import com.livraria.livros.model.autordto.AutorRequest;

public class AutorModelFactory {

    public static AutorModel
    criar(AutorRequest request) {
        return AutorModel.builder()
                .id(request.getId())
                .nome(request.getNome())
                .email(request.getEmail())
                .descricao(request.getDescricao())
                .dataCadastro(request.getDataCadastro()).build();
    }
}
