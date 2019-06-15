package br.com.betosCar.locadora.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.betosCar.locadora.modelo.Fabricante;
import br.com.betosCar.locadora.repository.FabricanteRepository;

@Controller
@RequestMapping(FabricanteController.BARRA+FabricanteController.FABRICANTES)
public class FabricanteController extends PadroesController<Fabricante, FabricanteRepository> {

	public static final String FABRICANTES = "fabricantes";

	@Override
	public String getName() {
		return "fabricanteCadastro";
	}

	@Override
	public String getListar() {
		return "fabricanteLista";
	}

	@Override
	public String getPage() {
		return FABRICANTES;
	}

	@Override
	public Object getEntidade() {
		return new Fabricante();
	}
}
