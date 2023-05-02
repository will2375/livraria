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
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String sobrenome;

    @Column
    private String email;

    @Column(unique = true)
    private String cpf;

    @Column
    private String endereco;

    @Column
    private String complemento;

    @Column
    private String pais;

    @Column
    private String estado;

    @Column
    private String cidade;

    @Column
    private String telefone;

    @Column
    private String cep;
}
