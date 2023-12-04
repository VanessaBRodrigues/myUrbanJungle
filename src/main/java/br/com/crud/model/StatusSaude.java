package br.com.crud.model;

public enum StatusSaude {

	SAUDAVEL("Saúdavel"),
	TRATAMENTO("Em Tratamento"),
	DOENTE("Doente");
	
	private String descricao;
	
	StatusSaude(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
