package br.com.betosCar.locadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.betosCar.locadora.modelo.Locacao;

public interface LocacaoRepository extends JpaRepository<Locacao, Long> {

}
