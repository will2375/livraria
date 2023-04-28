package com.livraria.livros.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidacaoDePaginas extends RuntimeException{
    public ValidacaoDePaginas(String message) {
        super(message);
    }
}
