package ar.edu.unnoba.poo2018.controller;

import ar.edu.unnoba.poo2018.beans.ActividadSimpleBean;
import ar.edu.unnoba.poo2018.model.ActividadSimple;
import ar.edu.unnoba.poo2018.model.Ambito;
import ar.edu.unnoba.poo2018.model.Convocatoria;
import ar.edu.unnoba.poo2018.model.LineaEstrategica;
import ar.edu.unnoba.poo2018.model.Objetivo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ejb.EJB;
import java.util.Date;

@ManagedBean(name = "actividadSimpleController")
@SessionScoped
public class ActividadSimpleController {
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

	@EJB
	private ActividadSimpleBean simpleb;

	public void create() {
		try {
			System.out.println("ActividadSimpleController.create()");
			ActividadSimple act = new ActividadSimple(name, startDate, endDate, resolucion, expediente, convocatoria, linea, ambito, peso, objetivoSeleccionado);
			System.out.println("Actividad que se intenta crear: " + act);
			simpleb.create(act);
		} catch (Exception e) {
			System.out.print("Algo salió mal en ObjetivoController.crearObj()");
		}
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
		System.out.print("Se recibió la convocatoria " + convocatoria);
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
        
}
