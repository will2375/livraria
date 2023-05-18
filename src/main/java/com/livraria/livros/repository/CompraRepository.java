package com.livraria.livros.repository;

import com.livraria.livros.model.CompraModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository extends JpaRepository<CompraModel, Long> {
}
