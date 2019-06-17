package br.com.betosCar.locadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.betosCar.locadora.modelo.Modelo;

public interface ModeloRepository extends JpaRepository<Modelo, Long> {
	
}
