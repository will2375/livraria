package com.livraria.livros.model.livrosdto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.livraria.livros.exception.Unique;
import com.livraria.livros.exception.ValidId;
import com.livraria.livros.model.AutorModel;
import com.livraria.livros.model.CategoriaModel;
import com.livraria.livros.model.LivrosModel;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivrosRequest {

    @NotEmpty
    @Unique(entityClass = LivrosModel.class, fieldName = "titulo")
    private final String titulo;

    @NotEmpty
    private final String sumario;

    @Size(min = 1, max = 500)
    private final String resumo;

    @NotEmpty
    @Unique(entityClass = LivrosModel.class, fieldName = "isbn")
    private final String isbn;

    @NotNull
    @Future
    private final LocalDate dataLancamento;

    @NotNull
    @Min(100)
    private final Integer numeroDePaginas;

    @NotNull
    @Min(20)
    private final BigDecimal preco;

    @NotNull
    @ValidId(entityClass = CategoriaModel.class, message = "categoria informada não é válida")
    private final Long categoriaId;

    @NotNull
    @ValidId(entityClass = AutorModel.class, message = "autor informado não é válida")
    private final Long autorId;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public LivrosRequest(
            @NotEmpty @Unique(entityClass = LivrosModel.class, fieldName = "titulo") String titulo,
            @NotEmpty String sumario, @Size(min = 1, max = 500) String resumo,
            @NotEmpty @Unique(entityClass = LivrosModel.class, fieldName = "isbn") String isbn,
            @NotNull @Future @JsonFormat(pattern = "yyyy-MM-dd") LocalDate dataLancamento,
            @NotNull @Min(100) Integer numeroDePaginas,
            @NotNull @Min(20) BigDecimal preco,
            @NotNull
            @ValidId(entityClass = CategoriaModel.class, message = "categoria informada não é válida") Long categoriaId,
            @NotNull
            @ValidId(entityClass = AutorModel.class, message = "autor informado não é válida") Long autorId) {
        super();
        this.titulo = titulo;
        this.sumario = sumario;
        this.resumo = resumo;
        this.isbn = isbn;
        this.dataLancamento = dataLancamento;
        this.numeroDePaginas = numeroDePaginas;
        this.preco = preco;
        this.categoriaId = categoriaId;
        this.autorId = autorId;
    }

    public LivrosModel toModel(EntityManager manager) {
        LivrosModel livro = LivrosModel
                .builder()
                .autor(manager.find(AutorModel.class, this.autorId))
                .categoria(manager.find(CategoriaModel.class, this.categoriaId))
                .titulo(this.titulo)
                .sumario(this.sumario)
                .resumo(this.resumo)
                .isbn(this.isbn)
                .numeroDePaginas(this.numeroDePaginas)
                .dataLancamento(this.dataLancamento)
                .preco(this.preco)
                .build();
        return livro;
    }

}
