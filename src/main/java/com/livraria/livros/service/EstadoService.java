package com.livraria.livros.service;

import com.livraria.livros.exception.ValidacaoCampoNulo;
import com.livraria.livros.exception.ValidacaoDeID;
import com.livraria.livros.model.EstadoModel;
import com.livraria.livros.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {

    @Autowired
    EstadoRepository repository;

    public List<EstadoModel> buscarTodos() {
        return repository.findAll();
    }

    public EstadoModel cadastrar(EstadoModel model) {
        if (model.getPais().getId().equals(null)) {
            throw new ValidacaoCampoNulo("Pais não pode ser nulo");
        }
        return repository.save(model);
    }

    public EstadoModel buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new ValidacaoDeID("Estado não encontrado"));
    }
}
