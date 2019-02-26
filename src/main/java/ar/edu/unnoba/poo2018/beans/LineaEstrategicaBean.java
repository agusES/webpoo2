package ar.edu.unnoba.poo2018.beans;

import ar.edu.unnoba.poo2018.model.LineaEstrategica;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class LineaEstrategicaBean {

    @PersistenceContext(unitName = "webpoo")
    EntityManager em;

    public void create(LineaEstrategica c) {
        em.persist(c);
    }
    
    @SuppressWarnings("unchecked")
	public List<LineaEstrategica> getLineas() {
    	Query query = em.createNamedQuery("linea.allLineas");
        return query.getResultList();
    }
}
