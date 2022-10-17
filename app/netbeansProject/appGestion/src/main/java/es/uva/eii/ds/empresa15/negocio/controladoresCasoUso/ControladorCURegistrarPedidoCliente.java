package es.uva.eii.ds.empresa15.negocio.controladoresCasoUso;

import es.uva.eii.ds.empresa15.negocio.modelos.CPU;
import es.uva.eii.ds.empresa15.negocio.modelos.Cliente;
import es.uva.eii.ds.empresa15.negocio.modelos.ConfiguracionPC;
import es.uva.eii.ds.empresa15.negocio.modelos.EstadoVentaPCs;
import es.uva.eii.ds.empresa15.negocio.modelos.PedidoPCs;
import es.uva.eii.ds.empresa15.persistencia.daos.DAOCPU;
import es.uva.eii.ds.empresa15.persistencia.daos.DAOConfiguracionPC;
import es.uva.eii.ds.empresa15.persistencia.daos.DAOCliente;
import es.uva.eii.ds.empresa15.persistencia.daos.DAOPedidoPCs;
import es.uva.eii.ds.empresa15.serviciosComunes.excepciones.ConsultaSinResultadosExcepcion;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

/**
 * Implementacion de ControladorCURegistrarPedidoCliente
 * 
 * @author mariher
 */
public class ControladorCURegistrarPedidoCliente {
    
    //Nivel de clase
    private static ControladorCURegistrarPedidoCliente controlador;
    
    public static ControladorCURegistrarPedidoCliente getControlador() {
        if (controlador==null) {
            controlador = new ControladorCURegistrarPedidoCliente();
        }
        return controlador;
    }

    //Nivel de instancia
    private Cliente cliente;
    private ConfiguracionPC[] configs;
    private PedidoPCs pedido;
    
    /**
     * Obtiene el cliente del pedido y lo crea
     * @param cif del cliente
     * @throws ConsultaSinResultadosExcepcion si el cliente no se encuentra
     * en la base de datos
     */
    public void obtenerCliente(String cif)throws ConsultaSinResultadosExcepcion{
         String jsonStr = DAOCliente.consultaObtenerClientePorCif(cif);
      if (jsonStr == null) {
            throw new ConsultaSinResultadosExcepcion();
        }
      cliente = new Cliente(jsonStr);
    }
    
    /**
     * Crea un array de las configuraciones de PCs devueltas por la base de 
     * datos
     */
    public void obtenerConfiguracionesPC() {
      String [] jsonStrConfigPC = DAOConfiguracionPC.consultaObtenerConfiguraciones();
      configs = new ConfiguracionPC[jsonStrConfigPC.length]; 
      
      for (int i = 0; i < jsonStrConfigPC.length; i++) {
            configs[i] = new ConfiguracionPC(jsonStrConfigPC[i]);
      }
    }
    
    /**
     * Crea un pedido con la configuracion elegida y cantidad solicitada 
     * a nombre del cliente y en estado solicitado y devuelve el resumen
     * del mismo
     * @param idConfig id de la configuracion elegida
     * @param cantidad cantidad solicitada
     * @return resumen del pedido
     */
    public String crearPedido(int idConfig, int cantidad) {
        ConfiguracionPC configuracion = null;
        for(int i = 0; i < configs.length; i++){
           if(idConfig == configs[i].getIdConfiguracion()){
               configuracion = configs[i];
           }
        }
        Random rand = new Random();
        int upperbound = 10000;
        int idPedido = rand.nextInt(upperbound);
        
        pedido = new PedidoPCs(idPedido,LocalDate.now(),cantidad,
                EstadoVentaPCs.SOLICITADO,configuracion,cliente);
       
        return pedido.mostrarResumenPedido();
    }
    
    /**
     * Registra el pedido en la base de datos
     */
    public void registrarPedido() {
        DAOPedidoPCs.consultaRegistrarPedido(pedido.toJson());
    }
    
    /**
     * Devuelve un array con los nombres de los tipos de CPU
     * @return array de string con los nombres de los tipos 
     */
    public String[] obtenerTiposCPU() {
        String [] jsonStrCPU = DAOCPU.consultaObtenerTiposCPU();
        CPU[] tiposCPU = new CPU[jsonStrCPU.length];
        String[] nombreTipos = new String[jsonStrCPU.length];
        for(int i = 0; i < jsonStrCPU.length; i++){
            tiposCPU[i] = new CPU(jsonStrCPU[i]);
            nombreTipos[i] = tiposCPU[i].getNombre();
        }
        return nombreTipos;
    }
    
    /**
     * Obtiene y devuelve los detalles de la configuracion indicada
     * @param id de la configuracion
     * @return string con los detalles de la configuracion
     */
    public String detallesConfiguracion(int id) {
        String detalles = null;
        for(int i = 0; i < configs.length; i++){
           if(id == configs[i].getIdConfiguracion()){
               detalles = configs[i].mostrarDetallesConfiguracion();
           }  
        }
      return  detalles;    
    }
    
    /**
     * Devuelve un arrayList con los id de las configuraciones filtradas según
     * el tipo, que puede ser un tipo de CPU o Todo, que muestra todas las 
     * configuraciones
     * @param tipo tipo de CPU, por defecto "Todo"
     * @return arrayList con los id de las configuraciones
     */
     public String[] filtraTipoCPU(String tipo) {
        ArrayList<String> filtro = new ArrayList<>();
        for(int i = 0; i < configs.length; i++){
           if(tipo.equals(configs[i].getTipoCPU().getNombre())){ 
               filtro.add(Integer.toString(configs[i].getIdConfiguracion()));
           } else if(tipo.equals("Todo")){
               filtro.add(Integer.toString(configs[i].getIdConfiguracion()));
           }
        }
        return (String[]) filtro.toArray(new String[filtro.size()]);
    }
}