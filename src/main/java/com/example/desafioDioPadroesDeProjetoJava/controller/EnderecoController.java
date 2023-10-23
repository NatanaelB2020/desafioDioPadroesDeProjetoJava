package com.example.desafioDioPadroesDeProjetoJava.controller;

import com.example.desafioDioPadroesDeProjetoJava.model.Endereco;
import com.example.desafioDioPadroesDeProjetoJava.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    private final EnderecoService enderecoService;

    @Autowired
    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping("/listar")
    public List<Endereco> listarEnderecos() {
        return enderecoService.listarEnderecos();
    }

    @GetMapping("/buscarporcep/{cep}")
    public Endereco buscarEnderecoPorCep(@PathVariable String cep) {
        return enderecoService.buscarEnderecoPorCep(cep);
    }

    @PostMapping("/criar")
    public Endereco criarEndereco(@RequestBody Endereco endereco) {
        return enderecoService.criarEndereco(endereco);
    }

    @PutMapping("/atualizar/{cep}")
    public Endereco atualizarEndereco(@PathVariable String cep, @RequestBody Endereco endereco) {
        return enderecoService.atualizarEndereco(cep, endereco);
    }

    @DeleteMapping("/delete/{cep}")
    public boolean deletarEndereco(@PathVariable String cep) {
        return enderecoService.deletarEndereco(cep);
    }
}
