package com.livraria.livros.repository;

import com.livraria.livros.model.EstadoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<EstadoModel, Long> {

    EstadoModel findByNome(String nome);
}
