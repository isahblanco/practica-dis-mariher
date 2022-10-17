package es.uva.eii.ds.empresa15;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;

import es.uva.eii.ds.empresa15.interfaz.paresVistaControl.empleado.VistaCUIdentificarse;
import es.uva.eii.ds.empresa15.interfaz.paresVistaControl.empleado.gerenteVentas.VistaCURegistrarPedidoCliente;
import es.uva.eii.ds.empresa15.negocio.modelos.empleado.Empleado;

/**
 * Singleton
 * 
 * @author mariher
 */
public class GestorInterfazUsuario {
    private JFrame currentState;
    private Empleado empleadoActual;

    //Nivel de clase
    private static GestorInterfazUsuario maquinaDeEstados;

    public static GestorInterfazUsuario getMachine() {
        if (maquinaDeEstados == null) {
            maquinaDeEstados = new GestorInterfazUsuario();
        }
        return maquinaDeEstados;
    }

    //Nivel de instancia

    private GestorInterfazUsuario() {

    }
    
    /**
     * Centra las ventanas en una posicion concreta
     */
    public void center() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - currentState.getWidth()) / 2;
        int y = (screenSize.height - currentState.getHeight()) / 2;
        currentState.setLocation(new Point(x, y));
        currentState.setVisible(true);
    }
    
    /** 
     * Muestra la ventana de identificarse
     */
    public void mostrarIdentificarse() {
        java.awt.EventQueue.invokeLater(() -> {
            if (currentState != null) {
                currentState.dispose();
                empleadoActual = null;
            }
            currentState = new VistaCUIdentificarse();
            center();
        });
    }
    
    /**
     * Muestra la ventana de opciones de rol
     */
    public void mostrarOpcionesRol() {
        java.awt.EventQueue.invokeLater(() -> {
            if (currentState != null) {
                currentState.dispose();
            }
            currentState = new VistaCUIdentificarse(this.empleadoActual);
            center();
        });
    }
    
    /**
     * Muestra la ventana de registrar pedido de cliente
     */
    public void mostrarRegistrarPedidoCliente(){
        java.awt.EventQueue.invokeLater(() -> {
            if (currentState != null) {
                currentState.dispose();
            }
            currentState = new VistaCURegistrarPedidoCliente();
            center();
        });
    }
    
    /**
     * Obtiene el empleado que se ha identificado
     * @return empleado actual
     */
    public Empleado getEmpleadoActual() {
        return empleadoActual;
    }
    
    /**
     * Establece un empleado
     * @param empleadoActual empleado a establecer
     */
    public void setEmpleadoActual(Empleado empleadoActual) {
        this.empleadoActual = empleadoActual;
    }
}
