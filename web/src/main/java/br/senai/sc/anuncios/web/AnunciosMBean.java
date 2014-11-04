package br.senai.sc.anuncios.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.senai.sc.anuncios.entidades.Anuncio;

@Named
@RequestScoped
public class AnunciosMBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Anuncio> anuncios;
	private Anuncio anuncio;
	
	public AnunciosMBean() {
	}
	
	@PostConstruct
	public void init(){
		this.anuncios = new ArrayList<>();
		Anuncio ad = new Anuncio();
		ad.setIndice(1L);
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		ad.setDataCadastro(cal);
		ad.setTitulo("Anúncio #1");
		ad.setTexto("Este é o texto do anúncio");
		getAnuncios().add(ad);
	}

	public List<Anuncio> getAnuncios() {
		return anuncios;
	}

	public void setAnuncios(List<Anuncio> anuncios) {
		this.anuncios = anuncios;
	}

	public Anuncio getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}

}
