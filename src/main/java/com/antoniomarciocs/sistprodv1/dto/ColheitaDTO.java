package com.antoniomarciocs.sistprodv1.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.antoniomarciocs.sistprodv1.domain.Colheita;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ColheitaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer qtd;
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date data;
	private Integer plantioId;

	public ColheitaDTO() {
		
	}

	public ColheitaDTO(Colheita obj) {		
		id =obj.getId();;
		qtd = obj.getQtd();
		data = obj.getData();
		plantioId = obj.getPlantio().getId();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
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
		ColheitaDTO other = (ColheitaDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
