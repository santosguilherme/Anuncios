package br.senai.sc.anuncios.web.entidades;

import java.io.Serializable;
import java.util.Date;

import com.google.gson.annotations.Expose;

public class Anuncio implements Serializable {

	private static final long serialVersionUID = -2695197813207977947L;
	
	@Expose
	private Long indice;
	
	@Expose
	private Usuario usuario;
	
	@Expose
	private String titulo;
	
	@Expose
	private String texto;
	
	@Expose
	private Date dataCadastro;

	public Long getIndice() {
		return indice;
	}

	public void setIndice(Long indice) {
		this.indice = indice;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

}
