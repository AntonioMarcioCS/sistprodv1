package com.antoniomarciocs.sistprodv1.dto;

import java.io.Serializable;
import java.util.Date;

import com.antoniomarciocs.sistprodv1.domain.Irrigacao;
import com.fasterxml.jackson.annotation.JsonFormat;

public class IrrigacaoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private double tempo;
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date data;
	private Integer plantioId;
	
	public IrrigacaoDTO() {		
	}

	public IrrigacaoDTO(Irrigacao obj) {
		id = obj.getId();
		tempo= obj.getTempo();
		data = obj.getData();
		plantioId = obj.getPlantio().getId();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getTempo() {
		return tempo;
	}

	public void setTempo(double tempo) {
		this.tempo = tempo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getPlantioId() {
		return plantioId;
	}

	public void setPlantioId(Integer plantioId) {
		this.plantioId = plantioId;
	}


}
