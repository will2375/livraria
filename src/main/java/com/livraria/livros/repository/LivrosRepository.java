package com.livraria.livros.repository;

import com.livraria.livros.model.LivrosModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivrosRepository extends JpaRepository<LivrosModel, Long> {
}
