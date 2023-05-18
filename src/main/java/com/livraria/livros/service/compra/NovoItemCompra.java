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
        var item = new ItemCompra();
        repository.findById(getLivroId())
                .ifPresent(item::setLivrosModel);
        item.setQuantidade(getQuantidade());
        return item;
    }
}
