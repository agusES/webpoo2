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

    public List<Objetivo> getAllObjetivos() {
        Query query = em.createNamedQuery("objetivo.allObjetivos");
        return query.getResultList();
    }

    public void create(Objetivo o) {
        em.persist(o);
        System.out.println("El objetivo" + o + "fue creado.");
    }

    public void update(Objetivo o) {
        em.merge(o);
    }

    public void remove(Objetivo o) {
        System.out.print("ObjetivoBean.remove(). Objetivo = " + o);
        em.remove(em.merge(o));
        System.out.print("Pasó el remove. Objetivo = " + o);
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
