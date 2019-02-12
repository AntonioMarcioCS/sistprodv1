package com.antoniomarciocs.sistprodv1.domain.enums;

public enum StatusRetirada {
	RETIRADO(1, "Retirado"),
	DISPONIVEL(2, "Disponível");
	
	private int cod;
	private String descricao;
	private StatusRetirada(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
		
	public static StatusRetirada toEnum(Integer id) {
		if (id == null) {
			return null;
		}
		for (StatusRetirada x : StatusRetirada.values()) {
			if (id.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido " + id);
	}
}
