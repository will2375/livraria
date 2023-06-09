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

        var existeTitulo = repository.findByTitulo(model.getTitulo());

        if (existeTitulo != null) {
            throw new ValidacaoDeDuplicidade("titulo ja cadastrado");
        } if (model.getPaginas() < 100) {
            throw new  ValidacaoDePaginas("O livro precisa ter no minimo 100 paginas");
        } if (model.getPreco()< 20) {
            throw new ValidacaoDePreco("O valor do livro não pode ser inferior a 20 reais");
        } if (model.getDataLancamento().isBefore(LocalDate.now())) {
            throw new ValidacaoDeLancamento("O lançamento não pode ser antes de hoje");
        } if (model.getAutor().getId().equals(null)){
            throw new ValidacaoCampoNulo("Autor não pode ser nulo");
        } if (model.getCategoria().getId().equals(null)) {
            throw new ValidacaoCampoNulo("Categoria não pode ser nula");
        }
        return repository.save(model);
    }

    public LivrosModel buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new ValidacaoDeID("Livro não encontrado"));
    }
}
