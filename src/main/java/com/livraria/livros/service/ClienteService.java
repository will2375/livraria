package com.livraria.livros.service;

import com.livraria.livros.exception.ValidacaoDeDuplicidade;
import com.livraria.livros.exception.ValidacaoDeID;
import com.livraria.livros.model.ClienteModel;
import com.livraria.livros.model.clientedto.ClienteResponse;
import com.livraria.livros.repository.ClienteRepository;
import com.livraria.livros.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repository;
    @Autowired
    EstadoRepository estadoRepository;


    public List<ClienteResponse> listaClientes() {

        Pageable pageable = PageRequest.of(0, 2);

        Page<ClienteModel> modelList = repository.findAll(pageable);
        return modelList.stream().map(model -> {
            return ClienteResponse.builder()
                    .id(model.getId()).nome(model.getNome()).sobrenome(model.getSobrenome())
                    .pais(model.getPais()).estado(model.getEstado()).cidade(model.getCidade())
                    .telefone(model.getTelefone()).email(model.getEmail()).build();
        }).collect(Collectors.toList());
    }

    public ClienteModel cadastrar(ClienteModel model) {

        var existeEmail = repository.findByEmail(model.getEmail());
        var existeCpf = repository.findByCpf(model.getCpf());

        if (existeCpf != null) {
            throw new ValidacaoDeDuplicidade("CPF ja cadastrado");
        } if (existeEmail != null) {
            throw new ValidacaoDeDuplicidade("EMAIL ja cadastrado");
        }

        return repository.save(model);
    }

    public ClienteModel buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new ValidacaoDeID("Cliente não encontrado"));
    }

}
