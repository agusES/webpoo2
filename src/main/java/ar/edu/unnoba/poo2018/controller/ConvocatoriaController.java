package ar.edu.unnoba.poo2018.controller;

import ar.edu.unnoba.poo2018.beans.ConvocatoriaBean;
import ar.edu.unnoba.poo2018.model.Convocatoria;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "convocatoriaController")
@SessionScoped
public class ConvocatoriaController {

    @EJB
    private ConvocatoriaBean convocatoriab;
    
	private String nombre;
    
    public List<Convocatoria> getConvocatorias() {
    	System.out.print("Llegamos a ConvocatoriaController.getConvocatorias().");
		return convocatoriab.getConvocatorias();
	}
    
	public void crear() {
		try {
			Convocatoria c = new Convocatoria(nombre);
			convocatoriab.create(c);
			System.out.print("Se creó la convocatoria " + c);
		} catch (Exception e) {
			System.out.print("Algo salió mal en ConvocatoriaController.crear()");
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
