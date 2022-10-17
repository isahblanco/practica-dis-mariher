package es.uva.eii.ds.empresa15.negocio.modelos.empleado.rol;

import java.time.LocalDate;

/**
 *Implementacion de Rol
 * 
 * @author mariher
 */
public class Rol {

    private final LocalDate comienzoEnRol;
    
    /**
     * Inicializador de un rol
     * @param comienzoEnRol fecha de comienzo
     */
    public Rol(LocalDate comienzoEnRol) {
        this.comienzoEnRol = comienzoEnRol;
    }
    
    /**
     * Devuelve la fecha de comienzo
     * @return fecha de comienzo
     */
    public LocalDate getComienzoEnRol() {
        return comienzoEnRol;
    }
}
