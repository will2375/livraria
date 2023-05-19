package com.livraria.livros.exception;

import lombok.Data;

@Data
public class FieldError {

    private String field;
    private String message;

    public FieldError(String field, String errorMessage) {
        this.field = field;
        this.message = errorMessage;
    }
}
