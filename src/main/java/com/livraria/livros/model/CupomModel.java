package com.livraria.livros.model;

import com.livraria.livros.exception.Unique;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Data
public class CupomModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @Unique(entityClass = CupomModel.class, fieldName = "codigo")
    private String codigo;

    @Column
    private Double desconto;

    @Column
    private LocalDate validade;

}
