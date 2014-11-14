package br.senai.sc.anuncios.app;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Anuncio implements Serializable{
	
	private static final long serialVersionUID = 5822085296989928453L;

	@JsonProperty
	public long indice;
	
	@JsonProperty
	public Usuario usuario;
	
	@JsonProperty
	public String titulo;
	
	@JsonProperty
	public String texto;
	
	@JsonProperty
	public Long dataCadastroMillis;
}
