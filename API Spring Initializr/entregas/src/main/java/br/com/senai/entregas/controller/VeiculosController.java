package br.com.senai.entregas.controller;

import br.com.senai.entregas.model.Veiculos;
import br.com.senai.entregas.service.VeiculosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/veiculos")

public class VeiculosController {

    private final  VeiculosService veiculosService;

    public VeiculosController(VeiculosService service) {
        veiculosService = service;
    }

    //listar todos
    @GetMapping
    public ResponseEntity<List<Veiculos>> ListarVeiculos() {
        List<Veiculos> veiculos = veiculosService.listarTodos();
        return ResponseEntity.ok().body(veiculos);
    }

    //buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<?> getVeiculoPorId(@PathVariable Integer id) {
        Veiculos veiculo = veiculosService.buscarPorId(id);
        if (veiculo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veiculo" + id + "nao encontrado!");
        }
        return ResponseEntity.ok(veiculo);
    }

}
