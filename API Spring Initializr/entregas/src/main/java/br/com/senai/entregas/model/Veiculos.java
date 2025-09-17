package br.com.senai.entregas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "veiculos")

public class Veiculos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "veiculos_id", nullable = false)
    private Integer veiculosId;

    @Column(name = "placa", nullable = false, columnDefinition = "TEXT", unique = true)
    private String placa;

    @Column(name = "modelo", nullable = false, columnDefinition = "TEXT")
    private String modelo;

    @Column(name = "tipo", nullable = false, columnDefinition = "TEXT")
    private String tipo;

    //FETCHTYPE.EAGER - CARREGA OS DADOS JUNTOS
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    //avisar o java qual coluna do tipo usuario que vou relacionar
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
