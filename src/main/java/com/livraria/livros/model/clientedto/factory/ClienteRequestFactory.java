package com.livraria.livros.model.clientedto.factory;

import com.livraria.livros.model.ClienteModel;
import com.livraria.livros.model.clientedto.ClienteRequest;

public class ClienteRequestFactory {

    public static ClienteModel
    criar(ClienteRequest request) {
        return ClienteModel.builder()
                .nome(request.getNome())
                .sobrenome(request.getSobrenome())
                .email(request.getEmail())
                .telefone(request.getTelefone())
                .cpf(request.getCpf())
                .pais(request.getPais())
                .estado(request.getEstado())
                .cidade(request.getCidade())
                .cep(request.getCep())
                .endereco(request.getEndereco())
                .complemento(request.getComplemento())
                .build();
    }
}
