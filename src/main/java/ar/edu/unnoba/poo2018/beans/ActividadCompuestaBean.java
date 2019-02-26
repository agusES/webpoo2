package ar.edu.unnoba.poo2018.beans;

import ar.edu.unnoba.poo2018.model.ActividadCompuesta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ActividadCompuestaBean {

    @PersistenceContext(unitName = "webpoo")
    EntityManager em;

}
