package com.livraria.livros.service;

import com.livraria.livros.exception.ValidacaoDeDuplicidade;
import com.livraria.livros.exception.ValidacaoDeID;
import com.livraria.livros.exception.ValidacaoDeValidade;
import com.livraria.livros.model.CupomModel;
import com.livraria.livros.repository.CupomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CupomService {

    @Autowired
    CupomRepository repository;

    public Page<CupomModel> listarCupons() {

        Pageable pageable = PageRequest.of(0, 2);

        return repository.findAll(pageable);
    }

    public CupomModel cadastrar(CupomModel model) {

        var existeCupom = repository.findByCodigo(model.getCodigo());


        if (existeCupom != null){
            throw new ValidacaoDeDuplicidade("codigo ja cadastrado");
        } if (model.getValidade().isBefore(LocalDate.now())) {
            throw new ValidacaoDeValidade("cupom deve vençer em data futura");
        }
        return repository.save(model);
    }

    public CupomModel buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new ValidacaoDeID("cupom não encontrado"));
    }
}
