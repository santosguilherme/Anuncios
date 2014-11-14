package br.senai.sc.anuncios.web;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.senai.sc.anuncios.ejb.service.AnuncioService;
import br.senai.sc.anuncios.web.entidades.Anuncio;

@ManagedBean
@ViewScoped
public class AnunciosMBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@EJB
	private AnuncioService anuncioService; 

	private List<Anuncio> anuncios;

	private Anuncio anuncio;

	public void testeSalvar(){
		Anuncio a = new Anuncio();
		a.setTexto("txt");
		a.setTitulo("tlt");
		a.setDataCadastroMillis(10000L);

		anuncioService.salvarAnuncio(a);
	}

	public String dateToString(Long millis){
		return new SimpleDateFormat("dd/MM/yyy HH:mm").format(new Date(millis));
	}

	public List<Anuncio> getAnuncios() {
		this.anuncios = this.anuncioService.listaTodosAnuncios();
		return this.anuncios;
	}

	public void setAnuncios(List<Anuncio> anuncios) {
		this.anuncios = anuncios;
	}

	public Anuncio getAnuncio() {
		return this.anuncio;
	}

	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}
}