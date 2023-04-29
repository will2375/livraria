package com.livraria.livros.controller;

import com.livraria.livros.model.ClienteModel;
import com.livraria.livros.model.clientedto.ClienteRequest;
import com.livraria.livros.model.clientedto.ClienteResponse;
import com.livraria.livros.model.clientedto.factory.ClienteRequestFactory;
import com.livraria.livros.model.clientedto.factory.ClienteResponseFactory;
import com.livraria.livros.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    ClienteService service;

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> buscarTodos() {
        return ResponseEntity.ok(service.listaClientes());
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> cadastrar(@RequestBody @Valid ClienteRequest request) {
        ClienteModel model = ClienteRequestFactory.criar(request);
        service.cadastrar(model);
        ClienteResponse response = ClienteResponseFactory.criar(model);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<ClienteModel> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }
}
