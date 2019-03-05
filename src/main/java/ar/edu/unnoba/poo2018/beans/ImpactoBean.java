package ar.edu.unnoba.poo2018.beans;

import ar.edu.unnoba.poo2018.model.Impacto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ImpactoBean {

    @PersistenceContext(unitName = "webpoo")
    EntityManager em;

	public void create(Impacto i) {
		em.persist(i);
        System.out.println("El impacto" + i + "fue creado.");
	}

}
