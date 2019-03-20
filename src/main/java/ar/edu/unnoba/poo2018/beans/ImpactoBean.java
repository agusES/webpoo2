package ar.edu.unnoba.poo2018.beans;

import ar.edu.unnoba.poo2018.model.Impacto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ImpactoBean {

    @PersistenceContext(unitName = "webpoo")
    EntityManager em;

    public void create(Impacto i) {
        em.persist(i);
        System.out.println("El impacto" + i + "fue creado.");
    }

    public float getImpacto(Long idObjetivo) {
        Query querySimple = em.createQuery("SELECT i.peso FROM Impacto i join i.objetivo o JOIN i.actSimple WHERE o.nro =:idObjetivo");
        Query queryCompuestas = em.createNativeQuery("Select i.peso from Impactos i join Actividades_Compuestas c join Actividades_Relacionadas ar where i.objetivo_id=? and c.id=ar.actividad_compuesta_id and i.actividad_id IN (select actividad_id from Actividades_Relacionadas ar2 where ar2.actividad_compuesta_id=c.id)");
        querySimple.setParameter("idObjetivo", idObjetivo);
        queryCompuestas.setParameter(1, idObjetivo);
        List<Integer> pesos;
        List<Integer> pesosCompuesta;
        float totalSimple;
        float totalPesoCompuesta;
        try {
            pesosCompuesta = queryCompuestas.getResultList();
            totalPesoCompuesta = this.obtenerPeso(pesosCompuesta);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            totalPesoCompuesta = 0;
        }
        try {
            pesos = querySimple.getResultList();
            totalSimple = this.suma(pesos);
        } catch (Exception e) {
            totalSimple = 0;
            System.out.println(e.getMessage());
        }
        System.out.print("Total peso compuestas = " + totalPesoCompuesta);
        System.out.print("Total peso simple = " + totalSimple);
        return (float) ((totalPesoCompuesta + totalSimple) * 0.1);
    }

    public float obtenerPeso(List<Integer> pesos) {
        Integer acumulador = 0;
        for (Integer peso : pesos) {
            acumulador += peso;
        }
        return acumulador / pesos.size();
    }

    public float suma(List<Integer> pesos) {
        Integer acumulador = 0;
        for (Integer p : pesos) {
            acumulador += p;
        }
        return acumulador;
    }

}
