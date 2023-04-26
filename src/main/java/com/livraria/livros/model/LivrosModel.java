package com.livraria.livros.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Data
public class LivrosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotBlank @NotNull @NotEmpty
    private String titulo;

    @Column(unique = true, length = 500)
    @NotBlank @NotNull @NotEmpty
    private String resumo;

    @Column
    @NotBlank @NotNull @NotEmpty
    private String sumario;

    @Column
    @NotBlank @NotNull @NotEmpty
    private BigDecimal preco;

    @Column
    @NotBlank @NotNull @NotEmpty
    private String paginas;

    @Column
    @NotBlank @NotNull @NotEmpty
    private String isbn;

    @Column
    @NotBlank @NotNull @NotEmpty
    private LocalDate dataLancamento;
}
