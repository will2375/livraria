package com.livraria.livros.repository;

import com.livraria.livros.model.PaisModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisRepository extends JpaRepository<PaisModel, Long> {

    PaisModel findByNome(String nome);
}
