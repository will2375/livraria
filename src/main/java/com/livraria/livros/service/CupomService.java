package com.livraria.livros.service;

import com.livraria.livros.model.CupomModel;
import com.livraria.livros.repository.CupomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CupomService {

    @Autowired
    CupomRepository repository;

    public List<CupomModel> listarCupons() {
        return repository.findAll();
    }

    public CupomModel cadastrar(CupomModel model) {
        return repository.save(model);
    }

    public CupomModel buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("cupom não encontrado"));
    }
}
