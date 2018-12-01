/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencePackage;

import ar.edu.unnoba.poo2018.model.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Balma
 */
@Stateless
public class UsuarioBean {

    @PersistenceContext(unitName = "webpoo")
    EntityManager em;

    public void create(Usuario user) {
        em.persist(user);
    }

    public void Update(Usuario user) {
        em.merge(user);
    }

    public void remove(Usuario user) {
        em.remove(em.merge(user));
    }

    public Usuario find(Object id) {
        return em.find(Usuario.class, id);
    }

    public Usuario findByUser(String name, String pass) {
        Query query = em.createQuery("SELECT u FROM Usuario u where u.name = :value1 and u.password= :value2");
        query.setParameter("value1", name);
        query.setParameter("value2", pass);
        Usuario userq;
        try {
            userq = (Usuario) query.getSingleResult();
        } catch (Exception e) {
            userq = null;
        }
        return userq;
    }
}
