package com.livraria.livros.service;

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


        return repository.save(model);
    }

    public CupomModel buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("cupom não encontrado"));
    }
}
