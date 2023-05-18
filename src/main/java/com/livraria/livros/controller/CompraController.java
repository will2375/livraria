package com.livraria.livros.controller;

import com.livraria.livros.model.CompraModel;
import com.livraria.livros.repository.CompraRepository;
import com.livraria.livros.repository.LivrosRepository;
import com.livraria.livros.service.compra.NovaCompra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private LivrosRepository livrosRepository;

    @ResponseBody
    @Transactional
    @PostMapping
    public CompraModel novaCompra
            (@RequestBody @Valid
             NovaCompra novaCompra) {
        CompraModel model = novaCompra.toModel(livrosRepository);
        compraRepository.save(model);
        return model;
    }

}