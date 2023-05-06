package com.livraria.livros.repository;

import com.livraria.livros.model.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {

    CategoriaModel findByNome(String nome);
}
