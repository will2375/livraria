package com.livraria.livros.service;

import com.livraria.livros.exception.ValidacaoDeDuplicidade;
import com.livraria.livros.exception.ValidacaoDeID;
import com.livraria.livros.model.PaisModel;
import com.livraria.livros.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisService {

    @Autowired
    PaisRepository repository;

    public List<PaisModel> buscarTodos() {
        return repository.findAll();
    }

    public PaisModel cadasatrar(PaisModel model) {

        var existePais = repository.findByNome(model.getNome());

        if( existePais != null) {
            throw new ValidacaoDeDuplicidade("Pais ja cadastrado");
        }

        return repository.save(model);
    }

    public PaisModel buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new ValidacaoDeID("Pais não encontrado"));
    }
}
