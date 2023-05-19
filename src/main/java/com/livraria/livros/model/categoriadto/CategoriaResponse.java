package com.livraria.livros.model.categoriadto;

import com.livraria.livros.model.CategoriaModel;
import lombok.Getter;

@Getter
public class CategoriaResponse {

    private Long categoriaId;

    public CategoriaResponse(CategoriaModel model) {this.categoriaId = model.getId();}
}
