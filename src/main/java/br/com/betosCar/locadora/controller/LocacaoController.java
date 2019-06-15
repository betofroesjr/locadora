package br.com.betosCar.locadora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.betosCar.locadora.modelo.Carro;
import br.com.betosCar.locadora.modelo.Locacao;
import br.com.betosCar.locadora.modelo.Motorista;
import br.com.betosCar.locadora.repository.CarroRepository;
import br.com.betosCar.locadora.repository.LocacaoRepository;
import br.com.betosCar.locadora.repository.MotoristaRepository;

@Controller
@RequestMapping(LocacaoController.BARRA+LocacaoController.LOCACOES)
public class LocacaoController extends PadroesController<Locacao, LocacaoRepository> {

	public static final String LOCACOES = "locacoes";
	
	@Autowired
	private MotoristaRepository motoristaRepository;

	@Autowired
	private CarroRepository carroRepository;

	@Override
	public String getName() {
		return "locacaoCadastro";
	}

	@Override
	public String getListar() {
		return "locacaoLista";
	}

	@Override
	public String getPage() {
		return LOCACOES;
	}

	@Override
	public Object getEntidade() {
		return new Locacao();
	}
	
	@ModelAttribute(name="todosCarros")
	public List<Carro> getCarros(){
		return carroRepository.findAll();
	}

	@ModelAttribute(name="todosMotoristas")
	public List<Motorista> getMotorista(){
		return motoristaRepository.findAll();
	}
}
