package com.antoniomarciocs.sistprodv1.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.antoniomarciocs.sistprodv1.domain.Plantio;

public class PlantioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=4, max=80, message="Escreva entre 4 e 80 caracteres")
	private String nome;
	private Integer canteiroId;
	private Integer culturaId;
	
	public PlantioDTO() {		
	}

	public PlantioDTO(Plantio obj) {
		id = obj.getId();
		nome = obj.getNome();
		canteiroId = obj.getCanteiro().getId();
		culturaId = obj.getCultura().getId();
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


	public Integer getCanteiroId() {
		return canteiroId;
	}

	public void setCanteiroId(Integer setorId) {
		this.canteiroId = setorId;
	}

	public Integer getCulturaId() {
		return culturaId;
	}

	public void setCulturaId(Integer culturaId) {
		this.culturaId = culturaId;
	}

	
	

}
