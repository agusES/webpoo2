/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unnoba.poo2018.controller;

import ar.edu.unnoba.poo2018.model.Simple;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import persistencePackage.SimpleBean;

/**
 *
 * @author Balma
 */
@ManagedBean(name = "simpleController")
@SessionScoped
public class SimpleController {

    @EJB
    private SimpleBean simpleb;

    private Simple simple = new Simple();
    private List<Simple> simples = new ArrayList<>();

    @PostConstruct
    public void init() {
        simple = new Simple();
        simples = new ArrayList<>();
    }

}
