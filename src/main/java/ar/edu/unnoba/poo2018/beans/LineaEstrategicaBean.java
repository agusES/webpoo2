/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unnoba.poo2018.beans;

import ar.edu.unnoba.poo2018.model.LineaEstrategica;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Balma
 */
@Stateless
public class LineaEstrategicaBean {

    @PersistenceContext(unitName = "webpoo")
    EntityManager em;

}
