package br.com.senai.entregas.repository;

import br.com.senai.entregas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    Optional<Usuario> findByEmail(String email); // Optional: eh uma caixa q o java so vai ler se tiver algo dentro

    String username(String username);
    // se nao tiver, ele nao mexe e o sistema nao quebra
}
