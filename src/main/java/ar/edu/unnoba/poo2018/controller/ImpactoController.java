package ar.edu.unnoba.poo2018.controller;

import ar.edu.unnoba.poo2018.beans.ImpactoBean;
import ar.edu.unnoba.poo2018.model.Impacto;
import ar.edu.unnoba.poo2018.model.Objetivo;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "impactoController")
@SessionScoped
public class ImpactoController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int peso;
	private Objetivo objetivoSeleccionado;
	
	@EJB
    private ImpactoBean impactob;
	
	public void crear() {
		try {
			Impacto i = new Impacto(getPeso(), getObjetivoSeleccionado());
			impactob.create(i);
		} catch (Exception e) {
			System.out.print("Algo salió mal en ImpactoController.crear()");
		}
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
