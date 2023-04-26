package com.livraria.livros.service;

import com.livraria.livros.model.AutorModel;
import com.livraria.livros.model.autordto.AutorResponse;
import com.livraria.livros.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AutorService {

    @Autowired
    AutorRepository repository;

    public List<AutorResponse> listaAutores() {
        List<AutorModel> modelList = repository.findAll();
        return modelList.stream().map(model -> {
            return AutorResponse.builder()
                    .nome(model.getNome()).descricao(model.getDescricao()).build();
        }).collect(Collectors.toList());
    }

    public AutorModel cadastro(AutorModel model) {

        model.setDataCadastro(LocalDateTime.now());
       return repository.save(model);
    }

    public Optional<AutorModel> buscarPorID(Long id) {
        return repository.findById(id);
    }

}