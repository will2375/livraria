package com.livraria.livros.controller;

import com.livraria.livros.model.LivrosModel;
import com.livraria.livros.model.livrosdto.LivrosRequest;
import com.livraria.livros.model.livrosdto.LivrosResponse;
import com.livraria.livros.service.LivrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivrosController {

    @Autowired
    LivrosService service;

    @Autowired
    EntityManager entityManager;


    @GetMapping
    public ResponseEntity<Page<LivrosModel>> listarLivros() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    @PostMapping
    @ResponseBody
    @Transactional
    public LivrosResponse executar( @RequestBody @Valid LivrosRequest request) {
        LivrosModel model = request.toModel(entityManager);
        entityManager.persist(model);

        return new LivrosResponse(model);
    }

    @GetMapping("{id}")
    public LivrosModel buscarId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}
