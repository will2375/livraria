package com.livraria.livros.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Data
public class CompraModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer quantidade;

    @Column
    private Double valor;

    @Column
    private String cupom;

    @Column
    private Double valorTotal;


    @ManyToOne
    @JoinColumn(name = "livro_compra_id", referencedColumnName = "id")
    private LivrosModel livro;

    @ManyToOne
    @JoinColumn(name = "cliente_compra_id", referencedColumnName = "id")
    private ClienteModel cliente;
}
