package ar.edu.unnoba.poo2018.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.IndexColumn;

import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;

@Entity(name = "actividades")
@Table(name = "Actividades")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name = "getActividades", query = "SELECT a FROM actividades a")

public abstract class Actividad {

	@Id
	@SequenceGenerator(name = "ID_ACTIVIDAD_SEQ", sequenceName = "SEQ_ACTIVIDAD", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_ACTIVIDAD_SEQ")
	private long id;

	private String nombre;
	@Temporal(TemporalType.DATE)
	private Date fechaInicio;
	@Temporal(TemporalType.DATE)
	private Date fechaFin;
	private String resolucion;
	private String expediente;

	@ManyToOne(fetch = FetchType.EAGER)
	private Convocatoria convocatoria;
	@ManyToOne(fetch = FetchType.EAGER)
	private LineaEstrategica linea;
	@ManyToOne(fetch = FetchType.EAGER)
	private Ambito ambito;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinTable(name = "Responsables", joinColumns = @JoinColumn(name = "actividad_id"), inverseJoinColumns = @JoinColumn(name = "usuario_id"))
	@IndexColumn(name = "INDEX_COL")
	private List<Usuario> responsables = new ArrayList<>();

	@Version
	protected int version;

	public long getNro() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
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

	@Override
	public String toString() {
		return "Actividad [nro=" + id + ", nombre=" + nombre + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin
				+ ", resolucion=" + resolucion + ", expediente=" + expediente + ", convocatoria=" + convocatoria
				+ ", linea=" + linea + ", ambito=" + ambito + ", responsables=" + responsables + "]";
	}

	public String getNombreConvocatoria() {
		return getConvocatoria().getNombre();
	}

	public String getNombreLineaEstrategica() {
		return getLinea().getNombre();
	}

	public String getNombreAmbito() {
		return getAmbito().getNombre();
	}

	public abstract List<Impacto> getImpactos();

	public List<Usuario> getResponsables() {
		return responsables;
	}
	
	public void addUsuario(Usuario u) {
		System.out.print("Actividad.addUsuario()");		
		responsables.add(u);
                System.out.print("RESPONSABLES: " + getResponsables());
	}
	
        public List<String> responsablesToString () {
            List<String> responsablesToString = new ArrayList<>();
            for (Usuario usr:this.responsables) {
                responsablesToString.add(usr.getName());
            }
            return responsablesToString;
        }
        
	public void removeUsuario(Usuario u) {
		responsables.remove(u);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actividad other = (Actividad) obj;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
}
