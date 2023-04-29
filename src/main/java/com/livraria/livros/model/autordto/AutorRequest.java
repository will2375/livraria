package com.livraria.livros.model.autordto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AutorRequest {

    @NotNull(message = "nome não pode ser nulo")
    @NotEmpty(message = "nome não pode ser vazio")
    private String nome;
    @NotNull(message = "email não pode ser nulo")
    @NotEmpty(message = "email não pode ser vazio")
    @Email
    private String email;
    @NotNull(message = "descrição não pode ser nulo")
    @NotEmpty(message = "descrição não pode ser vazio")
    private String descricao;

    private LocalDateTime dataCadastro;
}
