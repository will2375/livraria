package com.livraria.livros.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidacaoDeLancamento extends RuntimeException{
    public ValidacaoDeLancamento(String message) {
        super(message);
    }
}
