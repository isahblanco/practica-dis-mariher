package es.uva.eii.ds.empresa15.negocio.modelos.empleado.vinculacion;

import java.time.LocalDate;

/**
 *Implementacion de VinculacionConLaEmpresa
 * 
 * @author mariher
 */
public abstract class VinculacionConLaEmpresa {

    private LocalDate fecha;
    
    /**
     * Inicializador de una vinculacion
     * @param fecha fecha de vinculacion
     */
    public VinculacionConLaEmpresa(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    /**
     * Establece una fecha de vinculacion
     * @param fecha fecha de vinculacion
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    /**
     * Obtiene la fecha de vinculacion
     * @return fecha de vinculacion
     */
    public LocalDate getFecha() {
        return fecha;
    }
}
