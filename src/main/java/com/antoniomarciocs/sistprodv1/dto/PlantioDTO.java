package com.antoniomarciocs.sistprodv1.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import com.antoniomarciocs.sistprodv1.domain.Plantio;
import com.fasterxml.jackson.annotation.JsonFormat;

public class PlantioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message="Preenchimento obrigatório")
	private String nome;
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date data;
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date colheita;
	private Integer qtd;
	private Integer canteiroId;
	private Integer culturaId;
	
	public PlantioDTO() {
		
	}

	public PlantioDTO(Plantio obj) {
		id = obj.getId();
		nome = obj.getNome();
		data = obj.getData();
		colheita = obj.getColheita(); 
		qtd = obj.getQtd();
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

	public Integer getCanteiroId() {
		return canteiroId;
	}

	public void setCanteiroId(Integer canteiroId) {
		this.canteiroId = canteiroId;
	}

	public Integer getCulturaId() {
		return culturaId;
	}

	public void setCulturaId(Integer culturaId) {
		this.culturaId = culturaId;
	}
	
}
