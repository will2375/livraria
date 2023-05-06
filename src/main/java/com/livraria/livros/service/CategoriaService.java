package com.livraria.livros.service;

import com.livraria.livros.exception.ValidacaoDeDuplicidade;
import com.livraria.livros.exception.ValidacaoDeID;
import com.livraria.livros.model.CategoriaModel;
import com.livraria.livros.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repository;

    public Page<CategoriaModel> listaCategoria(){

        Pageable pageable = PageRequest.of(0, 5);

        return repository.findAll(pageable);
    }

    public CategoriaModel cadastar(CategoriaModel model) {

        var existeNome = repository.findByNome(model.getNome());

        if (existeNome != null) {
            throw new ValidacaoDeDuplicidade("categonia ja cadastrada");
        }
        return repository.save(model);
    }

    public CategoriaModel buscarPorid(Long id){
        return repository.findById(id).orElseThrow(() -> new ValidacaoDeID("Categoria não encontrado"));
    }
}
