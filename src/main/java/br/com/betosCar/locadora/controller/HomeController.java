package br.com.betosCar.locadora.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.betosCar.locadora.LocadoraApplication;

@Controller
public class HomeController {

	@GetMapping(PadroesController.BARRA)
	public String home(LocadoraApplication application){
		return "/dashboard";
	}
}
