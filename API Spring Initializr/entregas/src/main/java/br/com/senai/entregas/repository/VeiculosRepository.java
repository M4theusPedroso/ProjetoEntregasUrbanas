package br.com.senai.entregas.repository;

import br.com.senai.entregas.model.Veiculos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//anotacao
@Repository

//herdar jpa
public interface VeiculosRepository extends JpaRepository<Veiculos,Integer> {
}
