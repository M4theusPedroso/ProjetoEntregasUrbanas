package br.com.senai.entregas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//LOMBOK
@Getter
@Setter

//OBRIGATORIO PARA O JPA FUNCIONAR
@NoArgsConstructor
@AllArgsConstructor

//JPA
//entity - informa que a classe eh uma tabela
@Entity
//table - permite que voce configure e personalize a tabela
@Table(name = "tipo_usuario")
public class TipoUsuario {

    // essas variaveis sao as colunas da tabela
    @Id //tem q ser do jakarta
    // o @Id eh pra mostrar que sao chaves primarias

    //Generated Value - define que a chave eh genrenciada pelo BD
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //@Column - configura a coluna
    // name - nome coluna
    // nulable - se poder se nulo ou nao
    @Column(name = "tipo_usuario_id", nullable = false)
    private Integer tipoUsuarioId;

    @Column(name = "descricao", nullable = false, columnDefinition = "TEXT")
    private String descricao;
}
