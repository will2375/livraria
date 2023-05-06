package com.livraria.livros.service;

import com.livraria.livros.exception.ValidacaoDeDuplicidade;
import com.livraria.livros.exception.ValidacaoDeID;
import com.livraria.livros.model.AutorModel;
import com.livraria.livros.model.autordto.AutorResponse;
import com.livraria.livros.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

        Pageable pageable = PageRequest.of(0, 2);

        Page<AutorModel> modelList = repository.findAll(pageable);
        return modelList.stream().map(model -> {
            return AutorResponse.builder()
                    .nome(model.getNome()).descricao(model.getDescricao()).build();
        }).collect(Collectors.toList());
    }

    public AutorModel cadastro(AutorModel model) {

        var existeEmail = repository.findByEmail(model.getEmail());

        if (existeEmail != null) {
            throw new ValidacaoDeDuplicidade("EMAIL ja cadastrado");
        }

        model.setDataCadastro(LocalDateTime.now());
       return repository.save(model);
    }

    public AutorModel buscarPorID(Long id) {
        return repository.findById(id).orElseThrow(() -> new ValidacaoDeID("Autor não encontrado"));
    }

}