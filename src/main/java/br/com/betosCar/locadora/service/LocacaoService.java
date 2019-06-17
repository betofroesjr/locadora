package br.com.betosCar.locadora.service;

import org.springframework.stereotype.Service;

import br.com.betosCar.locadora.modelo.Locacao;
import br.com.betosCar.locadora.repository.LocacaoRepository;

@Service
public class LocacaoService extends PadroesService<Locacao, LocacaoRepository>{

}
