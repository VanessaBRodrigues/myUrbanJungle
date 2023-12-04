package br.com.crud.model;

public enum StatusDesejo {
	
	TENHO("TENHO"),
	TIVE("TIVE"),
	QUERO("QUERO");
	
	private String descricao;
	
	StatusDesejo(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
