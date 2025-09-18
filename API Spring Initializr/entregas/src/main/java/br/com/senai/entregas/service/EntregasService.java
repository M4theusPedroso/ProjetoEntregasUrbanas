package br.com.senai.entregas.service;

import br.com.senai.entregas.model.Entregas;
import br.com.senai.entregas.model.Veiculos;
import br.com.senai.entregas.repository.EntregasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class EntregasService {
    private final EntregasRepository entregasRepository;

    public EntregasService(EntregasRepository entregas) {
        entregasRepository = entregas;
    }

    //listar entregas
    public List<Entregas> listarTodos() {
        return entregasRepository.findAll();
    }

    //cadastrar entrega
    public Entregas cadastrarEntregas(Entregas entregas) {
        return entregasRepository.save(entregas);
    }

    //buscar por id
    public Entregas bucarPorId(Integer id) {
        return entregasRepository.findById(id).orElse(null);
    }

    //deletar entrega
    public Entregas deletarEntregas(Integer id) {
        //1. verificar se o cliente existe
        Entregas entregas = bucarPorId(id);
        //2. se nao existir, retorno nulo
        if (entregas == null) {
            return null;
        }
        //3. se existir excluo
        entregasRepository.delete(entregas);
        return entregas;
    }

    //atualizar
    public Entregas atualizarEntregas(Integer id, Entregas entregasNovo) {
        //1. procurar quem eu quero att
        Entregas entregasAntigo = bucarPorId(id);
        //2. se eu nao achar excluo
        if (entregasAntigo == null) {
            return null;
        }
        //3. se eu achar, atualizo
        entregasAntigo.setEndereco(entregasNovo.getEndereco());
        entregasAntigo.setDataPedido(entregasNovo.getDataPedido());
        entregasAntigo.setStatus(entregasNovo.getStatus());
        entregasAntigo.setUsuario(entregasNovo.getUsuario());
        entregasAntigo.setDescricaoproduto(entregasNovo.getDescricaoproduto());
        return entregasRepository.save(entregasAntigo);
    }
}
