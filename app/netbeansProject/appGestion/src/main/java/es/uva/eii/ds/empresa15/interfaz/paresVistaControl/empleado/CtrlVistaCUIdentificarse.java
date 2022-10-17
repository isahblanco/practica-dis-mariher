package es.uva.eii.ds.empresa15.interfaz.paresVistaControl.empleado;

import es.uva.eii.ds.empresa15.GestorInterfazUsuario;
import es.uva.eii.ds.empresa15.negocio.controladoresCasoUso.ControladorCUIdentificarse;
import es.uva.eii.ds.empresa15.serviciosComunes.excepciones.ConsultaSinResultadosExcepcion;
import es.uva.eii.ds.empresa15.serviciosComunes.excepciones.EmpleadoInactivoExcepcion;
import es.uva.eii.ds.empresa15.serviciosComunes.excepciones.FormatoCredencialesIncorrectoExcepcion;

/**
 *Implementacion de CtrlVistaCUIdentificarse
 * 
 * @author mariher
 */
public class CtrlVistaCUIdentificarse {
    
    private final VistaCUIdentificarse vista;
    private final ControladorCUIdentificarse controladorCU;
    private GestorInterfazUsuario sm;
    
    public CtrlVistaCUIdentificarse(VistaCUIdentificarse vista, ControladorCUIdentificarse controladorCU) {
        this.vista = vista;
        this.controladorCU = controladorCU;
        this.sm = GestorInterfazUsuario.getMachine();
    }
    
    /**
     * Obtiene el empleado y muestra las opciones de rol en funcion su rol
     * @param dni dni 
     * @param password contraseña
     */
    public void procesaEventoIdentificarse(String dni, char[] password) {       
        try {
            var e = controladorCU.procesaIdentificacion(dni, password);
            sm.setEmpleadoActual(e);
            vista.mostrarOpcionesRol(e);
            
        } catch (FormatoCredencialesIncorrectoExcepcion e) {
            vista.mostrarMensajeError("ERROR: Formato incorrecto");
        } catch (ConsultaSinResultadosExcepcion | EmpleadoInactivoExcepcion  e) {
            vista.mostrarMensajeError("ERROR: No existe ningún empleado con estas credenciales en el sistema");
        }
    }
    
    /**
     * Muestra la ventana del CU Registrar pedido de cliente
     */
    public void showRegistrarPedidoCliente() {
        sm.mostrarRegistrarPedidoCliente();
    }   
}
