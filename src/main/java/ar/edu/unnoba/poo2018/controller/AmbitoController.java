/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unnoba.poo2018.controller;

import ar.edu.unnoba.poo2018.model.Ambito;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import persistencePackage.AmbitoBean;

/**
 *
 * @author Balma
 */
@ManagedBean(name = "ambitoController")
@SessionScoped
public class AmbitoController {

    @EJB
    private AmbitoBean ambitob;

    private Ambito ambito = new Ambito();
    private List<Ambito> ambitos = new ArrayList<>();

    @PostConstruct
    public void init() {
        ambito = new Ambito();
        ambitos = new ArrayList<>();
    }

}
