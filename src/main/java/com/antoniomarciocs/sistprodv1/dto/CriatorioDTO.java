package com.antoniomarciocs.sistprodv1.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.antoniomarciocs.sistprodv1.domain.Criatorio;

public class CriatorioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=4, max=80, message="Escreva entre 4 e 80 caracteres")
	private String nome;
	private Integer sistemaId;
	
	public CriatorioDTO() {		
	}

	public CriatorioDTO(Criatorio obj) {
		id = obj.getId();
		nome = obj.getNome();
		sistemaId = obj.getSistema().getId();
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

	public Integer getSistemaId() {
		return sistemaId;
	}

	public void setSistemaId(Integer sistemaId) {
		this.sistemaId = sistemaId;
	}
	
}
