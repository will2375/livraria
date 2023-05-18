package com.livraria.livros.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.livraria.livros.exception.Unique;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class PaisModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @Unique(entityClass = PaisModel.class, fieldName = "nome")
    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "pais", cascade = CascadeType.ALL)
    private List<EstadoModel> estado;

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

    public List<EstadoModel> getEstado() {
        return estado;
    }

    public void setEstado(List<EstadoModel> estado) {
        this.estado = estado;
    }
}
