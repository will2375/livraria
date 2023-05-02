package com.livraria.livros.service;

import com.livraria.livros.exception.ValidacaoDeDuplicidade;
import com.livraria.livros.exception.ValidacaoDeID;
import com.livraria.livros.exception.ValidacaoDeValidade;
import com.livraria.livros.model.CupomModel;
import com.livraria.livros.repository.CupomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CupomService {

    @Autowired
    CupomRepository repository;

    public List<CupomModel> listarCupons() {
        return repository.findAll();
    }

    public CupomModel cadastrar(CupomModel model) {

        var existeCupom = repository.findyByCodigo(model.getCodigo());


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
