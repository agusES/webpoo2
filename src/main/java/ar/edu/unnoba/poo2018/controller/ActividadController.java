package ar.edu.unnoba.poo2018.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ar.edu.unnoba.poo2018.beans.ActividadBean;
import ar.edu.unnoba.poo2018.model.Actividad;


@ManagedBean(name = "actividadController")
@SessionScoped
public class ActividadController implements Serializable {
	
	@EJB
    private ActividadBean actividadb;

	private static final long serialVersionUID = 1L;
	
	public List<Actividad> getActividades() {
		System.out.print("ActividadController.getActividades()");
		return actividadb.getActividades();
	}
}
