package com.livraria.livros.repository;

import com.livraria.livros.model.AutorModel;
import com.livraria.livros.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<AutorModel, Long> {
    AutorModel findByEmail(String email);
}
