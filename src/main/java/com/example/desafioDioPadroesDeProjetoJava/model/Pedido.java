package com.example.desafioDioPadroesDeProjetoJava.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use GenerationType.IDENTITY para autoincremento
    private int id;

    @OneToOne
    private Cliente cliente;

    @OneToOne
    private Endereco endereco;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Produto> produtos;

    private double valorTotal;

    public Pedido() {
    }

    public Pedido(Cliente cliente, Endereco endereco, List<Produto> produtos) {
        this.cliente = cliente;
        this.endereco = endereco;
        this.produtos = produtos;
        calcularValorTotal();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
        calcularValorTotal();
    }

    public double getValorTotal() {
        return valorTotal;
    }

    private void calcularValorTotal() {
        if (produtos != null) {
            valorTotal = produtos.stream()
                    .mapToDouble(Produto::getPreco)
                    .sum();
        } else {
            valorTotal = 0.0;
        }
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", endereco=" + endereco +
                ", produtos=" + produtos +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
