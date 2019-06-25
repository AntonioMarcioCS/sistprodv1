package com.antoniomarciocs.sistprodv1.dto;

import java.io.Serializable;
import java.util.Date;

import com.antoniomarciocs.sistprodv1.domain.Fertilizante;
import com.fasterxml.jackson.annotation.JsonFormat;

public class FertilizanteDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date data;
	private String descricao;
	private Integer qtd;
	private Integer plantioId;
	
	public FertilizanteDTO() {		
	}

	public FertilizanteDTO(Fertilizante obj) {
		id = obj.getId();
		descricao = obj.getDescricao();
		data = obj.getData();
		qtd = obj.getQtd();
		plantioId = obj.getPlantio().getId();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public Integer getPlantioId() {
		return plantioId;
	}

	public void setPlantioId(Integer plantioId) {
		this.plantioId = plantioId;
	}


}
