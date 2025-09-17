package br.com.senai.entregas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "entregas")

public class Entregas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entregas_id", nullable = false)
    private Integer entregasid;

    @Column(name = "descricao_produto", nullable = false, columnDefinition = "TEXT")
    private String descricaoproduto;

    @Column(name = "status", nullable = false, columnDefinition = "TEXT")
    private String status;

    @Column(name = "data", nullable = false)
    private OffsetDateTime dataPedido;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    //agora avisamos o java qual coluna do tipo usuario vou relacionar
    @JoinColumn(name = "usuario")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    //agora avisamos o java qual coluna do tipo usuario vou relacionar
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

}
