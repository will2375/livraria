package com.livraria.livros.controller;

import com.livraria.livros.model.EstadoModel;
import com.livraria.livros.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    @Autowired
    EstadoService service;

    @GetMapping
    public Page<EstadoModel> buscarTodos() {
        return service.buscarTodos();
    }

    @PostMapping
    public EstadoModel cadastrar(@RequestBody EstadoModel model) {
        return service.cadastrar(model);
    }

    @GetMapping("{id}")
    public EstadoModel buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}
