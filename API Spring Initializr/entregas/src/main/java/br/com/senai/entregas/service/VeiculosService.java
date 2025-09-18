package br.com.senai.entregas.service;

import br.com.senai.entregas.model.Veiculos;
import br.com.senai.entregas.repository.VeiculosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

//anotacao
@Service

public class VeiculosService {
    //injecao de dependencia, service depende de alguem
    private final VeiculosRepository veiculosRepository;

    public VeiculosService(VeiculosRepository veiculos) {
        veiculosRepository = veiculos;
    }

    //listar todos os veiculos
    public List<Veiculos> listarTodos() {
        return veiculosRepository.findAll();
    }

    //cadastrar veiculo
    public Veiculos cadastrarVeiculos(Veiculos veiculos) {
        return veiculosRepository.save(veiculos);
    }

    //buscar por id
    public Veiculos buscarPorId(Integer id) {
        return veiculosRepository.findById(id).orElse(null);
    }

    //deletar veiculo
    public Veiculos deletarVeiculos(Integer id) {
        //1. verificar se o cliente existe
        Veiculos veiculos = buscarPorId(id);
        //2. se nao existir, retorno nulo
        veiculosRepository.delete(veiculos);
        return veiculos;
    }

    //atualizar
    public Veiculos atualizarVeiculos(Integer id, Veiculos veiculosNovo) {
        //1. procurar quem eu quero atualizar
        Veiculos veiculosAntigo = buscarPorId(id);
        //2. se eu nao achar, retorno nulo
        if (veiculosAntigo == null) {
            return null;
        }
        //3. se eu achar o cliente eu atualizo
        veiculosAntigo.setModelo(veiculosNovo.getModelo());
        veiculosAntigo.setTipo(veiculosNovo.getTipo());
        veiculosAntigo.setPlaca(veiculosNovo.getPlaca());
        veiculosAntigo.setUsuario(veiculosNovo.getUsuario());
        return veiculosRepository.save(veiculosAntigo);
    }
}
