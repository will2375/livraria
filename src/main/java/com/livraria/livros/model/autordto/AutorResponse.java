package com.livraria.livros.model.autordto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AutorResponse {

    private Long id;
    private String nome;
    private String descricao;
}
