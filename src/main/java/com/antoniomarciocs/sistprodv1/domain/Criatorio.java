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

import com.antoniomarciocs.sistprodv1.domain.enums.TipoCriatorio;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Date;

@Entity
public class Criatorio implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Date data;
	private Integer tipo;
	private Double comprimento;
	private Double largura;
	private Double profundidade;
	
	@JsonManagedReference
	@OneToMany(mappedBy="criatorio")
	private List<Animal> animais = new ArrayList<>();
		
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="sistema_id")
	private SistemaProducao sistema;
	
	public Criatorio() {
		
	}

	public Criatorio(Integer id, String nome, TipoCriatorio tipo, Double comprimento, Double largura, Double profundidade, SistemaProducao sistema) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipo = (tipo==null) ? null : tipo.getCod();
		this.comprimento = comprimento;
		this.largura = largura;
		this.profundidade = profundidade;
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	public TipoCriatorio getTipo() {
		return TipoCriatorio.toEnum(tipo);
	}

	public void setTipo(TipoCriatorio tipo) {
		this.tipo = tipo.getCod();
	}
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

	public Double getProfundidade() {
		return profundidade;
	}

	public void setProfundidade(Double profundidade) {
		this.profundidade = profundidade;
	}
	
	public SistemaProducao getSistema() {
		return sistema;
	}

	public void setSistema(SistemaProducao sistema) {
		this.sistema = sistema;
	}

	public List<Animal> getAnimais() {
		return animais;
	}

	public void setAnimais(List<Animal> animais) {
		this.animais = animais;
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
		Criatorio other = (Criatorio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
