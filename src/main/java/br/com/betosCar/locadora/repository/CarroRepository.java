package br.com.betosCar.locadora.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.betosCar.locadora.modelo.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long>{

	Optional<Carro> findByModeloId(Long id);
}
