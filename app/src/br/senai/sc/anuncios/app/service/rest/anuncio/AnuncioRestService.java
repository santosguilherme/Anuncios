package br.senai.sc.anuncios.app.service.rest.anuncio;

import java.util.List;

import org.androidannotations.annotations.rest.Accept;
import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Post;
import org.androidannotations.annotations.rest.Rest;
import org.androidannotations.api.rest.MediaType;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;

import br.senai.sc.anuncios.app.Anuncio;

@Rest(converters = { MappingJacksonHttpMessageConverter.class })	
@Accept(MediaType.APPLICATION_JSON)
public interface AnuncioRestService {

	@Get(value = "http://10.0.2.2:8080/web/rest/anuncios/user/{idUser}")
	public List<Anuncio> listarAnunciosUsuario(long idUser);
	
	@Post(value = "http://10.0.2.2:8080/web/rest/anuncios/user/{idUser}")
	public Anuncio salvarAnuncio(long idUser, Anuncio anuncio);
}