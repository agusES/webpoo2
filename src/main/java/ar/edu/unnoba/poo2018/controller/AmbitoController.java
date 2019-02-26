package ar.edu.unnoba.poo2018.controller;

import ar.edu.unnoba.poo2018.beans.AmbitoBean;
import ar.edu.unnoba.poo2018.model.Ambito;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "ambitoController")
@SessionScoped
public class AmbitoController {

    @EJB
    private AmbitoBean ambitob;

    private String nombre;

	public List<Ambito> getAmbitos() {
		return ambitob.getAmbitos();
	}

	public void crear() {
		try {
			Ambito a = new Ambito(nombre);
			ambitob.create(a);
		} catch (Exception e) {
			System.out.print("Algo salió mal en AmbitoController.crear()");
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
