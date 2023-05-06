package com.livraria.livros.controller;

import com.livraria.livros.model.CupomModel;
import com.livraria.livros.service.CupomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cupom")
public class CupomController {

    @Autowired
    CupomService service;

    @GetMapping
    public Page<CupomModel> listaCupom() {
        return service.listarCupons();
    }

    @PostMapping
    public CupomModel cadastrar(@RequestBody CupomModel model) {
        return service.cadastrar(model);
    }

    @GetMapping("{id}")
    public CupomModel buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}
