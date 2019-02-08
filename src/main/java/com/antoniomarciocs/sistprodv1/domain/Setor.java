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
public class Setor implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String regiao;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="sistema_id")
	private SistemaProducao sistema;
	
	@JsonManagedReference
	@OneToMany(mappedBy="setor")
	private List<Canteiro> canteiros = new ArrayList<>();
	
	@JsonManagedReference
	@OneToMany(mappedBy="setor")
	private List<Criatorio> criatorios = new ArrayList<>();
	
	public Setor() {
		
	}

	public Setor(Integer id, String nome, String regiao, SistemaProducao sistema) {
		super();
		this.id = id;
		this.nome = nome;
		this.regiao = regiao;
		this.sistema= sistema;
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

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}
	
	public SistemaProducao getSistema() {
		return sistema;
	}

	public void setSistema(SistemaProducao sistema) {
		this.sistema = sistema;
	}

	public List<Canteiro> getCanteiros() {
		return canteiros;
	}

	public void setCanteiros(List<Canteiro> canteiros) {
		this.canteiros = canteiros;
	}

	public List<Criatorio> getCriatorios() {
		return criatorios;
	}

	public void setCriatorios(List<Criatorio> criatorios) {
		this.criatorios = criatorios;
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
		Setor other = (Setor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
