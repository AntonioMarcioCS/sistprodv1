package com.antoniomarciocs.sistprodv1.dto;

import java.io.Serializable;

import com.antoniomarciocs.sistprodv1.domain.SistemaProducao;

public class SistemaProducaoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	//private Date data;
	private Double comprimento;
	private Double largura;
	
	public SistemaProducaoDTO() {		
	}
	
	public SistemaProducaoDTO(SistemaProducao obj) {		
		id = obj.getId();
		nome = obj.getNome();
		comprimento = obj.getComprimento();
		largura = obj.getLargura();
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
	
	
}
