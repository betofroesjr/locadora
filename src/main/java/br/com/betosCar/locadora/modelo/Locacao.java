package br.com.betosCar.locadora.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Locacao extends Entidade {

	@NotNull(message = "O campo valor total da Diária não pode estar vazio!")
	@Column(precision = 10, scale = 2)
	@NumberFormat(pattern="#,##0.00")
	private BigDecimal valorTotal;
	
	@NotNull(message = "O campo data de locação não pode estar vazio!")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataDeLocacao;

	@NotNull(message = "O campo data de locação não pode estar vazio!")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataDeDevolucao;
	
	@ManyToOne
	@JoinColumn(name = "id_carro")
	@NotNull(message = "O campo carro é obrigatorio!")
	private Carro carro;
	
	@ManyToOne
	@JoinColumn(name = "id_motorista")
	@NotNull(message = "O campo motorista é obrigatorio!")
	private Motorista motorista;
	
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
