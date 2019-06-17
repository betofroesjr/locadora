package br.com.betosCar.locadora.service;

import org.springframework.stereotype.Service;

import br.com.betosCar.locadora.modelo.Carro;
import br.com.betosCar.locadora.repository.CarroRepository;

@Service
public class CarroService extends PadroesService<Carro, CarroRepository>{

}
