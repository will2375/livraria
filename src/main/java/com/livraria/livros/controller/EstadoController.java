package com.livraria.livros.controller;

import com.livraria.livros.model.EstadoModel;
import com.livraria.livros.model.estadodto.EstadoRequest;
import com.livraria.livros.model.estadodto.EstadoResponse;
import com.livraria.livros.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    @Autowired
    EstadoService service;

    @Autowired
    EntityManager entityManager;

    @GetMapping
    public Page<EstadoModel> buscarTodos() {
        return service.buscarTodos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public EstadoResponse executar (@RequestBody @Valid EstadoRequest request){
        EstadoModel model = request.toModel(entityManager);
        entityManager.persist(model);
        return new EstadoResponse(model);
    }
    @GetMapping("{id}")
    public EstadoModel buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}
