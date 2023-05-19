package com.livraria.livros.controller;

import com.livraria.livros.model.PaisModel;
import com.livraria.livros.model.paisdto.PaisRequest;
import com.livraria.livros.model.paisdto.PaisResponse;
import com.livraria.livros.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.validation.Valid;

@RestController
@RequestMapping("/pais")
@Transactional
public class PaisController {

    @Autowired
    private PaisService service;

    @Autowired
    private EntityManager entityManager;

    @GetMapping
    public Page<PaisModel> buscarTodos() {
        return service.buscarTodos();
    }

    @PostMapping("/cadastro")
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public PaisResponse cadastrar(@RequestBody @Valid PaisRequest request){
        PaisModel model = request.toModel();
        entityManager.persist(model);
        return new PaisResponse(model);
    }

    @GetMapping("{id}")
    public PaisModel buscarId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}
