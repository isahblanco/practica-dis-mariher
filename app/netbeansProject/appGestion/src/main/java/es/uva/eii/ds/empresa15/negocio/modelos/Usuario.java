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
 * Implementacion de Usuario
 * 
 * @author mariher
 */
public class Usuario {
    
    private final String nifCif;
    private final String nombre;
    private final String direccionPostal;
    private final String direccionElectronica;
    private final String telefono;
    
    /**
     * Inicializacion de un usuario
     * @param nifCif nif o cif del usuario
     * @param nombre nombre
     * @param direccionPostal direccion postal
     * @param direccionElectronica direccion electronica
     * @param telefono telefono
     */
    public Usuario(String nifCif, String nombre, String direccionPostal,
            String direccionElectronica, String telefono) {
        this.nifCif = nifCif;
        this.nombre = nombre;
        this.direccionPostal = direccionPostal;
        this.direccionElectronica = direccionElectronica;
        this.telefono = telefono;
    }
    
    /**
     * Inicializacion de un usuario mediante json
     * @param jsonStr json de un usuario
     */
    public Usuario(String jsonStr) {
        JsonReaderFactory factory = Json.createReaderFactory(null);
        JsonReader reader = factory.createReader(new StringReader(jsonStr));
        JsonObject jsonUsuario = reader.readObject();
        
        this.nifCif = jsonUsuario.getString("nifCif");
        this.nombre = jsonUsuario.getString("nombre");
        this.direccionPostal = jsonUsuario.getString("direccionPostal");
        this.direccionElectronica = jsonUsuario.getString("direccionElectronica");
        this.telefono = jsonUsuario.getString("telefono");
    }
    
    /**
     * Devuelve el nif/cif del usuario
     * @return nif/cif del usuario
     */
    public String getNifCif() {
        return this.nifCif;
    }
    
    /**
     * Devuelve el nombre del usuario
     * @return nombre del usuario
     */
    public String getNombre() {
        return this.nombre;
    }
    
    /**
     * Devuelve la direccion postal del usuario
     * @return direccion postal del usuario
     */
    public String getDireccionPostal() {
        return direccionPostal;
    }
   
    /**
     * Devuelve la direccion electronica del usuario
     * @return direccion electronica del usuario
     */
    public String getDireccionElectronica() {
        return direccionElectronica;
    }
    
    /**
     * Devuelve el telefono del usuario
     * @return telefono del usuario
     */
    public String getTelefono(){
        return telefono;
    }
    
     /**
     * Crea el json del usuario y lo devuelve
     * @return json del usuario
     */
    public String toJson() {
        StringWriter stringWriter = new StringWriter();
        JsonWriter writer = Json.createWriter(stringWriter);
        
        JsonObjectBuilder jsonUsuario = Json.createObjectBuilder()
                .add("nifCif", nifCif)
                .add("nombre", nombre)
                .add("direccionPostal", direccionPostal)
                .add("direccionElectronica", direccionElectronica)
                .add("telefono", telefono);

        JsonObject usuarioJson = jsonUsuario.build();
        writer.writeObject(usuarioJson);
        return stringWriter.toString();
    }
}
