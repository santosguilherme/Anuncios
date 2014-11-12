package br.senai.sc.anuncios.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.senai.sc.anuncios.web.entidades.Anuncio;

@ManagedBean
public class AnunciosMBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Anuncio> anuncios;
	
	private Anuncio anuncio;
	
	public AnunciosMBean() {
	}
	
	public List<Anuncio> getAnuncios() {
		if(this.anuncios == null){
			this.anuncios = new ArrayList<>();
			Anuncio ad = new Anuncio();
			ad.setIndice(1L);
			ad.setDataCadastro(new Date());
			ad.setTitulo("Anuncio #1");
			ad.setTexto("Este e o texto do anuncio");
			anuncios.add(ad);
		}
		return anuncios;
	}

	public void setAnuncios(List<Anuncio> anuncios) {
		this.anuncios = anuncios;
	}

	public Anuncio getAnuncio() {
		Anuncio ad = new Anuncio();
		ad.setIndice(1L);
		ad.setDataCadastro(new Date());
		ad.setTitulo("An�ncio #1");
		ad.setTexto("Este � o texto do an�ncio");
		
		return ad;
		//return anuncio;
	}

	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}

}
