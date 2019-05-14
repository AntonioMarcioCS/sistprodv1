package com.antoniomarciocs.sistprodv1.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.antoniomarciocs.sistprodv1.domain.Canteiro;

public class CanteiroDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=4, max=80, message="Escreva entre 4 e 80 caracteres")
	private String nome;
	private Double comprimento;
	private Double largura;
	private Integer sistemaId;
	
	public CanteiroDTO() {		
	}

	public CanteiroDTO(Canteiro obj) {
		id = obj.getId();
		nome = obj.getNome();
		comprimento= obj.getComprimento();
		largura = obj.getLargura();
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

	public Double getComprimento() {
		return comprimento;
	}

	public void setComprimento(Double comprimento) {
		this.comprimento = comprimento;
	}

	public Double getLargura() {
		return largura;
	}

	public void setLargura(Double largaura) {
		this.largura = largaura;
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
