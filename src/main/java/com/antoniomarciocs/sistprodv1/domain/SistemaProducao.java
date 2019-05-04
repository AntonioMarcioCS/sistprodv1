package com.antoniomarciocs.sistprodv1.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class SistemaProducao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date data;
	private Double comprimento;
	private Double largura;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
		
	@JsonManagedReference
	@OneToMany(mappedBy="sistema")
	private List<Canteiro> canteiros  = new ArrayList<>();
	
	public SistemaProducao() {
		
	}

	public SistemaProducao(Integer id, String nome, Date data, Double comprimento, Double largura, Usuario usuario) {
		super();
		this.id = id;
		this.nome=nome;
		this.data = data;
		this.comprimento=comprimento;
		this.largura=largura;
		this.usuario=usuario;
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


	public List<Canteiro> getCanteiros() {
		return canteiros;
	}

	public void setCanteiros(List<Canteiro> canteiros) {
		this.canteiros = canteiros;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
		SistemaProducao other = (SistemaProducao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
