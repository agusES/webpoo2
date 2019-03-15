package ar.edu.unnoba.poo2018.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name = "ActividadesSimples")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
@NamedQueries({
    @NamedQuery(name = "actividadsimple.getAllActividadSimple",
            query = "Select a From ActividadSimple a")
})

public class ActividadSimple extends Actividad implements Serializable {
    
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "actividad")
        @IndexColumn(name = "INDEX_COL")
	private List<Impacto> impactos = new ArrayList<Impacto>();
	
	public ActividadSimple() {
	}

	public ActividadSimple(String nombre, Date fechaInicio, Date fechaFin, String resolucion, String expediente,
			Convocatoria convocatoria, LineaEstrategica linea, Ambito ambito, int peso, Objetivo objetivoSeleccionado) {
		setNombre(nombre);
		setFechaInicio(fechaInicio);
		setFechaFin(fechaFin);
		setResolucion(resolucion);
		setExpediente(expediente);
		setConvocatoria(convocatoria);
		setLinea(linea);
		setAmbito(ambito);
		addI(peso, objetivoSeleccionado);		
	}

	public void addI(int peso, Objetivo objetivo) {
		impactos.add(new Impacto(peso, objetivo));
	}

	@Override
	public List<Impacto> getImpactos() {
		return impactos;
	}

	public void setImpactos(List<Impacto> impactos) {
		this.impactos = impactos;
	}

	@Override
	public String toString() {
		return "Simple: " + getNombre() + " [impactos=" + impactos + "]";
	}
        @Override
        public List<String> responsablesToString () {
            List<String> responsablesToString = new ArrayList<>();
            for (Usuario usr:super.getResponsables()) {
                responsablesToString.add(usr.getName());
            }
        return responsablesToString;
        }

        
    @Override
    public int hashCode() {
        return (getNombre() != null) 
            ? (getClass().getSimpleName().hashCode() + getNombre().hashCode())
            : super.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        return (other != null && getNombre() != null
                && other.getClass().isAssignableFrom(getClass()) 
                && getClass().isAssignableFrom(other.getClass())) 
            ? getNombre().equals(((ActividadSimple) other).getNombre())
            : (other == this);
    }
        
        
}
