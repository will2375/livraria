package com.livraria.livros.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Data
public class AutorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nome;
    @Column(unique = true)
    private String email;
    @Column(length = 400)
    private String descricao;
    @Column
    private LocalDateTime dataCadastro;

    @JsonIgnore
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<LivrosModel> livros;
}
