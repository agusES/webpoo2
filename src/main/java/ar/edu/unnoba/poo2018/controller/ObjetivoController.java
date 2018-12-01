/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unnoba.poo2018.controller;

import ar.edu.unnoba.poo2018.model.Objetivo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.persistence.Query;
import persistencePackage.ObjetivoBean;

/**
 *
 * @author Balma
 */
@ManagedBean(name = "objetivoController")
@RequestScoped
public class ObjetivoController implements Serializable  {
    private Objetivo objetivo;
    
    @EJB
    private ObjetivoBean objetivob;
    
    private List<Objetivo> objetivos = new ArrayList<>();
    
    @PostConstruct
    public void init() {
        objetivo = new Objetivo();
    }

    public String crearObj(){
        try{
            objetivob.create(objetivo);
            System.out.println(objetivo);
        }catch(Exception e){
            System.out.println(objetivo);
            return "fallo";
        }
        return "exito";
    }
     
    public List<Objetivo> getObjetivos() {
        return objetivob.getAllObjetivos();
    }
    
    public Objetivo getObjetivo(){
        return objetivo;
    }
    
    public void setObjetivo(Objetivo o){
        this.objetivo = o;
    }
    
    //
    
    public String update(){
        try{
            objetivob.update(objetivo);
            return "/users/index?faces-redirect=true";
        }catch(Exception e){
            return null;
        }
    }
    
    public void delete(Objetivo obj){
       // if(!sessionBacking.getUser().equals(user)){
            objetivob.remove(obj);
        /*}else{
           FacesContext context = FacesContext.getCurrentInstance();
           FacesMessage message = new FacesMessage("No puede borrar este usuario");
           context.addMessage(null, message);
        }*/
        
    }
    //
    
    
}
