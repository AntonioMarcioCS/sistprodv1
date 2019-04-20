package com.antoniomarciocs.sistprodv1.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.antoniomarciocs.sistprodv1.domain.Fertilizante;

public class FertilizanteDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=4, max=80, message="Escreva entre 4 e 80 caracteres")
	private String nome;
	private Date data;
	private Integer qtd;
	private Integer plantioId;
	
	public FertilizanteDTO() {		
	}

	public FertilizanteDTO(Fertilizante obj) {
		id = obj.getId();
		nome = obj.getNome();
		data = obj.getData();
		qtd = obj.getQtd();
		plantioId = obj.getPlantio().getId();
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

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public Integer getPlantioId() {
		return plantioId;
	}

	public void setPlantioId(Integer plantioId) {
		this.plantioId = plantioId;
	}


}
