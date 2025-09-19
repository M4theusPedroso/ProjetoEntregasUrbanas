package br.com.senai.entregas.controller;

import br.com.senai.entregas.model.TipoUsuario;
import br.com.senai.entregas.service.TipoUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipousuario")
//@Tag(name = "Controller TipoUsuario", description = "Metodos TipoUsuario")
public class TipoUsuarioController {
    //controller -> service
    private final TipoUsuarioService tipoUsuarioService;

    public TipoUsuarioController(TipoUsuarioService service) {
        tipoUsuarioService = service;
    }

    //listar todos
    @GetMapping
    //@Operation(
           // summary = "Lista todos os clientes",
           // description = "Lista todos os clientes sem nenhuma restricao"
    //)
    public ResponseEntity<List<TipoUsuario>> ListarTipoUsuario() {
        //1 - pegar a lista de tipo usuario
        List<TipoUsuario> tipoUsuario = tipoUsuarioService.listarTodos();
        return ResponseEntity.ok().body(tipoUsuario);
    }

    @PostMapping
    public ResponseEntity<TipoUsuario> cadastrarTipoUsuario(@RequestBody TipoUsuario tipoUsuario) {
        //1. tentar cadastrar o cliente
        tipoUsuarioService.cadastrarUsuario(tipoUsuario);

        // codigo 200 - OK
        //return ResponseEntity.ok(cliente);
        // codigo 201 - CREATED
        //return ResponseEntity.created(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoUsuario);
    }

    //buscar cliente por id
    @GetMapping("/{id}")
    //Path Variable -> recebe um valor no link
    public ResponseEntity<?> buscarClientePorId(@PathVariable Integer id) {
        //1. procurar o cliente
        TipoUsuario tipoUsuario = tipoUsuarioService.buscarPorId(id);
        //2. se eu nao encontrar, retorno erro
        if (tipoUsuario == null) {
            //mais simples:
            //return ResponseEntity.notFound().build();
            //mais detalhes:
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo Usuario " + id + "nao encontrado!");
        }

        //3. se encontrar, retorno o cliente
        return ResponseEntity.ok(tipoUsuario);
    }

    // get, post, put, delete
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarTipoUsuario(@PathVariable Integer id) {
        //1. verificar se o cliente existe
        TipoUsuario tipoUsuario = tipoUsuarioService.deletarTipoUsuario(id);
        //2. se nao existir  retorno erro
        if (tipoUsuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo Usuario " + id + "nao encontrado!");
        }
        //3. se existir retorno ok
        return ResponseEntity.ok(tipoUsuario);
    }

    //CADASTRAR
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarTipoUsuario(@PathVariable Integer id, @RequestBody TipoUsuario tipoUsuarioNovo) {
        //1. procuro o tipo usuario, tento atualizar
        TipoUsuario tpu = tipoUsuarioService.atualizarTipoUsuario(id, tipoUsuarioNovo);
        //2. se nao achar o cliente, mostro erro
        if (tpu == null) {
            return ResponseEntity.status(404).body("Tipo Usuario nao encontrado!");
        }
        //3. se achar retorno ok
        return ResponseEntity.ok(tpu);
    }
}
