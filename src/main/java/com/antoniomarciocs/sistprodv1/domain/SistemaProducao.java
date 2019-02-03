package com.antoniomarciocs.sistprodv1.domain;

import java.io.Serializable;
//import java.util.Date;

public class SistemaProducao implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;
	//private Date data;
	private Double comprimento;
	private Double largura;
	
	public SistemaProducao() {
		
	}

	public SistemaProducao(Integer id, String nome /*,Date data*/, Double comprimento, Double largura) {
		super();
		this.id = id;
		this.nome = nome;
		//this.data = data;
		this.comprimento = comprimento;
		this.largura = largura;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	/*public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}*/

	public Double getComprimento() {
		return comprimento;
	}

	public void setComprimento(Double comprimento) {
		this.comprimento = comprimento;
	}

	public Double getLargura() {
		return largura;
	}

	public void setLargura(Double largura) {
		this.largura = largura;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SistemaProducao other = (SistemaProducao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
