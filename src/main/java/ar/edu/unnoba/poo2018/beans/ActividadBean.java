package ar.edu.unnoba.poo2018.beans;

import ar.edu.unnoba.poo2018.model.Actividad;
import java.util.ArrayList;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ActividadBean {

    @PersistenceContext(unitName = "webpoo")
    EntityManager em;

    @SuppressWarnings("unchecked")
    public List<Actividad> getActividades() {
        System.out.print("ActividadBean.getActividades()");
//    	Query query = em.createNamedQuery("actividad.getActividades");
        Query query = em.createQuery("SELECT a FROM actividades a");
        return query.getResultList();
    }
    /*Rotorna una lista de las actividades que tiene 
    como responsable al usuario con id = idUsuario*/
    public List<Actividad> getActividades(Long idUsuario) {
        Query query = em.createQuery("SELECT ac FROM actividades ac JOIN ac.responsables r where r.id=:idUsuario");
        query.setParameter("idUsuario", idUsuario);
        List<Actividad> actividadesPorUsuario = new ArrayList<Actividad>();
        try {
            actividadesPorUsuario =query.getResultList();
            System.out.println(actividadesPorUsuario);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return actividadesPorUsuario;
    }
    
    public void create(Actividad act) {
        em.persist(act);
    }

    public void Update(Actividad act) {
        try{
            em.merge(act);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        } 

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
