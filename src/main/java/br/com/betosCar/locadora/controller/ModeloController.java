package br.com.betosCar.locadora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.betosCar.locadora.modelo.Entidade;
import br.com.betosCar.locadora.modelo.Fabricante;
import br.com.betosCar.locadora.modelo.Modelo;
import br.com.betosCar.locadora.modelo.type.Categoria;
import br.com.betosCar.locadora.repository.FabricanteRepository;
import br.com.betosCar.locadora.service.ModeloService;

@Controller
@RequestMapping(ModeloController.BARRA+ModeloController.MODELOS)
public class ModeloController extends PadroesController<Modelo, ModeloService>{

	public static final String MODELOS = "modelos";

	@Autowired
	private FabricanteRepository fabricanteRepository;
	
	@Override
	public String getName() {
		return "modeloCadastro";
	}

	@Override
	public String getListar() {
		return "modeloLista";
	}

	@Override
	public String getPage() {
		return MODELOS;
	}

	@Override
	public Entidade getEntidade() {
		return new Modelo();
	}
	
	@ModelAttribute(name="todasCategorias")
	public Categoria[] getCategorias(){
		return Categoria.values();
	}
	
	@ModelAttribute(name="todosFabricantes")
	public List<Fabricante> getFabricantes(){
		return fabricanteRepository.findAll();
	}
}
