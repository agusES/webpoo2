package ar.edu.unnoba.poo2018.controller;

import ar.edu.unnoba.poo2018.beans.ObjetivoBean;
import ar.edu.unnoba.poo2018.model.Objetivo;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "objetivoController")
@SessionScoped
public class ObjetivoController {

	@EJB
	private ObjetivoBean objetivob;
	
    @PostConstruct
    public void init() {
    	objetivob.create(new Objetivo("Fin de la pobreza"));
    	objetivob.create(new Objetivo("Hambre cero"));
    	objetivob.create(new Objetivo("Salud y Bienestar"));
    }

	public List<Objetivo> getObjetivob() {
		return objetivob.getObjetivos();
	}	
    	
//    	private final static List<Objetivo> objetivos = new ArrayList<>();
//    	static {
//    		objetivos.add(new Objetivo("Fin de la pobreza"));
//    		objetivos.add(new Objetivo("Hambre cero"));
//    		objetivos.add(new Objetivo("Salud y Bienestar"));
//        	objetivos[3] = "Educación de calidad";
//        	objetivos[4] = "Igualdad de género";
//        	objetivos[5] = "Agua limpia y Saneamiento";
//        	objetivos[6] = "Energía asequible y no contaminante";
//        	objetivos[7] = "Trabajo decente y crecimiento económico";
//        	objetivos[8] = "Industria, innovación e infraestructura";
//        	objetivos[9] = "Reducción de las desigualdades";
//        	objetivos[10] = "Ciudades y comunidades sostenibles";
//        	objetivos[11] = "Producción y consumo responsables";
//        	objetivos[12] = "Acción por el clima";
//        	objetivos[13] = "Vida submarina";
//        	objetivos[14] = "Vida de ecosistemas terrestres";
//        	objetivos[15] = "Paz, justicia e instituciones sólidas";
//        	objetivos[16] = "Alianzas para lograr los Objetivos";
//    	}
//    }
//


}
