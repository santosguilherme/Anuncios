package br.senai.sc.anuncios.web.entidades;

import java.io.Serializable;
import java.util.Calendar;

public class Anuncio implements Serializable {

	private static final long serialVersionUID = -2695197813207977947L;

	private Long indice;
	private Usuario usuario;
	private String titulo;
	private String texto;
	private Calendar dataCadastro;

	public Anuncio() {
	}

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

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

}
