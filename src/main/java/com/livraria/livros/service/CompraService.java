package com.livraria.livros.service;

import com.livraria.livros.exception.ValidacaoDeCupom;
import com.livraria.livros.exception.ValidacaoDeID;
import com.livraria.livros.exception.ValidacaoDeQuantidade;
import com.livraria.livros.model.CompraModel;
import com.livraria.livros.model.CupomModel;
import com.livraria.livros.repository.CompraRepository;
import com.livraria.livros.repository.CupomRepository;
import com.livraria.livros.service.calculo.CalcularPreco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CompraService {

    @Autowired
    CompraRepository repository;

    @Autowired
    CupomRepository cupomRepository;

    CalcularPreco calcularPreco;

    CupomModel cupomModel;

    public Page<CompraModel> listaCompra() {

        Pageable pageable = PageRequest.of(0, 2);

        return repository.findAll(pageable);
    }

    public CompraModel cadastrar(CompraModel model) {

        var cupomUsado = repository.findByCupom(model.getCupom());

        if(model.getQuantidade() < 1) {
            throw new ValidacaoDeQuantidade("Quantidade de livro deve ser 1 ou maior");
        } if(cupomUsado != null) {
            throw new ValidacaoDeCupom("Cupom ja utilizado");
        }



        return repository.save(model);
    }

    public CompraModel buscarId(Long id) {
        return repository.findById(id).orElseThrow(() -> new ValidacaoDeID("Id não encontrado"));
    }
}
