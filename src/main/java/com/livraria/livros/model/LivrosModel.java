package com.livraria.livros.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@Entity
@Builder
@Data
public class LivrosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Getter
    private String titulo;

    @NotEmpty
    @Getter
    private String sumario;

    @Size(min = 1, max = 500)
    @Getter
    private String resumo;

    @NotEmpty
    @Getter
    private String isbn;

    @NotNull
    @Future
    private LocalDate dataLancamento;

    @NotNull
    @Min(100)
    @Getter
    private Integer numeroDePaginas;

    @NotNull
    @Min(20)
    @Getter
    private BigDecimal preco;

    @ManyToOne
    @NotNull
    @Getter
    private CategoriaModel categoria;

    @ManyToOne
    @NotNull
    @Getter
    private AutorModel autor;


    @Deprecated
    public LivrosModel() {

    }

    @Builder
    public LivrosModel(@NotEmpty String titulo, @NotEmpty String sumario, @Size(min = 1, max = 500) String resumo,
                 @NotEmpty String isbn, @NotNull @Future LocalDate dataLancamento,
                 @NotNull @Min(100) Integer numeroDePaginas, @NotNull @Min(20) BigDecimal preco,
                 @NotNull CategoriaModel categoria,
                 @NotNull AutorModel autor) {
        super();
        this.titulo = titulo;
        this.sumario = sumario;
        this.resumo = resumo;
        this.isbn = isbn;
        this.dataLancamento = dataLancamento;
        this.numeroDePaginas = numeroDePaginas;
        this.preco = preco;
        this.categoria = categoria;
        this.autor = autor;
    }

    public Long getId() {
        Assert.notNull(this.id, "não é possível recuperar o ID de um livro não registrado!");
        return this.id;
    }
}
