package ar.edu.unnoba.poo2018.beans;

import ar.edu.unnoba.poo2018.model.Actividad;
import ar.edu.unnoba.poo2018.model.ActividadSimple;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ActividadSimpleBean {

    @PersistenceContext(unitName = "webpoo")
    EntityManager em;
    
    public void create(ActividadSimple act) {
        em.persist(act);
    }

    public void Update(ActividadSimple act) {
        em.merge(act);
    }

    public void remove(ActividadSimple act) {
        em.remove(em.merge(act));
    }
    
    public Actividad find(Object id) {
        return em.find(ActividadSimple.class, id);
    }
     
    public Actividad findByName(String name) {
        Query query = em.createQuery("SELECT a FROM ActividadesSimples a where a.nombre = :value1");
        query.setParameter("value1", name);
        Actividad actividadq;
        try {
            actividadq = (Actividad) query.getSingleResult();
        } catch (Exception e) {
            actividadq = null;
        }
        return actividadq;
    }
    
     public List getActividades(Long id) {
        Query query = em.createNativeQuery("SELECT * from Actividad a where a.id IN (select r.actividad_id from Responsables r where r.usuario_id=?) and a.id IN (select s.id from ActividadesSimples s)",ActividadSimple.class);
        query.setParameter(1, id);
        List<ActividadSimple> simpleList;
        try {
            simpleList = query.getResultList();
        } catch (Exception e) {
            simpleList = null;
        }
        return simpleList;
    }
    
    public List<ActividadSimple> getAll() {
        Query query = em.createNamedQuery("actividadsimple.getAllActividadSimple");
        return query.getResultList();
    }
}

