package br.com.betosCar.locadora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.betosCar.locadora.modelo.Carro;
import br.com.betosCar.locadora.modelo.Modelo;
import br.com.betosCar.locadora.repository.CarroRepository;
import br.com.betosCar.locadora.repository.ModeloRepository;

@Controller
@RequestMapping(CarroController.BARRA+CarroController.CARROS)
public class CarroController extends PadroesController<Carro, CarroRepository>{

	public static final String CARROS = "carros";
	
	@Autowired
	private ModeloRepository modeloRepository;

	@Override
	public String getName() {
		return "carroCadastro";
	}

	@Override
	public String getListar() {
		return "carroLista";
	}

	@Override
	public String getPage() {
		return CARROS;
	}

	@Override
	public Object getEntidade() {
		return new Carro();
	}

	@ModelAttribute(name="todosModelos")
	public List<Modelo> getModelos(){
		return modeloRepository.findAll();
	}
}
