package ar.edu.unnoba.poo2018.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity(name = "objetivos")
@Table(name = "Objetivos")
@NamedQuery(name = "objetivo.allObjetivos", query = "SELECT o FROM objetivos o")

public class Objetivo {

	@Id
	@SequenceGenerator(name = "ID_OBJETIVO_SEQ", sequenceName = "SEQ_OBJETIVO", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_OBJETIVO_SEQ")
	private long nro;

	private String nombre;

	@Version
	protected int version;

	public Objetivo() {
	}

	public Objetivo(String name) {
		this.nombre = name;
	}

	public long getNro() {
		return nro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
//		return String.format("%s[id=%d]", getClass().getSimpleName(), getNro());
		return getNombre();
	}

	@Override
	public int hashCode() {
		return (getNombre() != null) ? (getClass().getSimpleName().hashCode() + getNombre().hashCode())
				: super.hashCode();
	}

	@Override
	public boolean equals(Object other) {
		return (other != null && getNombre() != null && other.getClass().isAssignableFrom(getClass())
				&& getClass().isAssignableFrom(other.getClass())) ? getNombre().equals(((Objetivo) other).getNombre())
						: (other == this);
	}
}
