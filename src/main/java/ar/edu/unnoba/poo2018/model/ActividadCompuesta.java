package ar.edu.unnoba.poo2018.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name = "actividades_compuestas")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class ActividadCompuesta extends Actividad implements Serializable {

    @JoinTable(
            name = "Actividades_Relacionadas",
            joinColumns = @JoinColumn(name = "actividad_compuesta_id"),
            inverseJoinColumns = @JoinColumn(name = "actividad_id"))
    @ManyToMany
    private List<Actividad> actividades;

    public ActividadCompuesta() {
    }

    public ActividadCompuesta(String nombre, Date fechaInicio, Date fechaFin, String resolucion, String expediente,
            Convocatoria convocatoria, LineaEstrategica linea, Ambito ambito, List<Actividad> actividades) {
        super(nombre, fechaInicio, fechaFin, resolucion, expediente, convocatoria, linea, ambito);
        this.actividades = actividades;

        /*
            setNombre(nombre);
            setFechaInicio(fechaInicio);
            setFechaFin(endDate);
            setResolucion(resolucion);
            setExpediente(expediente);
            setConvocatoria(convocatoria);
            setLinea(linea);
            setAmbito(ambito);
            setActividades(actividades);
         */
    }

    private class ImpactoEstategiaPromedio {

        private Objetivo objetivo;

        private int peso = 0;
        private int cantidad = 0;

        public ImpactoEstategiaPromedio(Objetivo o, int p) {
            objetivo = o;
            acumularPeso(p);
        }

        public void acumularPeso(int p) {
            peso += p;
            ++cantidad;
        }

        public Impacto aImpacto() {
            return new Impacto(peso / cantidad, objetivo);
        }
    }
    
    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        for (Actividad act : actividades) {
            this.actividades.add(act);
        }
        System.out.print(this.actividades);
    }

    public void addActividad(Actividad a) {
        actividades.add(a);
    }

    public void removeActividad(Actividad a) {
        actividades.remove(a);
    }

    public List<Impacto> getImpactos() {
        HashMap<Objetivo, ImpactoEstategiaPromedio> promedios = new HashMap<>();
        final List impactos = new ArrayList<Impacto>();

        for (Actividad a : actividades) {
            for (Impacto i : a.getImpactos()) {
                Objetivo o = i.getObjetivo();

                ImpactoEstategiaPromedio it = promedios.get(o);

                if (it == null) {
                    promedios.put(o, new ImpactoEstategiaPromedio(o, i.getPeso()));
                } else {
                    it.acumularPeso(i.getPeso());
                }
            }
        }

        Function<ImpactoEstategiaPromedio, Impacto> funcion = new Function<ImpactoEstategiaPromedio, Impacto>() {
            @Override
            public Impacto apply(ImpactoEstategiaPromedio t) {
                impactos.add(t.aImpacto());
                return t.aImpacto();
            }
        };

        // Lambda Expression
        // List<Impacto> impactos =
        // promedios.values().stream().map(ImpactosEstategiaPromedio ->
        // ImpactoEstategiaPromedio.aImpacto()).collect(Collectors.toList());
        return impactos;
    }

    @Override
    public String toString() {
        return "Compuesto: " + getNombre() + " [actividades=" + actividades + "]";
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
                ? getNombre().equals(((ActividadCompuesta) other).getNombre())
                : (other == this);
    }
    
    @Override
    public String tipo() {
        return "C";
    }
    
 
}
