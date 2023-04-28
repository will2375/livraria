package com.livraria.livros.controller;

import com.livraria.livros.model.CategoriaModel;
import com.livraria.livros.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaService service;

    @GetMapping
    public ResponseEntity<List<CategoriaModel>> listarTodos() {return ResponseEntity.ok(service.listaCategoria());}

    @PostMapping
    public ResponseEntity<CategoriaModel> cadastrar(@RequestBody @Valid CategoriaModel model) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastar(model));
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<CategoriaModel>> buscarId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorid(id));
    }
}
