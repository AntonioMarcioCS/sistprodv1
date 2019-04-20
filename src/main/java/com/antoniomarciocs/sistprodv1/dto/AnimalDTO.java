package com.antoniomarciocs.sistprodv1.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.antoniomarciocs.sistprodv1.domain.Animal;

public class AnimalDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=4, max=80, message="Escreva entre 4 e 80 caracteres")
	private String nome;
	private String raca;
	private Date nascimento;
	private Integer tipo;
	private Integer criatorioId;
	
	public AnimalDTO() {		
	}

	public AnimalDTO(Animal obj) {
		id = obj.getId();
		nome = obj.getNome();
		raca = obj.getRaca();
		nascimento = obj.getNascimento();
		tipo = obj.getTipo().getCod();
		criatorioId = obj.getCriatorio().getId();
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

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Integer getCriatorioId() {
		return criatorioId;
	}

	public void setCriatorioId(Integer criatorioId) {
		this.criatorioId = criatorioId;
	}


}
