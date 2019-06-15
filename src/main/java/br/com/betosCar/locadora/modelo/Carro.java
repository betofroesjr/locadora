package br.com.betosCar.locadora.modelo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;

@Entity
public class Carro extends Entidade {

	@NotBlank(message= "O nome do carro é obrigatório!")
	private String nome;
	
	@NotBlank(message = "O campo placa é obrigatório!")
	private String placa;
	
	@NotBlank(message = "O campo chassi é obrigatório!")
	private String chassi;
	
	@NotNull(message = "O campo valor da Diária é obrigátorio!")
	@Column(precision = 10, scale = 2)
	@NumberFormat(pattern="#,##0.00")
	private BigDecimal valorDaDiaria;
	
	@ManyToOne
	@JoinColumn(name = "id_modelo")
	@NotNull(message = "O campo modelo do carro é obrigátorio!")
	private Modelo modelo;
	
	public Carro() {
	}
	public Carro(Long id,String nome, String placa, String chassi,
			BigDecimal valorDaDiaria, Modelo modelo) {
		super(id);
		this.nome = nome;
		this.placa = placa;
		this.chassi = chassi;
		this.valorDaDiaria = valorDaDiaria;
		this.modelo = modelo;
	}
	public String getNomeModelo(){
		String nomeCompletoCarro = getNome();
		if(getModelo() != null){
			nomeCompletoCarro += getModelo().getDescricao() + " ";
			if(getModelo().getCategoria() != null){
				nomeCompletoCarro += getModelo().getCategoria().getDescricao() + " ";
			}
			if(getModelo().getFabricante() != null){
				nomeCompletoCarro += getModelo().getFabricante().getNome() + " ";
			}
		}
		return nomeCompletoCarro;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	public BigDecimal getValorDaDiaria() {
		return valorDaDiaria;
	}
	public void setValorDaDiaria(BigDecimal valorDaDiaria) {
		this.valorDaDiaria = valorDaDiaria;
	}
	public Modelo getModelo() {
		return modelo;
	}
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
}
