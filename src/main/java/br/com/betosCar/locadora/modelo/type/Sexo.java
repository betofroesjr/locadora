package br.com.betosCar.locadora.modelo.type;

public enum Sexo {
	MASCULINO("Masculino"), FEMININO("Feminino");
	
	private String descricao;
	
	Sexo(String descricao){
		this.descricao = descricao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
