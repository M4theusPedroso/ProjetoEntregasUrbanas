package br.com.senai.entregas.service;

import br.com.senai.entregas.model.TipoUsuario;
import br.com.senai.entregas.repository.TipoUsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //anotacao

public class TipoUsuarioService {

    //injecao de dependencia
    //service depende de alguem
    private final TipoUsuarioRepository tipoUsuarioRepository; //injecao de repositorio

    public TipoUsuarioService(TipoUsuarioRepository repo) {
        tipoUsuarioRepository = repo;
    }

    //listar todos uusuarios
    public List<TipoUsuario> listarTodos() {
        return tipoUsuarioRepository.findAll();
    }

    //cadastrar
    public TipoUsuario cadastrarUsuario(TipoUsuario usuario) {
        return tipoUsuarioRepository.save(usuario);
    }

    //buscar por id
    public TipoUsuario buscarPorId(Integer id) {
        return tipoUsuarioRepository.findById(id).orElse(null);
    }

    //deletar
    public TipoUsuario deletarTipoUsuario(Integer id) {
        //verificar se o usuario existe
        TipoUsuario usuario = buscarPorId(id);
        //se nao existir, retorna nulo
        if (usuario == null) {
            return null;
        }
        //se existir, excluo
        tipoUsuarioRepository.delete(usuario);
        return usuario;
    }

    //atualizar
    public TipoUsuario atualizarTipoUsuario(Integer id, TipoUsuario usuarioNovo) {
        //procurar quem eu quero atualizar
        TipoUsuario usuarioAntigo = buscarPorId(id);
        // se eu nao achar retorno nulo
        if (usuarioAntigo == null) {
            return null;
        }
        //se eu achar o usuario eu atualizo
        return tipoUsuarioRepository.save(usuarioAntigo);
    }

}