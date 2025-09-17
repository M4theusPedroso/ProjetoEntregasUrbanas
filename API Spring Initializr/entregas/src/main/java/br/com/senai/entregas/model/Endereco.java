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
@Table(name = "endereco")

public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "endereco_id", nullable = false)
    private Integer enderecoId;

    @Column(name = "Logradouro", nullable = false, columnDefinition = "TEXT")
    private String logradouro;

    @Column(name = "numero", nullable = false, length = 20)
    private Integer numero;

    @Column(name = "cidade", nullable = false, columnDefinition = "TEXT")
    private String cidade;

    @Column(name = "cep", nullable = false, length = 10)
    private Integer cep;

    //muitos usuarios para um tipo de usuario
    //fetchtype.eager - carrega os dados juntos
    // optional - se eh obrigatorio ou nao
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    //avisar o java qual coluna do tipo usuario que vou relacionar
    @JoinColumn(name = "usuario_id")
    private Usuario usuario; // unindo endereco com usuario
}
