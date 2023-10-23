package com.example.desafioDioPadroesDeProjetoJava.service;

import com.example.desafioDioPadroesDeProjetoJava.model.Endereco;
import com.example.desafioDioPadroesDeProjetoJava.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    @Autowired
    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public List<Endereco> listarEnderecos() {
        return enderecoRepository.findAll();
    }

    public Endereco buscarEnderecoPorCep(String cep) {
        Optional<Endereco> enderecoOptional = enderecoRepository.findById(cep);
        return enderecoOptional.orElse(null);
    }

    public Endereco criarEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Endereco atualizarEndereco(String cep, Endereco endereco) {
        Optional<Endereco> enderecoExistente = enderecoRepository.findById(cep);
        if (enderecoExistente.isPresent()) {
            Endereco enderecoAtualizado = enderecoExistente.get();
            enderecoAtualizado.setLogradouro(endereco.getLogradouro());
            enderecoAtualizado.setComplemento(endereco.getComplemento());
            enderecoAtualizado.setBairro(endereco.getBairro());
            enderecoAtualizado.setLocalidade(endereco.getLocalidade());
            enderecoAtualizado.setUf(endereco.getUf());

            return enderecoRepository.save(enderecoAtualizado);
        } else {
            return null;
        }
    }

    public boolean deletarEndereco(String cep) {
        if (enderecoRepository.existsById(cep)) {
            enderecoRepository.deleteById(cep);
            return true;
        } else {
            return false;
        }
    }
}
