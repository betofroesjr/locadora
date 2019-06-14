package br.com.betosCar.locadora.modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.betosCar.locadora.modelo.type.Sexo;

@Entity
public class Motorista extends Entidade{

	@NotBlank(message = "O campo nome é obrigatório!")
	private String nome;
	
	@NotBlank(message = "O campo cpf é obrigatório!")
	private String cpf;
	
	@NotBlank(message = "O campo cnh é obrigatório!")
	private String cnh;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "O campo tipo sexo não pode estar vazio!")
	private Sexo sexo;
	
	@ManyToOne
	@JoinColumn(name = "id_locacao")
	@NotNull(message = "O campo locação não pode estar vazio!")
	private Locacao locacao;
	
	public Motorista() {
	}
	public Motorista(Long id, String nome, String cpf, String cnh, Sexo sexo,
			Locacao locacao) {
		super(id);
		this.nome = nome;
		this.cpf = cpf;
		this.cnh = cnh;
		this.sexo = sexo;
		this.locacao = locacao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCnh() {
		return cnh;
	}
	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public Locacao getLocacao() {
		return locacao;
	}
	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}
}
