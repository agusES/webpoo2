package ar.edu.unnoba.poo2018.controller;

import ar.edu.unnoba.poo2018.beans.ObjetivoBean;
import ar.edu.unnoba.poo2018.model.Objetivo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "objetivoController")
@RequestScoped
public class ObjetivoController implements Serializable  {
    
    private String nombre;

    @EJB
    private ObjetivoBean objetivob;
    
    private List<Objetivo> objetivos = new ArrayList<>();
    
    @PostConstruct
    public void init() {
       // objetivo = new Objetivo();
    }

    public String crearObj(){
        try{
            System.out.println("-----------------------crearObj()");
            Objetivo o = new Objetivo(nombre);
            objetivob.create(o);
            System.out.println(o);
            System.out.println("----------------------- FIN - crearObj()");
        }catch(Exception e){
            System.out.println("-----------------------ERROR crearObj()");
            e.printStackTrace();
            System.out.println("-----------------------FIN ERROR - crearObj()");
            return "fallo";
        }

        System.out.println("-----------------------");
        System.out.println(nombre);
        System.out.println("-----------------------");
        return "exito";
    }
     
    public List<Objetivo> getObjetivos() {
        return objetivob.getAllObjetivos();
    }
    
   
    
    //
    
//    public String update(){
//        try{
//            objetivob.update(objetivo);
//            return "/users/index?faces-redirect=true";
//        }catch(Exception e){
//            return null;
//        }
//    }
    
    public void delete(Objetivo obj){
       // if(!sessionBacking.getUser().equals(user)){
            objetivob.remove(obj);
        /*}else{
           FacesContext context = FacesContext.getCurrentInstance();
           FacesMessage message = new FacesMessage("No puede borrar este usuario");
           context.addMessage(null, message);
        }*/
    } 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    //
    
    
}
