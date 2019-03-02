package ar.edu.unnoba.poo2018.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity(name = "convocatorias")
@Table(name = "Convocatorias")
@NamedQuery(name = "convocatoria.allConvocatorias", query = "SELECT c FROM convocatorias c")

public class Convocatoria {

	@Id
	@SequenceGenerator(name = "ID_CONVOCATORIA_SEQ", sequenceName = "SEQ_CONVOCATORIA", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_CONVOCATORIA_SEQ")
	private long nro;

	private String nombre;

	@Version
	protected int version;

	public Convocatoria() {
	}

	public Convocatoria(String nombre) {
		super();
		this.nombre = nombre;
	}

	public long getNro() {
		return nro;
	}

	public void setNro(long nro) {
		this.nro = nro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return String.format("%s[id=%d]", getClass().getSimpleName(), getNro());
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
            ? getNombre().equals(((Convocatoria) other).getNombre())
            : (other == this);
    }
}
