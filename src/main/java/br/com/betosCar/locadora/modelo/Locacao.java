package br.com.betosCar.locadora.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;

@Entity
public class Locacao extends Entidade {

	@NotNull(message = "O campo valor total da Diária não pode ser nulo!")
	@Column(precision = 10, scale = 2)
	@NumberFormat(pattern="#,##0.00")
	private BigDecimal valorTotal;
	
	private LocalDate dataDeLocacao;
	private LocalDate dataDeDevolucao;
	private Carro carro;
	
	public Locacao() {
	}
	public Locacao(Long id, BigDecimal valorTotal, LocalDate dataDeLocacao,
			LocalDate dataDeDevolucao, Carro carro) {
		super(id);
		this.valorTotal = valorTotal;
		this.dataDeLocacao = dataDeLocacao;
		this.dataDeDevolucao = dataDeDevolucao;
		this.carro = carro;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	public LocalDate getDataDeLocacao() {
		return dataDeLocacao;
	}
	public void setDataDeLocacao(LocalDate dataDeLocacao) {
		this.dataDeLocacao = dataDeLocacao;
	}
	public LocalDate getDataDeDevolucao() {
		return dataDeDevolucao;
	}
	public void setDataDeDevolucao(LocalDate dataDeDevolucao) {
		this.dataDeDevolucao = dataDeDevolucao;
	}
	public Carro getCarro() {
		return carro;
	}
	public void setCarro(Carro carro) {
		this.carro = carro;
	}
}
