package br.senai.sc.anuncios.ejb.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.senai.sc.anuncios.web.entidades.Anuncio;

import com.google.gson.Gson;

@Path("/anuncios/user/{id}")
public class AnuncioService {

	@PathParam("id")
	private long idUser;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveAnuncio(Anuncio anuncio) {

		return Response.ok(anuncio).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAnunciosForUser() {

		System.out.println(idUser);

		List<Anuncio> anuncios = new ArrayList<>();
		Anuncio ad = new Anuncio();
		ad.setIndice(1L);
		ad.setDataCadastro(new Date());
		ad.setTitulo("Anuncio #1");
		ad.setTexto("Este e o texto do anuncio");
		anuncios.add(ad);

		Gson lista = new Gson();
		String jsonLista = lista.toJson(anuncios);

		return Response.ok(jsonLista).build();
	}

}