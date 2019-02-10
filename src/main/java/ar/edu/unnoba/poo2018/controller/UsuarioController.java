/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unnoba.poo2018.controller;

import ar.edu.unnoba.poo2018.model.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.ejb.EJB;
import persistencePackage.UsuarioBean;

/**
 *
 * @author Balma
 */
@ManagedBean(name = "usuarioController")
@RequestScoped
public class UsuarioController {

    @EJB
    private UsuarioBean userb;
    private boolean administrador;
    private String name;
    private String password;

    public String register() {
        userb.create(new Usuario(name, password, administrador));
        return "success";
    }

    public String logout() {
        return "logout";
    }

    public String inicio() {
        return "inicio.xhtml?faces-redirect=true";
    }

    public String login() {
        Usuario authuser = userb.findByUser(name, password);
             
        if (authuser != null) {
            if (authuser.isAdministrador() == true) {
                return "successAdmin";
            } else {
                return "successUser";
            }   
        }
        return "invalid";
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
