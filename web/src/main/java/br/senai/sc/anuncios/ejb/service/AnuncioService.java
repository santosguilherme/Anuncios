package br.senai.sc.anuncios.ejb.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.senai.sc.anuncios.web.entidades.Anuncio;

@Stateless
public class AnuncioService {

	@PersistenceContext(unitName = "web-pu")
	private EntityManager entityManager;

	public Anuncio salvarAnuncio(Anuncio anuncio) {
		try {
			if (null != anuncio.getIndice()) {
				entityManager.merge(anuncio);
			} else {
				entityManager.persist(anuncio);
			}
			entityManager.flush();
			entityManager.clear();

			return anuncio;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Anuncio> listarAnuncioDoUsuario(final Long idUsario){
		String strQuery = "SELECT a FROM Anuncio a WHERE a.usuario.indice = :ID ORDER BY a.indice DESC";
        TypedQuery<Anuncio> query = entityManager.createQuery(strQuery, Anuncio.class);
        query.setParameter("ID", idUsario);

        return query.getResultList();
	}
	
	public List<Anuncio> listaTodosAnuncios(){
		return entityManager.createQuery("from Anuncio", Anuncio.class).getResultList();
	}
}