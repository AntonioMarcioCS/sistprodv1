package com.antoniomarciocs.sistprodv1.domain.enums;

public enum TipoCriatorio {

	CHIQUEIRO(1, "Chiqueiro"),
	POLEIRO(2, "Poleiro"),
	TANQUE(3, "Tanque");
	
	private int cod;
	private String descricao;
	
	private TipoCriatorio(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoCriatorio toEnum(Integer id) {
		if (id == null) {
			return null;
		}
		for (TipoCriatorio x : TipoCriatorio.values()) {
			if (id.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido " + id);
	}

}
