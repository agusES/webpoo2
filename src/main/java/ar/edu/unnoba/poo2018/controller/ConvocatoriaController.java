/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unnoba.poo2018.controller;

import ar.edu.unnoba.poo2018.beans.ConvocatoriaBean;
import ar.edu.unnoba.poo2018.model.Convocatoria;
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
@ManagedBean(name = "convocatoriaController")
@SessionScoped
public class ConvocatoriaController {

    @EJB
    private ConvocatoriaBean convocatoriab;

    private Convocatoria convocatoria = new Convocatoria();
    private List<Convocatoria> convocatorias = new ArrayList<>();

    @PostConstruct
    public void init() {
        convocatoria = new Convocatoria();
        convocatorias = new ArrayList<>();
    }

}
