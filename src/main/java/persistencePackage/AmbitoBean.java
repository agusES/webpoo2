/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencePackage;

import ar.edu.unnoba.poo2018.model.Ambito;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Balma
 */
@Stateless
public class AmbitoBean {

    @PersistenceContext(unitName = "webpoo")
    EntityManager em;

}
