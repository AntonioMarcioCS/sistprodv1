package com.antoniomarciocs.sistprodv1.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.antoniomarciocs.sistprodv1.domain.Criatorio;

public class CriatorioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=4, max=80, message="Escreva entre 4 e 80 caracteres")
	private String nome;
	private Date data;
	private Integer tipo;
	private Double comprimento;
	private Double largura;
	private Double profundidade;
	private Integer sistemaId;
	
	public CriatorioDTO() {		
	}

	public CriatorioDTO(Criatorio obj) {
		id = obj.getId();
		nome = obj.getNome();
		data = obj.getData();
		tipo = obj.getTipo().getCod();
		comprimento = obj.getComprimento();
		largura = obj.getLargura();
		profundidade = obj.getProfundidade();
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
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
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

	public Integer getSistemaId() {
		return sistemaId;
	}

	public void setSistemaId(Integer sistemaId) {
		this.sistemaId = sistemaId;
	}
	
}
