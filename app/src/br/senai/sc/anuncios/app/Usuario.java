package br.senai.sc.anuncios.app;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Usuario implements Serializable {

	private static final long serialVersionUID = 5822085296989928453L;
	
	@JsonProperty
	public Long indice;
	
	@JsonProperty
	public String email;
	
	@JsonProperty
	public String senha;
	
	@JsonProperty
	public Boolean ativo;
}
