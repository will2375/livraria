package com.livraria.livros.model.livrosdto;

import com.livraria.livros.model.LivrosModel;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class LivrosResponse {

    private Long livroId;

    private String sumario;

    private String resumo;

    private String isbn;

    private LocalDate dataLancamento;

    private Integer numeroDePaginas;

    private BigDecimal preco;

    public LivrosResponse(LivrosModel model) {
        this.livroId = model.getId();
        this.sumario = model.getSumario();
        this.resumo = model.getResumo();
        this.isbn = model.getIsbn();
        this.dataLancamento = model.getDataLancamento();
        this.numeroDePaginas = model.getNumeroDePaginas();
        this.preco = model.getPreco();

    }
}
