package com.example.desafioDioPadroesDeProjetoJava.execoesPersonalizada;

public class EnderecoNaoEncontradoException extends RuntimeException {
    public EnderecoNaoEncontradoException(String cep) {
        super("Endereço não encontrado para o CEP: " + cep);
    }
}

