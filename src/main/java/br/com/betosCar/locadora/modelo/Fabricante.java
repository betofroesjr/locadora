package br.com.betosCar.locadora.modelo;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
public class Fabricante extends Entidade {

	@NotBlank(message = "O campo nome é obrigatório!")
	private String nome;
	
	@NotBlank(message = "O campo descrição é obrigatório!")
	private String descricao;
	
	public Fabricante(Long id, String nome, String descricao) {
		super(id);
		this.nome = nome;
		this.descricao = descricao;
	}
	public Fabricante() {
		super();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
