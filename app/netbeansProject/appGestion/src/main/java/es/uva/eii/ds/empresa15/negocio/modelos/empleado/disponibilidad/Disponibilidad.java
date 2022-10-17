package es.uva.eii.ds.empresa15.negocio.modelos.empleado.disponibilidad;

import java.time.LocalDate;

/**
 * Implementacion de Disponibilidad
 * 
 * @author mariher
 */
public abstract class Disponibilidad {

    private LocalDate comienzo;
    
    /**
     * Inicializacion de una disponibilidad
     * @param comienzo fecha de comienzo
     */
    public Disponibilidad(LocalDate comienzo) {
        this.comienzo = comienzo;
    }
    
    /**
     * Establece una fecha de comienzo
     * @param comienzo fecha de comienzo
     */
    public void setComienzo(LocalDate comienzo) {
        this.comienzo = comienzo;
    }
    
    /**
     * Obtiene la fecha de comienzo
     * @return fecha de comienzo
     */
    public LocalDate getComienzo() {
        return comienzo;
    }
}
