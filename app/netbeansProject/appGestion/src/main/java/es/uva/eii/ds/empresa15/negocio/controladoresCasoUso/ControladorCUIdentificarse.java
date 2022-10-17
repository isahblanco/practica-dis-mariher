package es.uva.eii.ds.empresa15.negocio.controladoresCasoUso;

import es.uva.eii.ds.empresa15.negocio.modelos.empleado.Empleado;
import es.uva.eii.ds.empresa15.serviciosComunes.excepciones.*;

/**
 * Implementacion de ControladorCUIdentificarse
 * 
 * @author mariher
 */
public class ControladorCUIdentificarse {

    // Nivel de clase
    private static ControladorCUIdentificarse controlador;

    public static ControladorCUIdentificarse getControlador() {
        if (controlador == null) {
            controlador = new ControladorCUIdentificarse();
        }
        return controlador;
    }

    // Nivel de instancia
    private ControladorCUIdentificarse() {

    }
    
    /**
     * Obtiene el empleado y si está activo se lo pasa a la vista
     * @param dni dni
     * @param password contraseña
     * @return empleado
     * @throws FormatoCredencialesIncorrectoExcepcion si el formato no es correcto
     * @throws EmpleadoInactivoExcepcion si el empleado está inactivo
     * @throws ConsultaSinResultadosExcepcion si no se encuentra al empleado en la base de datos
     */
    public Empleado procesaIdentificacion(String dni, char[] password)
            throws FormatoCredencialesIncorrectoExcepcion, EmpleadoInactivoExcepcion, ConsultaSinResultadosExcepcion {
        var dniValido = Empleado.esValidoDNI(dni);
        var passwordValido = Empleado.esValidoPassword(password);
        if (!(dniValido && passwordValido)) {
            throw new FormatoCredencialesIncorrectoExcepcion();
        }
        Empleado empleado;
        empleado = Empleado.getEmpleadoPorLoginYPassword(dni, new String(password));
        
        if (empleado.estaActivo()) {
            return empleado;
        } else {
            throw new EmpleadoInactivoExcepcion();
        }
    }
}
