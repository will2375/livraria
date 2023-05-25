package com.livraria.livros.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
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

    @Column(precision = 4)
    private BigDecimal valorTotal;

    //lista de livros com quantidade
    @ElementCollection
    @CollectionTable(
            name = "COMPRA_ITEM",
            joinColumns = @JoinColumn(name = "COMPRA_ID")
    )
    private List<ItemCompra> itens = new LinkedList<>();

    public void addItem(ItemCompra item) {
        this.itens.add(item);
        var total = BigDecimal.ZERO;
        for (var i:this.itens) {
            total = total.add(i.getTotal());
        }
        this.valorTotal = total.setScale(4, RoundingMode.HALF_EVEN);
    }

    //lista de cupons
    @ElementCollection
    @CollectionTable(
            name = "COMPRA_CUPOM",
            joinColumns = @JoinColumn(name = "COMPRA_ID")
    )
    @Column(name = "CUPOM")
    private Set<String> cupons = new LinkedHashSet<>();


    public ItemCompra[] getItens() {
        return itens.toArray(new ItemCompra[0]);
    }

}
