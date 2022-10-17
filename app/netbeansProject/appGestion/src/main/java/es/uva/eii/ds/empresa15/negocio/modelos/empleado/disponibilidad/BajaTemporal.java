package es.uva.eii.ds.empresa15.negocio.modelos.empleado.disponibilidad;

import java.time.LocalDate;

/**
 * Implementacion de BajaTemporal
 * 
 * @author mariher
 */
public class BajaTemporal extends Disponibilidad {
    
    private LocalDate finalPrevisto;
    
    /**
     * Inicializacion de una baja temporal
     * @param comienzo fecha de comienzo
     * @param finalPrevisto fecha de finalizacion
     */
    public BajaTemporal(LocalDate comienzo, LocalDate finalPrevisto) {
        super(comienzo);
        this.finalPrevisto = finalPrevisto;
    }
    
    /**
     * Establece una fecha de fin
     * @param fin fecha de fin
     */
    public void setFin(LocalDate fin) {
        this.finalPrevisto = fin;
    }
    
    /**
     * Obtiene la fecha de fin
     * @return fecha de final previsto
     */
    public LocalDate getFinalPrevisto() {
        return finalPrevisto;
    }
}
