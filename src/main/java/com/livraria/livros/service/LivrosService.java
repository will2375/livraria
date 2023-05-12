package com.livraria.livros.service;

import com.livraria.livros.exception.*;
import com.livraria.livros.model.LivrosModel;
import com.livraria.livros.repository.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LivrosService {

    @Autowired
    LivrosRepository repository;

    public Page<LivrosModel> buscarTodos() {

        Pageable pageable = PageRequest.of(0, 2);

        return repository.findAll(pageable);
    }

    public LivrosModel cadastro(LivrosModel model) {

        return repository.save(model);
    }

    public LivrosModel buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
    }
}
