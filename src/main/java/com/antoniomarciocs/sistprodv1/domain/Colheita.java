package com.antoniomarciocs.sistprodv1.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Colheita implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer qtd;
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date data;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="plantio_id")
	private Plantio plantio;

	public Colheita() {
		
	}
	public Colheita(Integer id, Integer qtd, Date data, Plantio plantio) {
		super();
		this.id = id;
		this.qtd = qtd;
		this.data = data;
		this.plantio = plantio;
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
	public Plantio getPlantio() {
		return plantio;
	}
	public void setPlantio(Plantio plantio) {
		this.plantio = plantio;
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
		Colheita other = (Colheita) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
