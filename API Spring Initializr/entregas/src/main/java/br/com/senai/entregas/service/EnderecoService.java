package br.com.senai.entregas.service;

import br.com.senai.entregas.model.Endereco;
import br.com.senai.entregas.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class EnderecoService {
    private final EnderecoRepository enderecoRepository;
    public EnderecoService(EnderecoRepository endereco) {
        enderecoRepository = endereco;
    }

    //listar os enderecos
    public List<Endereco> listarTodos() {
        return enderecoRepository.findAll();
    }

    //cadastrar endereco
    public Endereco cadastroEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    //buscar por id
    public Endereco buscarPorId(Integer id) {
        return enderecoRepository.findById(id).orElse(null);
    }

    //deletar endereco
    public Endereco deleteEndereco(Integer id) {
       //1. verificar se o endereco existe
        Endereco endereco = buscarPorId(id);
        //2. se n existir, retorno nulo
        if (endereco == null) {
            return null;
        }
        //3. se existir excluo
        enderecoRepository.delete(endereco);
        return endereco;
    }

    //atualizar
}
