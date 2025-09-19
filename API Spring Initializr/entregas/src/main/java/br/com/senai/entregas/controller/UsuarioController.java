package br.com.senai.entregas.controller;

import br.com.senai.entregas.model.Usuario;
import br.com.senai.entregas.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")

public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuario) {
        usuarioService = usuario;
    }

    @GetMapping
    //@Operation(
    // summary = "Lista todos os clientes",
    // description = "Lista todos os clientes sem nenhuma restricao"
    //)
    public ResponseEntity<List<Usuario>> ListarUsuario() {
        //1 - pegar a lista de tipo usuario
        List<Usuario> tipoUsuario = usuarioService.listarTodos();
        return ResponseEntity.ok().body(tipoUsuario);
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastrarTipoUsuario(@RequestBody Usuario usuario) {
        //1. tentar cadastrar o cliente
        usuarioService.cadastrarUsuario(usuario);

        // codigo 200 - OK
        //return ResponseEntity.ok(cliente);
        // codigo 201 - CREATED
        //return ResponseEntity.created(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    //buscar usuario por id
    @GetMapping("/{id}")
    //Path Variable -> recebe um valor no link
    public ResponseEntity<?> buscarUsuarioPorId(@PathVariable Integer id) {
        //1. procurar o cliente
        Usuario usuario = usuarioService.buscarPorId(id);
        //2. se eu nao encontrar, retorno erro
        if (usuario == null) {
            //mais simples:
            //return ResponseEntity.notFound().build();
            //mais detalhes:
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario " + id + "nao encontrado!");
        }

        //3. se encontrar, retorno o cliente
        return ResponseEntity.ok(usuario);
    }

    // get, post, put, delete
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarUsuario(@PathVariable Integer id) {
        //1. verificar se o usuario existe
        Usuario usuario = usuarioService.deletarUsuario(id);
        //2. se nao existir  retorno erro
        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario " + id + "nao encontrado!");
        }
        //3. se existir retorno ok
        return ResponseEntity.ok(usuario);
    }

    //CADASTRAR
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarUsuario(@PathVariable Integer id, @RequestBody Usuario usuarioNovo) {
        //1. procuro o tipo usuario, tento atualizar
        Usuario usuario = usuarioService.atualizarUsuario(id, usuarioNovo);
        //2. se nao achar o cliente, mostro erro
        if (usuario == null) {
            return ResponseEntity.status(404).body("Usuario nao encontrado!");
        }
        //3. se achar retorno ok
        return ResponseEntity.ok(usuario);
    }
}
