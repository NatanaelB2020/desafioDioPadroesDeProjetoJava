package com.example.desafioDioPadroesDeProjetoJava.service;

import com.example.desafioDioPadroesDeProjetoJava.model.Produto;
import com.example.desafioDioPadroesDeProjetoJava.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto buscarProdutoPorId(int id) {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        return produtoOptional.orElse(null);
    }

    public Produto criarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto atualizarProduto(int id, Produto produto) {
        Optional<Produto> produtoExistente = produtoRepository.findById(id);
        if (produtoExistente.isPresent()) {
            Produto produtoAtualizado = produtoExistente.get();
            produtoAtualizado.setNome(produto.getNome());
            produtoAtualizado.setPreco(produto.getPreco());

            return produtoRepository.save(produtoAtualizado);
        } else {
            return null;
        }
    }

    public boolean deletarProduto(int id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
