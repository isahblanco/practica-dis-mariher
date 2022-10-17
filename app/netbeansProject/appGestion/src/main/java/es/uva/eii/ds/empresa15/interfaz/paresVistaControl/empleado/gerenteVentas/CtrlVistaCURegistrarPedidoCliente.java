package es.uva.eii.ds.empresa15.interfaz.paresVistaControl.empleado.gerenteVentas;

import es.uva.eii.ds.empresa15.GestorInterfazUsuario;
import es.uva.eii.ds.empresa15.negocio.controladoresCasoUso.ControladorCURegistrarPedidoCliente;
import es.uva.eii.ds.empresa15.serviciosComunes.excepciones.ConsultaSinResultadosExcepcion;


/**
 * Implementacion de CtrlVistaCURegistrarPedidoCliente
 * 
 * @author mariher
 */
public class CtrlVistaCURegistrarPedidoCliente {
    
    private final VistaCURegistrarPedidoCliente vista;
    private final ControladorCURegistrarPedidoCliente controladorCU;
    
    private final String CIF_NULL = "Introduzca un cif";
    private final String CANTIDAD_INSUFICIENTE = "Introduzca una cantidad de 10 o superior";
    
    private GestorInterfazUsuario sm;
    private boolean firstTime = true;
    
    public CtrlVistaCURegistrarPedidoCliente(VistaCURegistrarPedidoCliente vista) {
        this.vista = vista;
        this.controladorCU = ControladorCURegistrarPedidoCliente.getControlador();
        this.sm = GestorInterfazUsuario.getMachine();
    }
    
    /**
     * Llama al controlador de CU para que este obtenga el cliente y las
     * las configuraciones, también obtiene los tipos de CPU y los manda a la
     * vista que los muestre
     * @param cif CIF del cliente
     */
    public void procesarEventoCifCliente(String cif){
        if(cif.isEmpty()){
            vista.mostrarMensajeError(CIF_NULL);
        } else {
            try{
                controladorCU.obtenerCliente(cif); 
                controladorCU.obtenerConfiguracionesPC();
                vista.mostrarTiposCPU(obtenerTiposCPU());

            } catch (ConsultaSinResultadosExcepcion e){
                vista.vaciarComboBoxIDconfiguracion();
                vista.mostrarMensajeError("No existe ningún cliente con ese CIF en el sistema");
            }
        }
    }
    
    /**
     * Devuelve los detalles de la configuracion seleccionada
     * @param id id de la configuracion
     * @return string con los detalles de la configuracion
     */
    public String obtenerDetallesConfiguracion(int id) {
     return controladorCU.detallesConfiguracion(id);
    }
    
    private boolean comprobarCantidadOk(int cantidad){
        if(cantidad < 10) return false;
        return true; 
    }
    
    /**
     * Crea un pedido con los datos introducidos y muestra su resumen
     * @param idConfig id de la configuracion seleccionada
     * @param cantidad cantidad solicitada
     */
    public void procesarEventoCrearPedido(int idConfig, int cantidad){
        if(!comprobarCantidadOk(cantidad)){
            vista.mostrarMensajeErrorCantidad(CANTIDAD_INSUFICIENTE);
        } else {
            String resumenPedido = controladorCU.crearPedido(idConfig,cantidad);
            vista.mostrarResumenDelPedido(resumenPedido);
        }
    }
    
    /**
     * Deja el caso de uso sin efecto y vuelve a mostrar las opciones de rol
     */
    public void procesarEventoCancelar(){
        sm.mostrarOpcionesRol();
    }
    
    /**
     * Registra un pedido
     */
    public void procesarEventoRegistrarPedido() {
       controladorCU.registrarPedido();
    }
    
    /**
     * Devuelve el array de string con los nombres de los tipos de CPU
     * @return array con los nombres de los tipos de CPU
     */
    public String[] obtenerTiposCPU() {
        return controladorCU.obtenerTiposCPU();
    }
    
    /**
     * Obtiene las configuraciones filtradas por tipo de CPU y se las pasa
     * a la vista para que las muestre
     * @param tipo tipo de CPU
     */
    public void filtrar(String tipo){
        String idsFiltrado[] = controladorCU.filtraTipoCPU(tipo);
        
        if(firstTime){ 
            vista.mostrarIdConfiguraciones(idsFiltrado);
            firstTime = false;
        } else {
            vista.vaciarComboBoxIDconfiguracion();
            vista.mostrarIdConfiguraciones(idsFiltrado);
        }
    }
}


