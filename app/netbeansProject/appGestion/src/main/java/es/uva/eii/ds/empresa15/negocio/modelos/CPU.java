package es.uva.eii.ds.empresa15.negocio.modelos;

import com.google.gson.Gson;

import java.io.StringWriter;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;



/**
 *Implementacion de CPU
 * 
 * @author mariher
 */
public class CPU {
    private final int idTipoCPU;
    private final String nombreTipoCPU;
    private final transient Gson gson = new Gson();
    
    /**
     * Inicializacion de un tipo de CPU
     * @param i id del tipo de CPU
     * @param nombre nombre del tipo de CPU
     */
    public CPU(int i, String nombre) {
        idTipoCPU = i;
        nombreTipoCPU = nombre;
    }
    
    /**
     * Inicializacion de un tipo de CPU mediante mediante json
     * @param jsonString json de un tipo de CPU
     */
    public CPU(String jsonString) {
       CPU cpu = gson.fromJson(jsonString, CPU.class);
       this.idTipoCPU = cpu.getId();
       this.nombreTipoCPU = cpu.getNombre();
    }
    
    /**
     * Devuelve el id del tipo de CPU
     * @return id
     */
    public int getId() {
        return idTipoCPU;
    }
    
    /**
     * Devuelve el nombre del tipo de CPU
     * @return nombre
     */
    public String getNombre() {
        return nombreTipoCPU;
    }

     /**
     * Crea el json del tipo de CPU y lo devuelve
     * @return json del tipo de CPU
     */
    public String toJson() { //esto funciona
        StringWriter stringWriter = new StringWriter();
        JsonWriter writer = Json.createWriter(stringWriter);
        
        JsonObjectBuilder jsonCPU = Json.createObjectBuilder()
                .add("idTipoCPU", idTipoCPU)
                .add("nombreTipoCPU", nombreTipoCPU);

        JsonObject cpuJson = jsonCPU.build();
        writer.writeObject(cpuJson);
        return stringWriter.toString();
    }
}
