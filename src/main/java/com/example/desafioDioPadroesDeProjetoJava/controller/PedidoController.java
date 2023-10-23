package com.example.desafioDioPadroesDeProjetoJava.controller;

import com.example.desafioDioPadroesDeProjetoJava.execoesPersonalizada.ClienteNaoEncontradoException;
import com.example.desafioDioPadroesDeProjetoJava.model.Cliente;
import com.example.desafioDioPadroesDeProjetoJava.model.Pedido;
import com.example.desafioDioPadroesDeProjetoJava.model.Produto;
import com.example.desafioDioPadroesDeProjetoJava.repository.PedidoRepository;
import com.example.desafioDioPadroesDeProjetoJava.service.ClienteService;
import com.example.desafioDioPadroesDeProjetoJava.service.PedidoService;
import com.example.desafioDioPadroesDeProjetoJava.util.PedidoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    private final ClienteService clienteService;

    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoController(PedidoService pedidoService, ClienteService clienteService, PedidoRepository pedidoRepository) {
        this.pedidoService = pedidoService;
        this.clienteService = clienteService;
        this.pedidoRepository = pedidoRepository;
    }

    @GetMapping("/listar")
    public List<Pedido> listarPedidos() {
        return pedidoService.listarPedidos();
    }

    @PostMapping("/criar")
    public Pedido criarPedido(@RequestBody PedidoRequest pedidoRequest) {
        String nomeCliente = pedidoRequest.getCliente().getNome();
        List<Produto> produtos = pedidoRequest.getProdutos();

        // Chame o serviço de pedido para criar o pedido
        return pedidoService.criarPedido(pedidoRequest, nomeCliente);
    }

}
