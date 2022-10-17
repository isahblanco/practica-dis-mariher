package es.uva.eii.ds.empresa15.negocio.modelos.empleado;

import java.io.StringReader;
import java.sql.Date;
import java.time.LocalDate;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonReaderFactory;

import es.uva.eii.ds.empresa15.negocio.modelos.Usuario;
import es.uva.eii.ds.empresa15.negocio.modelos.empleado.disponibilidad.BajaTemporal;
import es.uva.eii.ds.empresa15.negocio.modelos.empleado.disponibilidad.Disponibilidad;
import es.uva.eii.ds.empresa15.negocio.modelos.empleado.disponibilidad.Trabajando;
import es.uva.eii.ds.empresa15.negocio.modelos.empleado.disponibilidad.Vacaciones;
import es.uva.eii.ds.empresa15.negocio.modelos.empleado.rol.GerenteDeVentas;
import es.uva.eii.ds.empresa15.negocio.modelos.empleado.rol.PersonalAlmacen;
import es.uva.eii.ds.empresa15.negocio.modelos.empleado.rol.Rol;
import es.uva.eii.ds.empresa15.negocio.modelos.empleado.rol.TecnicoDelTaller;
import es.uva.eii.ds.empresa15.negocio.modelos.empleado.vinculacion.Contratado;
import es.uva.eii.ds.empresa15.negocio.modelos.empleado.vinculacion.Despedido;
import es.uva.eii.ds.empresa15.negocio.modelos.empleado.vinculacion.EnERTE;
import es.uva.eii.ds.empresa15.negocio.modelos.empleado.vinculacion.VinculacionConLaEmpresa;
import es.uva.eii.ds.empresa15.persistencia.daos.DAOEmpleado;
import es.uva.eii.ds.empresa15.serviciosComunes.excepciones.ConsultaSinResultadosExcepcion;


/**
 * Implementacion de Empleado
 * 
 * @author mariher
 */
public class Empleado extends Usuario {

    private static final int MIN_PSSWD_LENGTH = 8;
    private static final int MAX_PSSWD_LENGTH = 20;

    private LocalDate fechaInicio;
    private Rol rolEnLaEmpresa;
    private VinculacionConLaEmpresa estadoDeLaVinculacion;
    private Disponibilidad estadoDeDisponibilidad;
    
    /**
     * Inicializador de un empleado
     * @param nifCif nif
     * @param nombre nombre
     * @param direccionPostal direccion postal
     * @param direccionElectronica direccion electronica
     * @param telefono telefono
     * @param fechaInicio fecha de inicio
     * @param rolEnLaEmpresa rol en la empresa
     * @param estadoDeLaVinculacion estado de la vinculacion
     * @param estadoDeDisponibilidad estado de disponibilidad
     */
    public Empleado(String nifCif, String nombre, String direccionPostal, String direccionElectronica, String telefono,
            LocalDate fechaInicio, Rol rolEnLaEmpresa, VinculacionConLaEmpresa estadoDeLaVinculacion,
            Disponibilidad estadoDeDisponibilidad) {
        super(nifCif, nombre, direccionPostal, direccionElectronica, telefono);
        this.fechaInicio = fechaInicio;
        this.rolEnLaEmpresa = rolEnLaEmpresa;
        this.estadoDeLaVinculacion = estadoDeLaVinculacion;
        this.estadoDeDisponibilidad = estadoDeDisponibilidad;
    }
    
