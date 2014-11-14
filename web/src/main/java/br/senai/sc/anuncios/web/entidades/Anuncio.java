package br.senai.sc.anuncios.web.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.google.gson.annotations.Expose;

@Entity
public class Anuncio implements Serializable {

	private static final long serialVersionUID = -2695197813207977947L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Expose
	private Long indice;

	@ManyToOne
	@Expose
	private Usuario usuario;

	@Expose
	private String titulo;

	@Column(columnDefinition = "TEXT")
	@Expose
	private String texto;

	@Expose
	private Long dataCadastroMillis;

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

	public Long getDataCadastroMillis() {
		return dataCadastroMillis;
	}

	public void setDataCadastroMillis(Long dataCadastroMillis) {
		this.dataCadastroMillis = dataCadastroMillis;
	}
}