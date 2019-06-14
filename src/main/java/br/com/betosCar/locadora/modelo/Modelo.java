package br.com.betosCar.locadora.modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.betosCar.locadora.modelo.type.Categoria;

@Entity
public class Modelo extends Entidade {

	@NotBlank(message = "O campo descrição é obrigatório!")
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "O campo categoria é obrigátorio!")
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name = "id_fabricante")
	@NotNull(message = "O campo fabrincate é obrigatorio!")
	private Fabricante fabricante;
	
	public Modelo() {
		super();
	}
	public Modelo(Long id, String descricao, Categoria categoria, Fabricante fabricante) {
		super(id);
		this.descricao = descricao;
		this.categoria = categoria;
		this.fabricante = fabricante;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Fabricante getFabricante() {
		return fabricante;
	}
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
}
