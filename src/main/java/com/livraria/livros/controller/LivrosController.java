package com.livraria.livros.controller;

import com.livraria.livros.model.LivrosModel;
import com.livraria.livros.service.LivrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivrosController {

    @Autowired
    LivrosService service;


    @GetMapping
    public ResponseEntity<Page<LivrosModel>> listarLivros() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<LivrosModel> cadastrar(@RequestBody @Valid LivrosModel model){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastro(model));
    }

    @GetMapping("{id}")
    public LivrosModel buscarId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}
