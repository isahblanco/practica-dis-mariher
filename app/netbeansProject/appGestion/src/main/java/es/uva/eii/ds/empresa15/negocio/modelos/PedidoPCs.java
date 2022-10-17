package es.uva.eii.ds.empresa15.negocio.modelos;

import java.time.LocalDate;

import java.io.StringReader;
import java.io.StringWriter;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonReaderFactory;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;

/**
 * Implementacion de PedidoPCs
 * 
 * @author mariher
 */
public class PedidoPCs {
    private final int idPedido;
    private final int cantidadSolicitada;
    private final ConfiguracionPC configuracion;
    private final Cliente cliente;
    
    private LocalDate fechaPedido;
    private EstadoVentaPCs estadoVenta; 
    
    
    /**
     * Inicializacion de un pedido 
     * @param idPedido id
     * @param fechaPedido fecha de creacion
     * @param cantidadSolicitada cantidad solicitada
     * @param estadoVenta estado del pedido
     * @param configuracion configuracion seleccionada
     * @param cliente cliente que encarga el pedido
     */
    public PedidoPCs(int idPedido,LocalDate fechaPedido,int cantidadSolicitada,
            EstadoVentaPCs estadoVenta,ConfiguracionPC configuracion,
            Cliente cliente) {
        
        this.cliente = cliente;
        this.configuracion = configuracion;
        this.cantidadSolicitada = cantidadSolicitada;
        this.estadoVenta = estadoVenta;
        this.idPedido = idPedido;
        this.fechaPedido = fechaPedido;
    }
    
    /**
     * Inicializacion de un pedido mediante json
     * @param jsonStr json de un pedido
     */
    public PedidoPCs(String jsonStr) {
        JsonReaderFactory factory = Json.createReaderFactory(null);
        JsonReader reader = factory.createReader(new StringReader(jsonStr));
        JsonObject jsonPedidoPC = reader.readObject();

        this.idPedido = jsonPedidoPC.getInt("idPedido");
        this.fechaPedido = LocalDate.parse(jsonPedidoPC.getString("fechaPedido"));
        this.cantidadSolicitada = jsonPedidoPC.getInt("cantidadSolicitada");
        this.estadoVenta = EstadoVentaPCs.values()[jsonPedidoPC.getInt("estadoVenta")];
        this.configuracion = new ConfiguracionPC(jsonPedidoPC.getString("configuracion"));
        this.cliente = new Cliente(jsonPedidoPC.getString("cliente"));
    }
    
    /**
     * Devuelve el id del pedido
     * @return id del pedido
     */
    public int getId() {
        return idPedido;
    }
    
    /**
     * Devuelve la fecha de creacion del pedido
     * @return fecha de creacion
     */
    public LocalDate getFechaPedido(){
        return fechaPedido;
    }
    
    /**
     * Devuelve el estado del pedido
     * @return estado
     */
    public Enum getEstado(){
        return estadoVenta;
    }
    
    /**
     * Devuelve la cantidad solicitada de la configuracion del pedido
     * @return cantidad solicitada
     */
    public int getCantidadSolicitada() {
        return this.cantidadSolicitada;
    }
    
    /**
     * Devuelve la configuracion de PC del pedido
     * @return configuracion de PC
     */
    public ConfiguracionPC getConfiguracion() {
        return configuracion;
    }
    
    /**
     * Devuelve el cliente del pedido
     * @return cliente
     */
    public Cliente getCliente(){
        return cliente;
    }
    
    /**
     * Devuelve un string con el resumen del pedido
     * @return resumen del pedido
     */
    public String mostrarResumenPedido() {
        return String.format(
                "" + "ID: %d\n" 
                   + "Fecha: %s\n" 
                   + "Estado: %s\n"
                   + "Cantidad: %d\n\n" 
                   + "%s\n"    
                   + "Informacion del cliente: \n"
                   + "  CIF: %s\n"
                   + "  Nombre: %s\n",
                this.idPedido, 
                this.fechaPedido.toString(), 
                this.estadoVenta.toString(),
                this.cantidadSolicitada, 
                this.configuracion.mostrarDetallesConfiguracion(),
                this.cliente.getNifCif(),
                this.cliente.getNombre());
    }
    
    /**
     * Crea el json del pedido y lo devuelve
     * @return json del pedido
     */
    public String toJson() {
        StringWriter stringWriter = new StringWriter();
        JsonWriter writer = Json.createWriter(stringWriter);
        
        JsonObjectBuilder jsonPedido = Json.createObjectBuilder()
                .add("idPedido", idPedido)
                .add("cantidadSolicitada", cantidadSolicitada)
                .add("fechaPedido", fechaPedido.toString())
                .add("estadoVenta", estadoVenta.ordinal())
                .add("configuracion", configuracion.toJson())
                .add("cliente", cliente.toJson());
                
        JsonObject pedidoJson = jsonPedido.build();
        writer.writeObject(pedidoJson);
        return stringWriter.toString();
    }
}
