package com.antoniomarciocs.sistprodv1.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.antoniomarciocs.sistprodv1.domain.SistemaProducao;

public class SistemaProducaoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=80, message="Escreva entre 5 e 80 caracteres")
	private String nome;
	private Date data;
	private Double comprimento;
	private Double largura;
	private Integer usuarioId;
	
	public SistemaProducaoDTO() {		
	}
	
	public SistemaProducaoDTO(SistemaProducao obj) {		
		id = obj.getId();
		nome = obj.getNome();
		data = obj.getData();
		comprimento = obj.getComprimento();
		largura = obj.getLargura();
		usuarioId = obj.getUsuario().getId();
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

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}
	
}