package com.livraria.livros.controller;

import com.livraria.livros.model.PaisModel;
import com.livraria.livros.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pais")
public class PaisController {

    @Autowired
    PaisService service;

    @GetMapping
    public Page<PaisModel> buscarTodos() {
        return service.buscarTodos();
    }

    @PostMapping
    public PaisModel cadastrar(@RequestBody PaisModel model) {
        return service.cadasatrar(model);
    }

    @GetMapping("{id}")
    public PaisModel buscarId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}
