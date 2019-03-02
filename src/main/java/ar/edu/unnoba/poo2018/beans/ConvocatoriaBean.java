package ar.edu.unnoba.poo2018.beans;

import ar.edu.unnoba.poo2018.model.Convocatoria;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ConvocatoriaBean {

	@PersistenceContext(unitName = "webpoo")
	EntityManager em;

	public void create(Convocatoria c) {
		em.persist(c);
	}

	@SuppressWarnings("unchecked")
	public List<Convocatoria> getConvocatorias() {
		Query query = em.createNamedQuery("convocatoria.allConvocatorias");
		return query.getResultList();
	}
	
	public Convocatoria find(Object id) {
		return em.find(Convocatoria.class, id);
	}
}