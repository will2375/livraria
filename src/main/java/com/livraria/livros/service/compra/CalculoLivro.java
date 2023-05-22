package com.livraria.livros.service.compra;

import java.math.BigDecimal;

public interface CalculoLivro {

    public static BigDecimal calcular(Integer quantidade, BigDecimal valor) {
        BigDecimal qtd = BigDecimal.valueOf(quantidade);
       BigDecimal total = qtd.multiply(valor);
       return total;
    }
}
