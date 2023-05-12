package com.livraria.livros.model;

import com.livraria.livros.exception.Unique;
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
public class EstadoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @Unique(entityClass = EstadoModel.class, fieldName = "nome")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "pais_id", referencedColumnName = "id")
    private PaisModel pais;
}
