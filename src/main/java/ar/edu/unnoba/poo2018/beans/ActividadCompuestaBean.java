package ar.edu.unnoba.poo2018.beans;

import ar.edu.unnoba.poo2018.model.Actividad;
import ar.edu.unnoba.poo2018.model.ActividadCompuesta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.persistence.Query;

@Stateless
public class ActividadCompuestaBean {

    @PersistenceContext(unitName = "webpoo")
    EntityManager em;

    public void create(ActividadCompuesta act) {
        em.persist(act);
    }

    public void Update(ActividadCompuesta act) {
        em.merge(act);
    }

    public void remove(ActividadCompuesta act) {
        em.remove(em.merge(act));
    }

    public ActividadCompuesta find(Object id) {
        return em.find(ActividadCompuesta.class, id);
    }

    public List getActividadesPorUsuario(Long id) {
        Query query = em.createNativeQuery("SELECT * from Actividad a where a.id IN (select r.actividad_id from Responsables r where r.usuario_id=?) and a.id IN (select c.id from Actividades_Compuestas c)", ActividadCompuesta.class);
        query.setParameter(1, id);
        List<ActividadCompuesta> CompuestoList;
        try {
            CompuestoList = query.getResultList();
        } catch (Exception e) {
            CompuestoList = null;
        }
        return CompuestoList;
    }

}
