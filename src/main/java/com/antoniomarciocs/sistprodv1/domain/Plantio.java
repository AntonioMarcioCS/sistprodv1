package com.antoniomarciocs.sistprodv1.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.antoniomarciocs.sistprodv1.domain.enums.StatusRetirada;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Plantio implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date data;
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date colheita;
	private Integer qtd;
	private Integer status;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="canteiro_id")
	private Canteiro canteiro;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="cultura_id")
	private Cultura cultura;
	
	@JsonManagedReference
	@OneToMany(mappedBy="plantio")
	List<Irrigacao> irrigacoes = new ArrayList<>();
	
	@JsonManagedReference
	@OneToMany(mappedBy="plantio")
	List<Fertilizante> fertilizantes = new ArrayList<>();
	
	@JsonManagedReference
	@OneToMany(mappedBy="plantio")
	List<Defensivo> defensivos = new ArrayList<>();
	
	public Plantio() {
		
	}

	public Plantio(Integer id, String nome, Date data, Date colheita, Integer qtd, StatusRetirada status, Canteiro canteiro,
			Cultura cultura) {
		super();
		this.id = id;
		this.nome = nome;
		this.data = data;
		this.colheita = colheita;
		this.qtd = qtd;
		this.status = (status==null) ? null : status.getCod();
		this.canteiro = canteiro;
		this.cultura = cultura;
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getColheita() {
		return colheita;
	}

	public void setColheita(Date colheita) {
		this.colheita = colheita;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Canteiro getCanteiro() {
		return canteiro;
	}

	public void setCanteiro(Canteiro canteiro) {
		this.canteiro = canteiro;
	}

	public Cultura getCultura() {
		return cultura;
	}

	public void setCultura(Cultura cultura) {
		this.cultura = cultura;
	}

	public List<Irrigacao> getIrrigacoes() {
		return irrigacoes;
	}

	public void setIrrigacoes(List<Irrigacao> irrigacoes) {
		this.irrigacoes = irrigacoes;
	}

	public List<Fertilizante> getFertilizantes() {
		return fertilizantes;
	}

	public void setFertilizantes(List<Fertilizante> fertilizantes) {
		this.fertilizantes = fertilizantes;
	}

	public List<Defensivo> getDefensivos() {
		return defensivos;
	}

	public void setDefensivos(List<Defensivo> defensivos) {
		this.defensivos = defensivos;
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
		Plantio other = (Plantio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	

}
