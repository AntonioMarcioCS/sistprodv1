package com.antoniomarciocs.sistprodv1.domain.enums;

public enum TipoAnimal {

	ABELHA(1, "Abelhas" ),
	CODORNA(2, "Codornas"),
	GALINHA(3, "Galinhas"),
	PEIXE(4, "Peixes"),
	PORCO(5, "Porcos");
	
	private int cod;
	private String descricao;
	
	private TipoAnimal(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoAnimal toEnum(Integer id) {
		if (id == null) {
			return null;
		}
		for (TipoAnimal x : TipoAnimal.values()) {
			if (id.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido " + id);
	}

}
