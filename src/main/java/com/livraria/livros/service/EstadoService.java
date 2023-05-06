package com.livraria.livros.service;

import com.livraria.livros.exception.ValidacaoCampoNulo;
import com.livraria.livros.exception.ValidacaoDeDuplicidade;
import com.livraria.livros.exception.ValidacaoDeID;
import com.livraria.livros.model.EstadoModel;
import com.livraria.livros.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {

    @Autowired
    EstadoRepository repository;

    public Page<EstadoModel> buscarTodos() {

        Pageable pageable = PageRequest.of(0, 2);

        return repository.findAll(pageable);
    }

    public EstadoModel cadastrar(EstadoModel model) {

        var existeNome = repository.findByNome(model.getNome());

        if (existeNome != null) {
            throw new ValidacaoDeDuplicidade("nome ja cadastrado");
        } if (model.getPais().getId().equals(null)) {
            throw new ValidacaoCampoNulo("Pais não pode ser nulo");
        }
        return repository.save(model);
    }

    public EstadoModel buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new ValidacaoDeID("Estado não encontrado"));
    }
}
