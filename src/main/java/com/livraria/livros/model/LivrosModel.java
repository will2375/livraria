package com.livraria.livros.model;

import com.livraria.livros.repository.LivrosRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@Entity
@Builder
@Getter
@Setter
public class LivrosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String titulo;

    @NotEmpty
    private String sumario;

    @Size(min = 1, max = 500)
    private String resumo;

    @NotEmpty
    private String isbn;

    @NotNull
    @Future
    private LocalDate dataLancamento;

    @NotNull
    @Min(100)
    private Integer numeroDePaginas;

    @NotNull
    @Min(20)
    private BigDecimal preco;

    @ManyToOne
    @NotNull
    private CategoriaModel categoria;

    @ManyToOne
    @NotNull
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
