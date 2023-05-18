package com.livraria.livros.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.livraria.livros.exception.Unique;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class CategoriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotNull @NotEmpty @NotBlank @Unique(entityClass = CategoriaModel.class, fieldName = "nome")
    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<LivrosModel> livros;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<LivrosModel> getLivros() {
        return livros;
    }

    public void setLivros(List<LivrosModel> livros) {
        this.livros = livros;
    }
}
