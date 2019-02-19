package ar.edu.unnoba.poo2018.controller;

import ar.edu.unnoba.poo2018.beans.ActividadSimpleBean;
import ar.edu.unnoba.poo2018.model.ActividadSimple;
import ar.edu.unnoba.poo2018.model.Ambito;
import ar.edu.unnoba.poo2018.model.Convocatoria;
import ar.edu.unnoba.poo2018.model.LineaEstrategica;

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

	@EJB
	private ActividadSimpleBean simpleb;

//    private ActividadSimple actividadSimple = new ActividadSimple();
//    private List<ActividadSimple> actividadSimples = new ArrayList<>();
//
//    @PostConstruct
//    public void init() {
//        actividadSimple = new ActividadSimple();
//        actividadSimples = new ArrayList<>();
//    }

	public String create() {
		ActividadSimple act = new ActividadSimple(name, startDate, endDate, resolucion, expediente, convocatoria, linea,
				ambito);
		System.out.println("ActividadSimpleController.create(). " + act);
		simpleb.create(act);
		return "ok";
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

}
