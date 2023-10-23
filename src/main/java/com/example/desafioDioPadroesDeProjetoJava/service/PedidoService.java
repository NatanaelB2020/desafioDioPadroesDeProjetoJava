package com.example.desafioDioPadroesDeProjetoJava.service;


import com.example.desafioDioPadroesDeProjetoJava.execoesPersonalizada.ClienteNaoEncontradoException;
import com.example.desafioDioPadroesDeProjetoJava.model.Cliente;
import com.example.desafioDioPadroesDeProjetoJava.model.Pedido;
import com.example.desafioDioPadroesDeProjetoJava.model.Produto;
import com.example.desafioDioPadroesDeProjetoJava.repository.PedidoRepository;
import com.example.desafioDioPadroesDeProjetoJava.util.PedidoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteService clienteService;
    private final EnderecoService enderecoService;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository, ClienteService clienteService, EnderecoService enderecoService) {
        this.pedidoRepository = pedidoRepository;
        this.clienteService = clienteService;
        this.enderecoService = enderecoService;
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido criarPedido(PedidoRequest pedidoRequest, String nomeCliente) {
        List<Produto> produtos = pedidoRequest.getProdutos();

        // Chame o serviço do cliente para buscar o cliente pelo nome
        Cliente clienteExistente = clienteService.buscarClientePorNome(nomeCliente);

        // Verifica se o cliente foi encontrado
        if (clienteExistente == null) {
            throw new ClienteNaoEncontradoException();
        }

        Pedido pedido = new Pedido();
        pedido.setCliente(clienteExistente);
        pedido.setProdutos(produtos);

        return pedidoRepository.save(pedido);
    }
}
