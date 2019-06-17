package br.com.betosCar.locadora.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.betosCar.locadora.modelo.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long>{

	List<Carro> findAllByModeloId(Long id);
}
