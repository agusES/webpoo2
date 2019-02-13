/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unnoba.poo2018.controller;

import ar.edu.unnoba.poo2018.beans.ActividadCompuestaBean;
import ar.edu.unnoba.poo2018.model.ActividadCompuesta;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Balma
 */
@ManagedBean(name = "compuestoController")
@SessionScoped
public class ActividadCompuestaController {

    @EJB
    private ActividadCompuestaBean compuestob;

    private ActividadCompuesta actividadCompuesta = new ActividadCompuesta();
    private List<ActividadCompuesta> actividadCompuestas = new ArrayList<>();

    @PostConstruct
    public void init() {
        actividadCompuesta = new ActividadCompuesta();
        actividadCompuestas = new ArrayList<>();
    }

}
