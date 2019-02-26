package ar.edu.unnoba.poo2018.controller;

import ar.edu.unnoba.poo2018.beans.LineaEstrategicaBean;
import ar.edu.unnoba.poo2018.model.LineaEstrategica;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "lineaEstrategicaController")
@SessionScoped
public class LineaEstrategicaController {

	@EJB
	private LineaEstrategicaBean lineaEstrategicab;

	private String nombre;

	public List<LineaEstrategica> getLineas() {
		return lineaEstrategicab.getLineas();
	}

	public void crear() {
		try {
			LineaEstrategica l = new LineaEstrategica(nombre);
			lineaEstrategicab.create(l);
		} catch (Exception e) {
			System.out.print("Algo salió mal en LineaEstrategicaController.crear()");
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
