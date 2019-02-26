package ar.edu.unnoba.poo2018.beans;

import ar.edu.unnoba.poo2018.model.Ambito;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class AmbitoBean {

	@PersistenceContext(unitName = "webpoo")
	EntityManager em;

	public void create(Ambito a) {
		em.persist(a);
	}

	@SuppressWarnings("unchecked")
	public List<Ambito> getAmbitos() {
		Query query = em.createNamedQuery("ambito.all");
		return query.getResultList();
	}

}