    /**
     * Inicializador de un empleado mediante json
     * @param jsonString json de un empleado
     */
    public Empleado(String jsonString) {
        super(jsonString);
        
        JsonReaderFactory factory = Json.createReaderFactory(null);
        JsonReader reader = factory.createReader(new StringReader(jsonString));
        JsonObject jsonEmpleado = reader.readObject();
        
        int rol = jsonEmpleado.getInt("rol");
        this.fechaInicio = Date.valueOf(jsonEmpleado.getString("fechaInicio")).toLocalDate();
        LocalDate comienzoEnRol = Date.valueOf(jsonEmpleado.getString("comienzoEnRol")).toLocalDate();
        switch (rol) {
            case 1:
                this.rolEnLaEmpresa = new PersonalAlmacen(comienzoEnRol);
                break;
            case 2:
                this.rolEnLaEmpresa = new GerenteDeVentas(comienzoEnRol);
                break;
            case 3:
                this.rolEnLaEmpresa = new TecnicoDelTaller(comienzoEnRol);
                break;
            default:
                this.rolEnLaEmpresa = new Rol(comienzoEnRol);
                break;
        }
        
        int vinculacion = jsonEmpleado.getInt("vinculo");
        LocalDate fecha = Date.valueOf(jsonEmpleado.getString("inicio")).toLocalDate();
        switch (vinculacion) {
            case 1:
                this.estadoDeLaVinculacion = new Contratado(fecha);
                break;
            case 2:
                this.estadoDeLaVinculacion = new Despedido(fecha);
                break;
            case 3:
                this.estadoDeLaVinculacion = new EnERTE(fecha);
                break;
            default:
                this.estadoDeLaVinculacion = null;
                break;
        }
        
        int disponibilidad = jsonEmpleado.getInt("disponibilidad");
        LocalDate comienzo = Date.valueOf(jsonEmpleado.getString("comienzo")).toLocalDate();
        LocalDate finalPevisto;
        switch (disponibilidad) {
            case 1:
                finalPevisto = Date.valueOf(jsonEmpleado.getString("finalPrevisto")).toLocalDate();
                this.estadoDeDisponibilidad = new Vacaciones(comienzo, finalPevisto);
                break;
            case 2:
                finalPevisto = Date.valueOf(jsonEmpleado.getString("finalPrevisto")).toLocalDate();
                this.estadoDeDisponibilidad = new BajaTemporal(comienzo, finalPevisto);
                break;
            case 3:
                this.estadoDeDisponibilidad = new Trabajando(comienzo);
                break;
            default:
                this.estadoDeDisponibilidad = null;
                break;
        }
    }
    
    /**
     * Devuelve la fecha de inicio
     * @return fecha de inicio
     */
    public LocalDate getFechaInicio() {
        return this.fechaInicio;
    }
    
    /**
     * Devuelve el rol en la empresa
     * @return rol en la empresa
     */
    public Rol getRolEnLaEmpresa() {
        return this.rolEnLaEmpresa;
    }
    
    /**
     * Devuelve el estado de la disponibilidad
     * @return  estado de la disponibilidad
     */
    public Disponibilidad getEstadoDeDisponibilidad() {
        return this.estadoDeDisponibilidad;
    }
    
    /**
     * Devuelve el estado de la vinculacion con la empresa
     * @return estado de la vinculacion
     */
    public VinculacionConLaEmpresa getEstadoDeVinculacion() {
        return this.estadoDeLaVinculacion;
    }
    
    /**
     * Obtiene y crea un empleado dado un login y una contraseña
     * @param login login
     * @param password contraseña
     * @return empleado
     * @throws ConsultaSinResultadosExcepcion 
     */
    public static Empleado getEmpleadoPorLoginYPassword(String login, String password)
            throws ConsultaSinResultadosExcepcion {
        String jsonStr = DAOEmpleado.consultaEmpleadoPorLoginYPassword(login, password);
        if (jsonStr != null) {
            return new Empleado(jsonStr);
        } else {
            throw new ConsultaSinResultadosExcepcion();
        }
    }
    
    /**
     * Comprueba si el empleado está en estado activo,es decir, está contratado 
     * y trabajando
     * @return true si lo está, false si no
     */
    public boolean estaActivo() {
       return estadoDeLaVinculacion instanceof Contratado && estadoDeDisponibilidad instanceof Trabajando;
    }
    
    /**
     * Comprueba si el dni es válido
     * @param dni dni
     * @return true si lo es, false si no
     */
    public static boolean esValidoDNI(String dni) {
        if (dni.length() != 9)
            return false;
        char dniLetter = dni.charAt(8);
        if (!Character.isLetter(dniLetter))
            return false;
        String number = dni.substring(0, 8);
        try {
            int dniNumber = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    
    /**
     * Comprueba que la longitud de la contraseña es válida
     * @param password contraseña
     * @return true si lo es, false si no
     */
    public static boolean esValidoPassword(char[] password) {
        if (password.length > MAX_PSSWD_LENGTH || password.length < MIN_PSSWD_LENGTH){
                return false;
        }
        return true;
    }
}
