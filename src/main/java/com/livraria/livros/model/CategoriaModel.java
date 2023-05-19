package com.livraria.livros.model;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;


@Entity
@Getter
public class CategoriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nome;

    @Deprecated
    public CategoriaModel() {super();}

    public CategoriaModel(@NotEmpty String nome) {
        super();
        this.nome = nome;
    }

}
