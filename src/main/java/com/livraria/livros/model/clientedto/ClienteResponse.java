package com.livraria.livros.model.clientedto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponse {

    private Long id;
    private String nome;
    private String sobrenome;
    private String cidade;
    private String estado;
    private String pais;
    private String telefone;
    private String email;
}
