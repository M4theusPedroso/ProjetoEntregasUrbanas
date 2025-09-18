package br.com.senai.entregas.repository;

import br.com.senai.entregas.model.Entregas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//anotacao
@Repository

//herdar jpa
public interface EntregasRepository extends JpaRepository<Entregas,Integer> {
}
