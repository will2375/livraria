package com.livraria.livros.controller;

import com.livraria.livros.model.CompraModel;
import com.livraria.livros.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    CompraService service;

    @GetMapping
    public ResponseEntity<Page<CompraModel>> listaCompras() {
        return ResponseEntity.ok().body(service.listaCompra());
    }

    @PostMapping
    public ResponseEntity<CompraModel> registrarCompra(@RequestBody CompraModel model) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(model));
    }

    @GetMapping("{id}")
    public ResponseEntity<CompraModel> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarId(id));
    }
}
