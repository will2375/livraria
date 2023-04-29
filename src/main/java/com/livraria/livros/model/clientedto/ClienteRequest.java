package com.livraria.livros.model.clientedto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequest {

    @NotNull(message = "nome não pode ser nulo")
    @NotEmpty(message = "nome não pode ser vazio")
    private String nome;

    @NotNull(message = "sobrenome não pode ser nulo")
    @NotEmpty(message = "sobrenome não pode ser vazio")
    private String sobrenome;

    @NotNull(message = "email não pode ser nulo")
    @NotEmpty(message = "email não pode ser vazio")
    @Email
    private String email;

    @NotNull(message = "cpf não pode ser nulo")
    @NotEmpty(message = "cpf não pode ser vazio")
    @CPF
    private String cpf;

    @NotNull(message = "endereço não pode ser nulo")
    @NotEmpty(message = "endereço não pode ser vazio")
    private String endereco;

    @NotNull(message = "complemento não pode ser nulo")
    @NotEmpty(message = "complemento não pode ser vazio")
    private String complemento;

    @NotNull(message = "cidade não pode ser nulo")
    @NotEmpty(message = "cidade não pode ser vazio")
    private String cidade;

    @NotNull(message = "pais não pode ser nulo")
    @NotEmpty(message = "pais não pode ser vazio")
    private String pais;

    @NotNull(message = "estado não pode ser nulo")
    @NotEmpty(message = "estado não pode ser vazio")
    private String estado;

    @NotNull(message = "telefone não pode ser nulo")
    @NotEmpty(message = "telefone não pode ser vazio")
    private String telefone;

    @NotNull(message = "cep não pode ser nulo")
    @NotEmpty(message = "cep não pode ser vazio")
    private String cep;
}
