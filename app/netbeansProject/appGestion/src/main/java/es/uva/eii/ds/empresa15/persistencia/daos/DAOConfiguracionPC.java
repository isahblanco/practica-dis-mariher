package es.uva.eii.ds.empresa15.persistencia.daos;

import es.uva.eii.ds.empresa15.persistencia.dbaccess.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utility class
 * Façade
 * 
 * @author mariher
 */
public class DAOConfiguracionPC {
    
    private DAOConfiguracionPC() {
        throw new IllegalStateException("Utility class");
    }
    
    public static String[] consultaObtenerConfiguraciones(){
        String query = "SELECT * "
            + "FROM ConfiguracionPC ConfPC, CPU cpu "
            + "WHERE ConfPC.tipoCPU = cpu.idTipoCPU ORDER BY ConfPC.VelocidadCPU ASC";
    
        var configuracionesPC = new ArrayList<String>();
        
        DBConnection conn = DBConnection.getInstance();
        conn.openConnection();

        try (PreparedStatement  ps = conn.getStatement(query);) {
            ResultSet rs = ps.executeQuery();
            HashMap<String, Object> configuracionPC;
            while (rs.next()) {
                configuracionPC = procesarResultados(rs);
                configuracionesPC.add(DAO.getJsonFromQuery(configuracionPC));
            }
        } catch (SQLException e) {
            Logger.getLogger(DAOConfiguracionPC.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            conn.closeConnection();
        }
        return configuracionesPC.toArray(new String[configuracionesPC.size()]);
    }
 
    private static HashMap<String, Object> procesarResultados(ResultSet rs) throws SQLException {
        var diccionario = new HashMap<String, Object>();

        diccionario.put("idConfiguracion", rs.getInt("idConfiguracion"));
        diccionario.put("tipoCPU", rs.getInt("tipoCPU"));
        diccionario.put("velocidadCPU", rs.getFloat("velocidadCPU"));
        diccionario.put("capacidadRAM", rs.getInt("capacidadRAM"));
        diccionario.put("capacidadDD", rs.getInt("capacidadDD"));
        diccionario.put("velocidadTarjetaGrafica", rs.getFloat("velocidadTarjetaGrafica"));
        diccionario.put("memoriaTarjetaGrafica", rs.getInt("memoriaTarjetaGrafica"));
        diccionario.put("idTipoCPU", rs.getInt("idTipoCPU"));
        diccionario.put("nombreTipoCPU", rs.getString("nombreTipoCPU"));
        return diccionario;
    }
}
