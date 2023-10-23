package com.example.desafioDioPadroesDeProjetoJava.controller;

import com.example.desafioDioPadroesDeProjetoJava.execoesPersonalizada.EnderecoNaoEncontradoException;
import com.example.desafioDioPadroesDeProjetoJava.model.Cliente;
import com.example.desafioDioPadroesDeProjetoJava.service.ClienteService;
import com.example.desafioDioPadroesDeProjetoJava.util.ClienteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/listar")
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    @GetMapping("/listarpoid/{id}")
    public Cliente buscarClientePorId(@PathVariable int id) {
        return clienteService.buscarClientePorId(id);
    }

    @PostMapping("/criar")
    public ResponseEntity<Cliente> criarCliente(@RequestBody ClienteRequest clienteRequest) {
        try {
            Cliente novoCliente = clienteService.criarCliente(clienteRequest);
            return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
        } catch (EnderecoNaoEncontradoException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/atualizar/{id}")
    public Cliente atualizarCliente(@PathVariable int id, @RequestBody Cliente cliente) {
        return clienteService.atualizarCliente(id, cliente);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deletarCliente(@PathVariable int id) {
        return clienteService.deletarCliente(id);
    }
}