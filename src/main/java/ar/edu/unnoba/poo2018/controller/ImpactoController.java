/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unnoba.poo2018.controller;

import ar.edu.unnoba.poo2018.beans.ImpactoBean;
import ar.edu.unnoba.poo2018.model.Impacto;
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
@ManagedBean(name = "impactoController")
@SessionScoped
public class ImpactoController {

    @EJB
    private ImpactoBean impactob;

    private Impacto impacto = new Impacto();
    private List<Impacto> impactos = new ArrayList<>();

    @PostConstruct
    public void init() {
        impacto = new Impacto();
        impactos = new ArrayList<>();
    }

}
