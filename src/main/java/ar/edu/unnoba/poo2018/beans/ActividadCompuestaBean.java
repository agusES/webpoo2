/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unnoba.poo2018.beans;

import ar.edu.unnoba.poo2018.model.ActividadCompuesta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Balma
 */
@Stateless
public class ActividadCompuestaBean {

    @PersistenceContext(unitName = "webpoo")
    EntityManager em;

}