package com.livraria.livros.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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


    @JsonIgnore
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<CompraModel> clientes;
}
