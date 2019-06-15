package br.com.betosCar.locadora.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.betosCar.locadora.modelo.Entidade;
import br.com.betosCar.locadora.modelo.Motorista;
import br.com.betosCar.locadora.modelo.type.Sexo;
import br.com.betosCar.locadora.repository.MotoristaRepository;
import br.com.betosCar.locadora.service.MotoristaService;

@Controller
@RequestMapping(MotoristaController.BARRA+MotoristaController.MOTORISTAS)
public class MotoristaController extends PadroesController<Motorista, MotoristaService>{

	public static final String MOTORISTAS = "motoristas";

	@Override
	public String getName() {
		return "motoristaCadastro";
	}

	@Override
	public String getListar() {
		return "motoristaLista";
	}

	@Override
	public String getPage() {
		return MOTORISTAS;
	}

	@Override
	public Entidade getEntidade() {
		return new Motorista();
	}
	
	@ModelAttribute(name="todosSexos")
	public Sexo[] getTiposSexo(){
		return Sexo.values();
	}
}
