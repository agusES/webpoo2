package ar.edu.unnoba.poo2018.beans;

import ar.edu.unnoba.poo2018.model.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class UsuarioBean {

    @PersistenceContext(unitName = "webpoo")
    EntityManager em;

    public void create(Usuario user) {
        em.persist(user);
    }

    public void update(Usuario user) {
        em.merge(user);
    }

    public void remove(Usuario user) {
        em.remove(em.merge(user));
    }

    public Usuario find(Object id) {
        return em.find(Usuario.class, id);
    }

    public Usuario authUser(String name, String pass) {
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
    
    public boolean findUser(String name) {
        Query query = em.createQuery("SELECT u FROM Usuario u where u.name = :value1");
        query.setParameter("value1", name);
        Usuario userq;
        try {
            userq = (Usuario) query.getSingleResult();
            if (userq != null) {
            	return true;
            }
            
        } catch (Exception e) {
            userq = null;
        }
        return false;
    }
    
    @SuppressWarnings("unchecked")
	public List<Usuario> getAllUsers(){
        Query query = em.createNamedQuery("usuario.allUsuarios");
        return query.getResultList();
    }
}
