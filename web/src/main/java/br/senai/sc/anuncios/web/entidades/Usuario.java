package br.senai.sc.anuncios.web.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.google.gson.annotations.Expose;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Expose
	@Id
	private Long indice;
	private String email;
	private String senha;
	private Boolean ativo;

	public Usuario() {}

	public Long getIndice() {
		return indice;
	}

	public void setIndice(Long indice) {
		this.indice = indice;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

}
