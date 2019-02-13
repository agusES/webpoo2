package ar.edu.unnoba.poo2018.beans;

import ar.edu.unnoba.poo2018.model.Objetivo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ObjetivoBean {

	@PersistenceContext(unitName = "webpoo")
	EntityManager em;

	public List<Objetivo> getObjetivos() {
		Query q = em.createQuery("SELECT o FROM Objetivo o");
		List<Objetivo> objetivosq;
		try {
			objetivosq = q.getResultList();
		} catch (Exception e) {
			objetivosq = null;
		}
		return objetivosq;
	}

	public void create(Objetivo o) {
		Query q = em.createQuery("SELECT o FROM Objetivo o where o.nombre = :value1");
		q.setParameter("value1", o.getNombre());
		Objetivo tmp;
		try {
			tmp = (Objetivo) q.getSingleResult();
		} catch (Exception e) {
			tmp = null;
		}
		if (tmp != null) {
			em.persist(o);
		}
	}

	public void Update(Objetivo o) {
		em.merge(o);
	}

	public void remove(Objetivo o) {
		em.remove(em.merge(o));
	}

	public Objetivo find(Object id) {
		return em.find(Objetivo.class, id);
	}

	public Objetivo findByName(String name) {
		Query query = em.createQuery("SELECT a FROM Actividad a where a.nombre = :value1");
		query.setParameter("value1", name);
		Objetivo objetivoq;
		try {
			objetivoq = (Objetivo) query.getSingleResult();
		} catch (Exception e) {
			objetivoq = null;
		}
		return objetivoq;
	}

}
