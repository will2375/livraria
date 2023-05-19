package com.livraria.livros.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class EstadoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nome;

    @NotNull
    @ManyToOne
    private PaisModel model;

    @Deprecated
    public EstadoModel() {
    }

    public EstadoModel(String nome, PaisModel model) {
        this.nome = nome;
        this.model = model;
    }
}
