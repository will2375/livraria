package com.livraria.livros.service.compra;

import java.math.BigDecimal;

public interface CalculoTotal {

     static BigDecimal calcularTudo(BigDecimal saldo, BigDecimal livro){

         BigDecimal total = saldo.add(livro);

         return total;
    }
}
