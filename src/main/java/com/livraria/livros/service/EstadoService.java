package com.livraria.livros.service;

import com.livraria.livros.model.EstadoModel;
import com.livraria.livros.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EstadoService {

    @Autowired
    EstadoRepository repository;

    public Page<EstadoModel> buscarTodos() {

        Pageable pageable = PageRequest.of(0, 2);

        return repository.findAll(pageable);
    }

    public EstadoModel cadastrar(EstadoModel model) {

        return repository.save(model);
    }

    public EstadoModel buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Estado não encontrado"));
    }
}
