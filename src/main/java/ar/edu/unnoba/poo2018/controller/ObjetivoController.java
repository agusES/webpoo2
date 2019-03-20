package ar.edu.unnoba.poo2018.controller;

import ar.edu.unnoba.poo2018.beans.ObjetivoBean;
import ar.edu.unnoba.poo2018.model.Objetivo;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

@ManagedBean(name = "objetivoController")
@SessionScoped
public class ObjetivoController implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nombre;

	@EJB
	private ObjetivoBean objetivob;
	
	public void crearObj() {
		try {
			Objetivo o = new Objetivo(nombre);
			objetivob.create(o);
			System.out.print("Se creó el objetivo " + o);
		} catch (Exception e) {
			System.out.print("Algo salió mal en ObjetivoController.crearObj()");
		}
	}

	public List<Objetivo> getObjetivos() {
		return objetivob.getAllObjetivos();
	}

    public void update(Objetivo obj){
        try{
        	System.out.println("Se actualizará el objetivo con nombre" + obj);
            objetivob.update(obj);
            System.out.println("Ahora obj = " + obj);
        }catch(Exception e){
        	System.out.println("Algo salió mal en ObjetivoController.update()");
        }
    }

	public void delete(Objetivo obj) {
		System.out.print("entramos a ObjetivoController.delete(). Objetivo = " + obj);
//		if (!usuarioController.getUser().equals(user)) {
		objetivob.remove(obj);
//		} else {
//			FacesContext context = FacesContext.getCurrentInstance();
//			FacesMessage message = new FacesMessage("No puede borrar este usuario");
//			context.addMessage(null, message);
//		}
	}
	
    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Objetivo Edited", ((Objetivo) event.getObject()).getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Objetivo) event.getObject()).getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public ObjetivoBean getObjetivob() {
		return objetivob;
	}

	public void setObjetivob(ObjetivoBean objetivob) {
		this.objetivob = objetivob;
	}
}
