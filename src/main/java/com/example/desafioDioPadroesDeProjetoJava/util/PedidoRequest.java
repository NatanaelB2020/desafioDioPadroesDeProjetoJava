package com.example.desafioDioPadroesDeProjetoJava.util;

import com.example.desafioDioPadroesDeProjetoJava.model.Cliente;
import com.example.desafioDioPadroesDeProjetoJava.model.Produto;

import java.util.List;

public class PedidoRequest {
    private Cliente cliente;
    private List<Produto> produtos;

    public PedidoRequest() {
    }

    public PedidoRequest(Cliente cliente, List<Produto> produtos) {
        this.cliente = cliente;
        this.produtos = produtos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
