package com.livraria.livros.service;

import com.livraria.livros.model.CategoriaModel;
import com.livraria.livros.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repository;

    public List<CategoriaModel> listaCategoria(){
        return repository.findAll();
    }

    public CategoriaModel cadastar(CategoriaModel model) {
        return repository.save(model);
    }

    public Optional<CategoriaModel> buscarPorid(Long id){
        return repository.findById(id);
    }
}
