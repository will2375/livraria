package com.livraria.livros.model;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


@Entity
@Getter
public class CompraModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //lista de livros com quantidade
    @ElementCollection
    @CollectionTable(
            name = "COMPRA_ITEM",
            joinColumns = @JoinColumn(name = "COMPRA_ID")
    )
    private List<ItemCompra> itens = new LinkedList<>();

    //lista de cupons
    @ElementCollection
    @CollectionTable(
            name = "COMPRA_CUPOM",
            joinColumns = @JoinColumn(name = "COMPRA_ID")
    )
    @Column(name = "CUPOM")
    private Set<String> cupons = new LinkedHashSet<>();

}
