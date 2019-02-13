package ar.edu.unnoba.poo2018.controller;

import ar.edu.unnoba.poo2018.beans.ActividadSimpleBean;
import ar.edu.unnoba.poo2018.model.ActividadSimple;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ejb.EJB;
import java.util.Date;

@ManagedBean(name="simple")
@SessionScoped
public class ActividadSimpleController {
	private String name;
	private Date startDate;
	private Date endDate;

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
    	System.out.println("fecha?");
    	System.out.println(startDate);
    	simpleb.create(new ActividadSimple(name, startDate));
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


}
