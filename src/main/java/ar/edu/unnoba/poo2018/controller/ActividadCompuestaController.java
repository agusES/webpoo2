/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unnoba.poo2018.controller;

import ar.edu.unnoba.poo2018.beans.ActividadCompuestaBean;
import ar.edu.unnoba.poo2018.model.Actividad;
import ar.edu.unnoba.poo2018.model.ActividadCompuesta;
import ar.edu.unnoba.poo2018.model.Ambito;
import ar.edu.unnoba.poo2018.model.Convocatoria;
import ar.edu.unnoba.poo2018.model.LineaEstrategica;
import ar.edu.unnoba.poo2018.model.Objetivo;
import ar.edu.unnoba.poo2018.model.Usuario;
import java.util.Date;
import java.util.List;
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

    /*
    private ActividadCompuesta actividadCompuesta = new ActividadCompuesta();
    private List<ActividadCompuesta> actividadCompuestas = new ArrayList<>();

    @PostConstruct
    public void init() {
        actividadCompuesta = new ActividadCompuesta();
        actividadCompuestas = new ArrayList<>();
    }
     */
    private String name;
    private Date startDate;
    private Date endDate;
    private String resolucion;
    private String expediente;
    private Convocatoria convocatoria;
    private LineaEstrategica linea;
    private Ambito ambito;

    private int peso;
    private Objetivo objetivoSeleccionado;
    private Usuario usuarioSeleccionado;

    private List<Actividad> actividades;

    @EJB
    private ActividadCompuestaBean compb;

    public List<Actividad> getActividades() {
        return this.actividades;
    }

    public void setActividades(List<Actividad> acts) {
        this.actividades = acts;
    }

    public void addActividad(Actividad act) {
        this.actividades.add(act);
    }

    public void removeActividad(Actividad act) {
        this.actividades.remove(act);
    }

    public void create() {
        /*
            try {
                ActividadCompuesta act = new ActividadCompuesta(name, startDate, endDate, resolucion, expediente, convocatoria, linea, ambito, actividades);
                System.out.println("ActividadCompuestaController.create(). Actividad que se intenta crear: " + act);
                compb.create(act);
            } catch (Exception e) {
                System.out.print("Algo salió mal en ActividadCompuestaController.create()" + e.getMessage());
            }*/
        
        ActividadCompuesta act = new ActividadCompuesta(name, startDate, endDate, resolucion, expediente, convocatoria, linea, ambito, actividades);
        compb.create(act);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public String getExpediente() {
        return expediente;
    }

    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }

    public Convocatoria getConvocatoria() {
        return convocatoria;
    }

    public void setConvocatoria(Convocatoria convocatoria) {
        System.out.print("Se recibió la convocatoria: " + convocatoria);
        this.convocatoria = convocatoria;
    }

    public LineaEstrategica getLinea() {
        return linea;
    }

    public void setLinea(LineaEstrategica linea) {
        this.linea = linea;
    }

    public Ambito getAmbito() {
        return ambito;
    }

    public void setAmbito(Ambito ambito) {
        this.ambito = ambito;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public Objetivo getObjetivoSeleccionado() {
        return objetivoSeleccionado;
    }

    public void setObjetivoSeleccionado(Objetivo objetivoSeleccionado) {
        this.objetivoSeleccionado = objetivoSeleccionado;
    }

    public Usuario getUsuarioSeleccionado() {
        return usuarioSeleccionado;
    }

    public void setUsuarioSeleccionado(Usuario usuarioResponsable) {
        this.usuarioSeleccionado = usuarioResponsable;
    }
}
