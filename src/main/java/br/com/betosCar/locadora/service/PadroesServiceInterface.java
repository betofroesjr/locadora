package br.com.betosCar.locadora.service;

import java.util.List;

import br.com.betosCar.locadora.modelo.Entidade;

public interface PadroesServiceInterface<E extends Entidade> {

	E incluir(E entidade);

	E alterar(E entidade);

	void excluir(Long id);

	List<E> listar();

	E pesquisarPorId(Long id);

}
