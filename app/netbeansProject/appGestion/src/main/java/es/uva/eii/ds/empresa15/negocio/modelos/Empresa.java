package es.uva.eii.ds.empresa15.negocio.modelos;

/**
 *Implementacion de Empresa
 * 
 * @author mariher
 */
public class Empresa extends Usuario{
    
    /**
     * Inicializacion de una empresa
     * @param nifCif nif o cif
     * @param nombre nombre
     * @param direccionPostal direccion postal
     * @param direccionElectronica direccion electronica
     * @param telefono telefono
     */
    public Empresa(String nifCif, String nombre, String direccionPostal, String direccionElectronica, String telefono) {
        super(nifCif, nombre, direccionPostal, direccionElectronica, telefono);
    }
    
    /**
     * Inicializacion de una empresa mediante json
     * @param jsonStr json de una empresa
     */
    public Empresa(String jsonStr) {
        super(jsonStr);
    }
}
