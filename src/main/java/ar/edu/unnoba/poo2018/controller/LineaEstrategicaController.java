/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unnoba.poo2018.controller;

import ar.edu.unnoba.poo2018.model.LineaEstrategica;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import persistencePackage.LineaEstrategicaBean;

/**
 *
 * @author Balma
 */
@ManagedBean(name = "lineaEstrategicaController")
@SessionScoped
public class LineaEstrategicaController {

    @EJB
    private LineaEstrategicaBean lineaEstrategicab;

    private LineaEstrategica lineaEstrategica = new LineaEstrategica();
    private List<LineaEstrategica> lineaEstrategicas = new ArrayList<>();

    @PostConstruct
    public void init() {
        lineaEstrategica = new LineaEstrategica();
        lineaEstrategicas = new ArrayList<>();
    }

}
