package br.com.betosCar.locadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.betosCar.locadora.modelo.Motorista;

public interface MotoristaRepository extends JpaRepository<Motorista, Long>{

}
