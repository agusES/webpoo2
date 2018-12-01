/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencePackage;

import ar.edu.unnoba.poo2018.model.Objetivo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;



/**
 *
 * @author Balma
 */
@Stateless
public class ObjetivoBean {

    @PersistenceContext(unitName = "webpoo")
    EntityManager em;
    
    public List<Objetivo> getObjetivos() {
        Query q = em.createNamedQuery("Objetivo.allOds");
        return q.getResultList();
    }
    
    public void create(Objetivo o) {
        em.persist(o);
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
