package es.uva.eii.ds.empresa15.persistencia.daos;

import java.io.StringWriter;
import java.sql.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.json.Json;
import javax.json.JsonObject;

/**
 * Implementacion de DAO
 * 
 * @author mariher
 */
public class DAO {
   
    private DAO() {
        throw new IllegalStateException("Utility class");
    }
    
    protected static String getJsonFromQuery(Map<String, Object> attr) {
        final var stringWriter = new StringWriter();
        try (final var writer = Json.createWriter(stringWriter)) {
            var jsonBuilder = Json.createObjectBuilder();
            attr.entrySet().forEach(a -> {
                var key = a.getKey();
                var value = a.getValue();
              
                if (value == null) jsonBuilder.add(key, JsonObject.NULL);
                else if (value instanceof Date)
                    jsonBuilder.add(key, value.toString());
                else if (value instanceof Integer)
                    jsonBuilder.add(key, (int) value);
                else if (value instanceof String)
                    jsonBuilder.add(key, (String) value);
                else if (value instanceof Boolean)
                    jsonBuilder.add(key, (boolean) value);
                else if (value instanceof Float)
                    jsonBuilder.add(key, (float) value);
                else if (value instanceof Double)
                    jsonBuilder.add(key, (double) value);
            });
            var json = jsonBuilder.build();
            writer.writeObject(json);
        } catch (Exception e) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, "DB configuration file not found.");
        }
        return stringWriter.toString();
    }
}
