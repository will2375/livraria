package com.livraria.livros.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
@Getter
@Setter
public class ItemCompra {

    @ManyToOne
    private LivrosModel livrosModel;

    private Integer quantidade;
}
