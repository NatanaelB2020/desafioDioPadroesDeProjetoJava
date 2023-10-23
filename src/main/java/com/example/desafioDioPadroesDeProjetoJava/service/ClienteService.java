package com.example.desafioDioPadroesDeProjetoJava.service;

import com.example.desafioDioPadroesDeProjetoJava.execoesPersonalizada.EnderecoNaoEncontradoException;
import com.example.desafioDioPadroesDeProjetoJava.model.Cliente;
import com.example.desafioDioPadroesDeProjetoJava.model.Endereco;
import com.example.desafioDioPadroesDeProjetoJava.repository.ClienteRepository;
import com.example.desafioDioPadroesDeProjetoJava.util.ClienteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    private final EnderecoService enderecoService;



    @Autowired
    public ClienteService(ClienteRepository clienteRepository, EnderecoService enderecoService, ProdutoService produtoService) {
        this.clienteRepository = clienteRepository;
        this.enderecoService = enderecoService;

    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente buscarClientePorNome(String nome) {
        return clienteRepository.findByNome(nome);
    }

    public Cliente buscarClientePorId(int id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        return clienteOptional.orElse(null);
    }

    public Cliente criarCliente(ClienteRequest clienteRequest) {
        String cep = clienteRequest.getCep();
        Endereco endereco = enderecoService.buscarEnderecoPorCep(cep);

        if (endereco == null) {
            throw new EnderecoNaoEncontradoException(cep);
        }

        Cliente cliente = new Cliente();
        cliente.setNome(clienteRequest.getNome());
        cliente.setEndereco(endereco);

        return clienteRepository.save(cliente);
    }


    public Cliente atualizarCliente(int id, Cliente cliente) {
        Optional<Cliente> clienteExistente = clienteRepository.findById(id);
        if (clienteExistente.isPresent()) {
            Cliente clienteAtualizado = clienteExistente.get();
            clienteAtualizado.setNome(cliente.getNome());

            return clienteRepository.save(clienteAtualizado);
        } else {
            return null;
        }
    }

    public boolean deletarCliente(int id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
