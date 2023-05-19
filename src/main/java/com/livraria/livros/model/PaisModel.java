package com.livraria.livros.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.livraria.livros.exception.Unique;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

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