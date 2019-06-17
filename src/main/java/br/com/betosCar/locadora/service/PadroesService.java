package br.com.betosCar.locadora.service;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.betosCar.locadora.modelo.Entidade;

public abstract class PadroesService<E extends Entidade, T extends JpaRepository<E, Long>> implements PadroesServiceInterface<E> {

	@Autowired
	protected T repository;
	
	@Override
	public E incluir(E entidade){
		entidade.setId(null);
		return repository.save(entidade);
	}

	@Override
	public E alterar(E entidade){
		pesquisarPorId(entidade.getId());
		return repository.save(entidade);
	}

	@Override
	public void excluir(Long id) {
		try {
			consistirExcluir(id);
			repository.deleteById(id);
		} catch (ConstraintViolationException | DataIntegrityViolationException e){
			e.printStackTrace();
			throw new RuntimeException("Não foi possivel apagar este registro pois o mesmo consta em outra Entidade!!!");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	protected void consistir(E entidade){
		
	}
	
	protected void consistirExcluir(Long id){
		
	}

	@Override
	public List<E> listar(){
		return repository.findAll();
	}
	
	@Override
	public E pesquisarPorId(Long id){
		return repository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(0));
	}
}