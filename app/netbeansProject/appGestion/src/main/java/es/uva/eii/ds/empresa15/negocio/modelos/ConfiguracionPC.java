package es.uva.eii.ds.empresa15.negocio.modelos;

import java.io.StringReader;
import java.io.StringWriter;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonReaderFactory;
import javax.json.JsonWriter;

/**
 * Implementacion de ConfiguracionPC
 * 
 *@author mariher
 */
public class ConfiguracionPC {
    
    private final CPU tipoCPU;
    private final double velocidadCPU;
    private final int capacidadRAM;
    private final int capacidadDD;
    private final double velocidadTarjetaGrafica;
    private final int memoriaTarjetaGrafica;
    private final int idConfiguracion;
    
    /**
     * Inicializacion de una configuracion
     * @param tipoCPU tipo de CPU
     * @param velocidadCPU velocidad de CPU
     * @param capacidadRAM capacidad RAM
     * @param capacidadDD capacidad DD
     * @param velocidadTarjetaGrafica velocidad de la tarjeta grafica
     * @param memoriaTarjetaGrafica memoria de la tarjeta grafiva
     * @param idConfiguracion id de la configuracion
     */
    public ConfiguracionPC(CPU tipoCPU, double velocidadCPU, int capacidadRAM,
     int capacidadDD, double velocidadTarjetaGrafica, int memoriaTarjetaGrafica,
     int idConfiguracion) {
        
        this.tipoCPU = tipoCPU;
        this.velocidadCPU = velocidadCPU;
        this.capacidadRAM = capacidadRAM;
        this.capacidadDD = capacidadDD;
        this.velocidadTarjetaGrafica = velocidadTarjetaGrafica;
        this.memoriaTarjetaGrafica = memoriaTarjetaGrafica;
        this.idConfiguracion = idConfiguracion;
    }
    
    /**
     * Inicializacion de una configuracion mediante json
     * @param jsonStr json de una configuracion
     */
    public ConfiguracionPC(String jsonStr){
        JsonReaderFactory factory = Json.createReaderFactory(null);
        JsonReader reader = factory.createReader(new StringReader(jsonStr));
        JsonObject jsonConfiguracionPC = reader.readObject();

        this.tipoCPU = new CPU(jsonStr);
        this.velocidadCPU = jsonConfiguracionPC.getJsonNumber("velocidadCPU").doubleValue();
        this.capacidadRAM = jsonConfiguracionPC.getInt("capacidadRAM");
        this.capacidadDD = jsonConfiguracionPC.getInt("capacidadDD");
        this.velocidadTarjetaGrafica = jsonConfiguracionPC.getJsonNumber("velocidadTarjetaGrafica").doubleValue();
        this.memoriaTarjetaGrafica = jsonConfiguracionPC.getInt("memoriaTarjetaGrafica");
        this.idConfiguracion = jsonConfiguracionPC.getInt("idConfiguracion");
    }

    /**
     * Devuelve el tipo de CPU
     * @return tipo de CPU
     */
    public CPU getTipoCPU() {
        return tipoCPU;
    }
    
    /**
     * Devuelve la velocidad de la CPU
     * @return velocidad de la CPU
     */
    public double getVelocidadCPU() {
        return velocidadCPU;
    }
    
    /**
     * Devuelve la capacidad de la RAM
     * @return capacidad de la RAM
     */
    public int getCapacidadRAM() {
        return capacidadRAM;
    }
    
    /**
     * Devuelve la capacidad del disco diro
     * @return capacidad del disco duro
     */
    public int getCapacidadDD() {
        return capacidadDD;
    }
    
    /**
     * Devuelve la velocidad de la tarjeta gráfica
     * @return velocidad de la tarjeta gráfica
     */
    public double getVelocidadTarjetaGrafica() {
        return velocidadTarjetaGrafica;
    }
    
    /**
     * Devuelve la memoria de la tarjeta gráfica
     * @return memoria de la tarjeta gráfica
     */
    public double getMemoriaTarjetaGrafica() {
        return memoriaTarjetaGrafica;
    }
    
    /**
     * Devuelve el id de la configuracion
     * @return id de la configuracion
     */
    public int getIdConfiguracion(){
        return idConfiguracion;
    }
    
    /**
     * Devuelve un string con los detalles de la configuracion para ser
     * mostrados
     * @return string con los detalles de la configuracion
     */
    public String mostrarDetallesConfiguracion() {
        return String.format(""
                + "Detalles de la configuracion:\n"
                + "  ID: %d\n"
                + "  Tipo de CPU: %s\n"
                + "  Velocidad CPU: %f\n"
                + "  Capacidad RAM: %d\n"
                + "  Capacidad Disco Duro: %d\n"
                + "  Velocidad Tarjeta Grafica: %f\n"
                + "  Memoria Tarjeta Grafica: %d\n", 
                this.idConfiguracion,
                this.tipoCPU.getNombre(),
                this.velocidadCPU,
                this.capacidadRAM,
                this.capacidadDD,
                this.velocidadTarjetaGrafica,
                this.memoriaTarjetaGrafica);
    }
    
    /**
     * Crea el json de la configuracion y lo devuelve
     * @return json de la configuracion
     */
    public String toJson() {
        StringWriter stringWriter = new StringWriter();
        JsonWriter writer = Json.createWriter(stringWriter);
        
        JsonObjectBuilder jsonConfig = Json.createObjectBuilder()
                .add("idConfiguracion", idConfiguracion)
                .add("tipoCPU", tipoCPU.toJson())
                .add("velocidadCPU", velocidadCPU)
                .add("capacidadRAM", capacidadRAM)
                .add("capacidadDD", capacidadDD)
                .add("velocidadTarjetaGrafica", velocidadTarjetaGrafica)
                .add("memoriaTarjetaGrafica", memoriaTarjetaGrafica);

        JsonObject configJson = jsonConfig.build();
        writer.writeObject(configJson);
        return stringWriter.toString();
    }
}
