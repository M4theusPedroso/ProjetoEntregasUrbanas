package br.com.senai.entregas.service;

import br.com.senai.entregas.model.Usuario;
import br.com.senai.entregas.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UsuarioService {
    //injecao de dependencia
    //service depende de alguem
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuario) {
        usuarioRepository = usuario;
    }

    //listar os usuarios
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    //cadastrar usuario
    public Usuario cadastrarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    //buscar por id
    public Usuario buscarPorId(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    //deletar usuario
    public Usuario deletarUsuario(Integer id) {
        //1 verificar se existe
        Usuario usuario = buscarPorId(id);
        //2 se n existir, retorno nulo
        if (usuario == null) {
            return null;
        }
        //3 se existir, excluo
        usuarioRepository.delete(usuario);
        return usuario;
    }
    //ATUALIZAR
    public Usuario atualizarUsuario(Integer id, Usuario usuarioNovo) {
        //1. procurar quem eu quero atualizar
        Usuario usuarioAntigo = buscarPorId(id);
        //2. se eu nao achar, retorno nulo
        if  (usuarioAntigo == null) {
            return null;
        }
        //3. se eu achar o cliente eu atualizo
        usuarioAntigo.setTipoUsuario(usuarioNovo.getTipoUsuario());
        usuarioAntigo.setEmail(usuarioNovo.getEmail());
        usuarioAntigo.setSenha(usuarioNovo.getSenha());
        usuarioAntigo.setNomeCompleto(usuarioNovo.getNomeCompleto());
        return usuarioRepository.save(usuarioAntigo);
    }

}
