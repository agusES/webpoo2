package ar.edu.unnoba.poo2018.beans;

import ar.edu.unnoba.poo2018.model.Actividad;
//import ar.edu.unnoba.poo2018.model.ActividadSimple;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ActividadSimpleBean {

    @PersistenceContext(unitName = "webpoo")
    EntityManager em;
    
    public void create(Actividad act) {
        em.persist(act);
    }

    public void Update(Actividad act) {
        em.merge(act);
    }

    public void remove(Actividad act) {
        em.remove(em.merge(act));
    }
    
     public Actividad find(Object id) {
        return em.find(Actividad.class, id);
    }
     
    public Actividad findByName(String name) {
        Query query = em.createQuery("SELECT a FROM Actividad a where a.nombre = :value1");
        query.setParameter("value1", name);
        Actividad actividadq;
        try {
            actividadq = (Actividad) query.getSingleResult();
        } catch (Exception e) {
            actividadq = null;
        }
        return actividadq;
    }
}