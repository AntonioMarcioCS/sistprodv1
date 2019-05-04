package com.antoniomarciocs.sistprodv1.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Canteiro implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Double comprimento;
	private Double largaura;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="sistema_id")
	private SistemaProducao sistema;
	
	@JsonManagedReference
	@OneToMany(mappedBy="canteiro")
	private List<Plantio> plantis = new ArrayList<>();
		
	public Canteiro() {
		
	}

	public Canteiro(Integer id, String nome, Double comprimento, Double largaura, SistemaProducao sistema) {
		super();
		this.id = id;
		this.nome = nome;
		this.comprimento = comprimento;
		this.largaura = largaura;
		this.sistema = sistema;
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

	public Double getComprimento() {
		return comprimento;
	}

	public void setComprimento(Double comprimento) {
		this.comprimento = comprimento;
	}

	public Double getLargaura() {
		return largaura;
	}

	public void setLargaura(Double largaura) {
		this.largaura = largaura;
	}
		
	public SistemaProducao getSistema() {
		return sistema;
	}

	public void setSistema(SistemaProducao sistema) {
		this.sistema = sistema;
	}
	
	public List<Plantio> getPlantis() {
		return plantis;
	}

	public void setPlantis(List<Plantio> plantis) {
		this.plantis = plantis;
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
		Canteiro other = (Canteiro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
	
}
