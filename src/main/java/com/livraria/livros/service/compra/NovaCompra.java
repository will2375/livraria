package com.livraria.livros.service.compra;

import com.livraria.livros.model.CompraModel;
import com.livraria.livros.repository.LivrosRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class NovaCompra {

    private Long id;

    private List<NovoItemCompra> itens;

    private List<String> cupons;

    private BigDecimal valorTotal;


    @Override
    public String toString() {
        return "NovaCompra{" +
                "id=" + id +
                ", itens=" + itens +
                ", cupons=" + cupons +
                ", valorTotal=" + valorTotal +
                '}';
    }

    public CompraModel toModel(LivrosRepository repository) {
        var compra = new CompraModel();
        for (var item : itens) {
            var newItem = item.toModel(repository);
            compra.getItens().add(newItem);
            valorTotal = (BigDecimal.ZERO.add(newItem.getLivrosModel().getPreco()));
            BigDecimal total = CalculoLivro.calcular(newItem.getQuantidade(), valorTotal);
            compra.setValorTotal(total);
        }
        compra.getCupons().addAll(cupons);
        return compra;
    }
}
