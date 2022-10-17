package es.uva.eii.ds.empresa15.negocio.modelos;

import java.util.ArrayList;

/**
 * Implementacion de Cliente
 * 
 * @author mariher
 */
public class Cliente extends Empresa{
    
    private ArrayList<PedidoPCs> pedidosEncargados;
    
    /**
     * Inicializacion de un cliente
     * @param nifCif cif
     * @param nombre nombre
     * @param direccionPostal direccion postal
     * @param direccionElectronica direccion electronica
     * @param telefono telefono
     */
    public Cliente(String nifCif, String nombre, String direccionPostal, String direccionElectronica, String telefono) {
        super(nifCif, nombre, direccionPostal, direccionElectronica, telefono);
        this.pedidosEncargados = new ArrayList<>();
    }
    
    /**
     * Inicializacion de un cliente mediante json
     * @param jsonStr json de un cliente
     */
    public Cliente(String jsonStr) {
        super(jsonStr);
        this.pedidosEncargados = new ArrayList<>();
    }
}
