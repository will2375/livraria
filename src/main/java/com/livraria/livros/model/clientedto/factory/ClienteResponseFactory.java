package com.livraria.livros.model.clientedto.factory;

import com.livraria.livros.model.ClienteModel;
import com.livraria.livros.model.clientedto.ClienteResponse;

public class ClienteResponseFactory {

    public static ClienteResponse
    criar(ClienteModel model) {
       return ClienteResponse.builder()
               .id(model.getId())
               .nome(model.getNome())
               .sobrenome(model.getSobrenome())
               .pais(model.getPais())
               .estado(model.getEstado())
               .cidade(model.getCidade())
               .email(model.getEmail())
               .telefone(model.getTelefone()).build();
    }
}
