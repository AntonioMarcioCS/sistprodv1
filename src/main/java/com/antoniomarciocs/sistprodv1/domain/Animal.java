package com.antoniomarciocs.sistprodv1.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.antoniomarciocs.sistprodv1.domain.enums.StatusRetirada;
import com.antoniomarciocs.sistprodv1.domain.enums.TipoAnimal;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Animal implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String raca;
	private Date nascimento;
	private Integer tipo;
	private Integer status;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="criatorio_id")
	private Criatorio criatorio;
	
	public Animal() {
		
	}

	public Animal(Integer id, String nome, String raca, Date nascimento, TipoAnimal tipo, StatusRetirada status,
			Criatorio criatorio) {
		super();
		this.id = id;
		this.nome = nome;
		this.raca = raca;
		this.nascimento = nascimento;
		this.tipo = tipo.getCod();
		this.status = (status == null) ? null: status.getCod();
		this.criatorio = criatorio;
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

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public TipoAnimal getTipo() {
		return TipoAnimal.toEnum(tipo);
	}

	public void setTipo(TipoAnimal tipo) {
		this.tipo = tipo.getCod();
	}

	public StatusRetirada getStatus() {
		return StatusRetirada.toEnum(status);
	}

	public void setStatus(StatusRetirada status) {
		this.status = status.getCod();
	}

	public Criatorio getCriatorio() {
		return criatorio;
	}

	public void setCriatorio(Criatorio criatorio) {
		this.criatorio = criatorio;
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
		Animal other = (Animal) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
