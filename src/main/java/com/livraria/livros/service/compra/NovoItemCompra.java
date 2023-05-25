package com.livraria.livros.service.compra;

import com.livraria.livros.model.ItemCompra;
import com.livraria.livros.repository.LivrosRepository;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NovoItemCompra {

    private Long livroId;

    private Integer quantidade;


    public ItemCompra toModel(LivrosRepository repository) {
        var livro = repository
                .findById(getLivroId())
                .orElseThrow(() -> new RuntimeException("livro não encontrado"));
        return ItemCompra.builder()
                .livrosModel(livro)
                .quantidade(getQuantidade())
                .build();
    }
}
