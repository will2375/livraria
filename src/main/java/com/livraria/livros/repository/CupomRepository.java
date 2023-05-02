package com.livraria.livros.repository;

import com.livraria.livros.model.CupomModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CupomRepository extends JpaRepository<CupomModel, Long> {

    CupomModel findyByCodigo(String codigo);
}
