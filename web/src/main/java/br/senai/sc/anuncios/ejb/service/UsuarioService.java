package br.senai.sc.anuncios.ejb.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.senai.sc.anuncios.web.entidades.Usuario;

@Stateless(name = "UsuarioService")
public class UsuarioService {

	@PersistenceContext(name = "principal", unitName = "web-pu")
	private EntityManager entityManager;

	public Usuario buscar(final Long indice) {
		String strQuery = "SELECT us FROM Usuario us WHERE us.id = :indice";
		TypedQuery<Usuario> query = entityManager.createQuery(strQuery,	Usuario.class);
		query.setParameter("indice", indice);

		if (query.getResultList().isEmpty()) {
			return null;
		}
		return query.getResultList().get(0);
	}
}