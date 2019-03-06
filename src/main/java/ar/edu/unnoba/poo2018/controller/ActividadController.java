package ar.edu.unnoba.poo2018.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ar.edu.unnoba.poo2018.beans.ActividadBean;
import ar.edu.unnoba.poo2018.model.Actividad;
import ar.edu.unnoba.poo2018.model.Usuario;

@ManagedBean(name = "actividadController")
@SessionScoped
public class ActividadController implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private ActividadBean actividadb;

	private Usuario usuarioResponsable;
	private Actividad actividadSeleccionada;

        /*
	public void asignarActividad() {
		System.out.print("ActividadController.asignarActividad()");
		actividadSeleccionada.addUsuario(usuarioResponsable);
	}
*/

	public List<Actividad> getActividades() {
		return actividadb.getActividades();
	}
        
        public void addUsuario() {
            this.actividadSeleccionada.addUsuario(usuarioResponsable);
            actividadb.Update(this.actividadSeleccionada);
            
        }


	public Usuario getUsuarioResponsable() {
		return usuarioResponsable;
	}
        

	public void setUsuarioResponsable(Usuario usuarioResponsable) {
		this.usuarioResponsable = usuarioResponsable;
	}

	public Actividad getActividadSeleccionada() {
		return actividadSeleccionada;
	}

	public void setActividadSeleccionada(Actividad actividadSeleccionada) {
		this.actividadSeleccionada = actividadSeleccionada;
	}
}
