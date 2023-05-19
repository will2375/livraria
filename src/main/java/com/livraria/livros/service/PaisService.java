package com.livraria.livros.service;

import com.livraria.livros.model.PaisModel;
import com.livraria.livros.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PaisService {

    @Autowired
    PaisRepository repository;

    public Page<PaisModel> buscarTodos() {

        Pageable pageable = PageRequest.of(0, 2);

        return repository.findAll(pageable);
    }

    public PaisModel buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Pais não encontrado"));
    }
}
