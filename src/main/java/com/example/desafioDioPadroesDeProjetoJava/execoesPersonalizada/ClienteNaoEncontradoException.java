package com.example.desafioDioPadroesDeProjetoJava.execoesPersonalizada;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClienteNaoEncontradoException extends RuntimeException {

    public ClienteNaoEncontradoException() {
        super("Cliente não encontrado");
    }

    public ClienteNaoEncontradoException(String message) {
        super(message);
    }
}
