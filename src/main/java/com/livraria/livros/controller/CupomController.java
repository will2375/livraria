package com.livraria.livros.controller;

import com.livraria.livros.model.CupomModel;
import com.livraria.livros.model.cupomdto.CupomRequest;
import com.livraria.livros.model.cupomdto.CupomResponse;
import com.livraria.livros.service.CupomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.validation.Valid;

@RestController
@RequestMapping("/cupom")
public class CupomController {

    @Autowired
    CupomService service;

    @Autowired
    private EntityManager entityManager;

    @GetMapping
    public Page<CupomModel> listaCupom() {
        return service.listarCupons();
    }

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public CupomResponse cadastrar(@RequestBody @Valid CupomRequest request){
        CupomModel model = request.toModel();
        entityManager.persist(model);
        return new CupomResponse(model);
    }
    @GetMapping("{id}")
    public CupomModel buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}
