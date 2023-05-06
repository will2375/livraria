package com.livraria.livros.controller;

import com.livraria.livros.model.CategoriaModel;
import com.livraria.livros.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaService service;

    @GetMapping
    public ResponseEntity<Page<CategoriaModel>> listarTodos() {return ResponseEntity.ok(service.listaCategoria());}

    @PostMapping
    public ResponseEntity<CategoriaModel> cadastrar(@RequestBody @Valid CategoriaModel model) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastar(model));
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoriaModel> buscarId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorid(id));
    }
}
