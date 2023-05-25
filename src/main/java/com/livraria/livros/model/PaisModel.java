package com.livraria.livros.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
public class PaisModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @NotEmpty
    private String nome;

   @Deprecated
    public PaisModel() {
   }

   public PaisModel(@NotEmpty String nome) {this.nome = nome;}
}