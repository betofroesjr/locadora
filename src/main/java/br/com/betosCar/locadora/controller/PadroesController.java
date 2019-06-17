package br.com.betosCar.locadora.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.betosCar.locadora.modelo.Entidade;
import br.com.betosCar.locadora.service.PadroesServiceInterface;

public abstract class PadroesController<E extends Entidade, S extends PadroesServiceInterface<E>> {

	private static final String MENSAGEM_ALTERAÇÃO = "ALTERAÇÃO REALIZADA COM SUCESSO!";

	private static final String MENSAGEM_INCLUSAO = "INCLUSÃO REALIZADA COM SUCESSO!";

	public static final String BARRA = "/";

	public static final String ID = "id";
	
	public static final String NOVO = "/novo";
	public static final String EDITAR = "/editar";
	public static final String EXCLUIR = "/excluir";

	public static final String MENSAGEM = "mensagem";
	public static final String REDIRECT = "redirect:";
	
	@Autowired
	protected S service;

	private String mensagemExcecaoErro;
	
	
	@PostMapping
	public ModelAndView salvar(@Valid E entidade, Errors erros, RedirectAttributes redirectAttributes){

		if(erros.hasErrors()){
			return new ModelAndView(getName());
		}
		
		if(entidade.getId() == null){
			service.incluir(entidade);
			redirectAttributes.addFlashAttribute(MENSAGEM, MENSAGEM_INCLUSAO);
		} else {
			service.alterar(entidade);
			redirectAttributes.addFlashAttribute(MENSAGEM, MENSAGEM_ALTERAÇÃO);			
		}
		
		return new ModelAndView(REDIRECT+BARRA+getPage()+NOVO);
	}
	
	@RequestMapping(NOVO)
	public ModelAndView novo(){
		this.mensagemExcecaoErro = null;
		ModelAndView modelAndView = new ModelAndView(getName());
		modelAndView.addObject(getEntidade());
		return modelAndView;
	}
	
	@GetMapping(EDITAR+BARRA+"{"+ID+"}")
	public ModelAndView editar(@PathVariable(ID) Long id){
		ModelAndView modelAndView = new ModelAndView(getName());
		modelAndView.addObject(service.pesquisarPorId(id));
		return modelAndView;
	}

	@GetMapping(EXCLUIR+BARRA+"{"+ID+"}")
	public ModelAndView excluir(@PathVariable(ID) Long id){
		ModelAndView modelAndView = null;
		modelAndView = new ModelAndView(REDIRECT+BARRA+getPage());
		try {
			service.excluir(id);
		} catch (Exception e) {
			mensagemExcecaoErro = e.getMessage();
		}
		return modelAndView;
	}
	
	@ModelAttribute(name="mensagemExcecaoErro")
	public String getMensagemExcecaoErro() {
		return mensagemExcecaoErro;
	}
	
	@GetMapping
	public ModelAndView listar(){
		ModelAndView modelAndView = new ModelAndView(getListar());
		
		modelAndView.addObject(getPage(), service.listar());
		
		return modelAndView;
	}
	
	public abstract String getName();
	public abstract String getListar();
	public abstract String getPage();
	public abstract Entidade getEntidade();
}
