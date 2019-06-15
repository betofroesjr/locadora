package br.com.betosCar.locadora.modelo.type;

public enum Categoria {
	
	HATCH("Hatch"), 
	SEDAN("Sedan"), 
	UTILITARIO("Utilitário"), 
	ESPORTIVO("Esportivo");

	private String descricao;
	
	Categoria(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
