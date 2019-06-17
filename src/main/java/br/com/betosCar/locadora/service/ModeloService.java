package br.com.betosCar.locadora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.betosCar.locadora.modelo.Carro;
import br.com.betosCar.locadora.modelo.Modelo;
import br.com.betosCar.locadora.repository.CarroRepository;
import br.com.betosCar.locadora.repository.ModeloRepository;

@Service
public class ModeloService extends PadroesService<Modelo, ModeloRepository>{

	@Autowired
	private CarroRepository carroRepository;
	
	@Override
	protected void consistirExcluir(Long id){
		List<Carro> carros = carroRepository.findAllByModeloId(id);
		if(carros != null && !carros.isEmpty()){
			String carrosText = "";
			for(Carro carro : carros){
				carrosText += carro.getId() + ":"+carro.getNomeModelo()+";\t\n ";
			}
			
			throw new RuntimeException("Modelo consta nos seguintes carros:\t\n "+carrosText);
		}
	}
}
