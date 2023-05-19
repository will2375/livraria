package com.livraria.livros.controller;

import com.livraria.livros.model.CategoriaModel;
import com.livraria.livros.model.categoriadto.CategoriaRequest;
import com.livraria.livros.model.categoriadto.CategoriaResponse;
import com.livraria.livros.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaService service;

    @Autowired
    EntityManager entityManager;

    @GetMapping
    public ResponseEntity<Page<CategoriaModel>> listarTodos() {return ResponseEntity.ok(service.listaCategoria());}

    @PostMapping
    @Transactional
    @ResponseBody
    public CategoriaResponse execute(@RequestBody @Valid CategoriaRequest request){
        CategoriaModel model = request.toModel();
        entityManager.persist(model);

        return new CategoriaResponse(model);
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoriaModel> buscarId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorid(id));
    }
}
