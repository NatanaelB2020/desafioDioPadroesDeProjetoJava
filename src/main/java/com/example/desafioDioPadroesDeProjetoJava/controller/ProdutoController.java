package com.example.desafioDioPadroesDeProjetoJava.controller;

import com.example.desafioDioPadroesDeProjetoJava.model.Produto;
import com.example.desafioDioPadroesDeProjetoJava.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/listar")
    public List<Produto> listarProdutos() {
        return produtoService.listarProdutos();
    }

    @GetMapping("/listarporid/{id}")
    public Produto buscarProdutoPorId(@PathVariable int id) {
        return produtoService.buscarProdutoPorId(id);
    }

    @PostMapping("/criar")
    public Produto criarProduto(@RequestBody Produto produto) {
        return produtoService.criarProduto(produto);
    }

    @PutMapping("/ataulizar/{id}")
    public Produto atualizarProduto(@PathVariable int id, @RequestBody Produto produto) {
        return produtoService.atualizarProduto(id, produto);
    }

    @DeleteMapping("/deletar/{id}")
    public boolean deletarProduto(@PathVariable int id) {
        return produtoService.deletarProduto(id);
    }
}