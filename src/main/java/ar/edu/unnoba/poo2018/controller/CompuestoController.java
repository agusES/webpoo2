/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unnoba.poo2018.controller;

import ar.edu.unnoba.poo2018.beans.CompuestoBean;
import ar.edu.unnoba.poo2018.model.Compuesto;
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
public class CompuestoController {

    @EJB
    private CompuestoBean compuestob;

    private Compuesto compuesto = new Compuesto();
    private List<Compuesto> compuestos = new ArrayList<>();

    @PostConstruct
    public void init() {
        compuesto = new Compuesto();
        compuestos = new ArrayList<>();
    }

}
