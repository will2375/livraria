package com.livraria.livros.controller;

import com.livraria.livros.model.AutorModel;
import com.livraria.livros.model.autordto.AutorRequest;
import com.livraria.livros.model.autordto.AutorResponse;
import com.livraria.livros.model.autordto.factory.AutorModelFactory;
import com.livraria.livros.model.autordto.factory.AutorResponseFactory;
import com.livraria.livros.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorService service;

    @GetMapping
    public ResponseEntity<List<AutorResponse>> buscarTodos() { return ResponseEntity.ok(service.listaAutores());}

    @GetMapping("{id}")
    public ResponseEntity<Optional<AutorModel>> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorID(id));
    }

    @PostMapping
    public ResponseEntity<AutorResponse> cadastrar(@RequestBody @Valid AutorRequest request) {
        AutorModel model = AutorModelFactory.criar(request);
        service.cadastro(model);
        AutorResponse response = AutorResponseFactory.criar(model);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
