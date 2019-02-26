package ar.edu.unnoba.poo2018.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity(name = "ambitos")
@Table(name = "ambitos")
@NamedQuery(name = "ambito.all", query = "SELECT a FROM ambitos a")

public class Ambito {

	@Id
	@SequenceGenerator(name = "ID_AMBITO_SEQ", sequenceName = "SEQ_AMBITO", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_AMBITO_SEQ")
	private long nro;

	private String nombre;

	@Version
	protected int version;

	public Ambito() {
	}

	public Ambito(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getNro() {
		return nro;
	}

	public void setNro(long nro) {
		this.nro = nro;
	}

	@Override
	public String toString() {
		return "Ambito [nro=" + nro + ", nombre=" + nombre + "]";
	}
}
