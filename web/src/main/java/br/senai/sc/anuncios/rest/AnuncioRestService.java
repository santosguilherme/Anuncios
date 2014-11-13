package br.senai.sc.anuncios.rest;

import java.util.Date;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.senai.sc.anuncios.ejb.service.AnuncioService;
import br.senai.sc.anuncios.ejb.service.UsuarioService;
import br.senai.sc.anuncios.web.entidades.Anuncio;
import br.senai.sc.anuncios.web.entidades.Usuario;

import com.google.gson.Gson;

@Path("/anuncios/user/{id}")
public class AnuncioRestService extends AnuncioService {

	@PathParam("id")
	private long idUser;

	@EJB(name = "UsuarioService")
	private UsuarioService usuarioService;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveAnuncio(Anuncio anuncio) {
		Anuncio salvo = this.salvarAnuncio(anuncio);
		if (salvo == null) {
			return Response.serverError().build();
		}
		return Response.ok(anuncio).build();
	}

	@Override
	public Anuncio salvarAnuncio(Anuncio anuncio) {
		Usuario user = getUsuarioService().buscar(idUser);
		if (user == null) {
			return null;
		}
		anuncio.setUsuario(user);
		anuncio.setDataCadastro(new Date());

		return super.salvarAnuncio(anuncio);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAnunciosForUser() {
		String jsonLista = new Gson().toJson(listarAnuncioDoUsuario(idUser));
		return Response.ok(jsonLista).build();
	}

	public UsuarioService getUsuarioService() {
		if (this.usuarioService == null) {
			try {
				this.usuarioService = (UsuarioService) new InitialContext().lookup("java:module/UsuarioService");
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		return usuarioService;
	}
}