package com.antoniomarciocs.sistprodv1.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.antoniomarciocs.sistprodv1.domain.Irrigacao;

public class IrrigacaoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=4, max=80, message="Escreva entre 4 e 80 caracteres")
	private Date data;
	private Integer plantioId;
	
	public IrrigacaoDTO() {		
	}

	public IrrigacaoDTO(Irrigacao obj) {
		id = obj.getId();
		data = obj.getData();
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

	public Integer getPlantioId() {
		return plantioId;
	}

	public void setPlantioId(Integer plantioId) {
		this.plantioId = plantioId;
	}


}
