package com.livraria.livros.service;

import com.livraria.livros.exception.ValidacaoDeDuplicidade;
import com.livraria.livros.exception.ValidacaoDeID;
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

        var existeNome = repository.findyByNome(model.getNome());

        if (existeNome != null) {
            throw new ValidacaoDeDuplicidade("categonia ja cadastrada");
        }
        return repository.save(model);
    }

    public CategoriaModel buscarPorid(Long id){
        return repository.findById(id).orElseThrow(() -> new ValidacaoDeID("Categoria não encontrado"));
    }
}
