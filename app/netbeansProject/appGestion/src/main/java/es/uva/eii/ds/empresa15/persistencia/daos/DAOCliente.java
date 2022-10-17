/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.ds.empresa15.persistencia.daos;

import es.uva.eii.ds.empresa15.persistencia.dbaccess.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utility class
 * Façade
 * 
 * @author mariher
 */
public class DAOCliente {

    private DAOCliente() {
        throw new IllegalStateException("Utility class");
    }
    
    public static String consultaObtenerClientePorCif(String cif) {
        String query =  "SELECT * "
                + "FROM Usuario U, Empresa E "
                + "WHERE E.cif = U.nifcif AND E.cif = ? AND E.esCliente = true";
        
        DBConnection conn = DBConnection.getInstance();
        conn.openConnection();
       
        String jsonStr = null;
        try (PreparedStatement ps = conn.getStatement(query);) {
            ps.setString(1, cif);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                HashMap<String, Object> cliente;
                cliente = procesarResultados(rs);
                jsonStr = DAO.getJsonFromQuery(cliente);
            }
        } catch (SQLException e) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            conn.closeConnection();
        }
        return jsonStr;
    }

    private static HashMap<String, Object> procesarResultados(ResultSet rs) throws SQLException {
        var diccionario = new HashMap<String, Object>();
        diccionario.put("nifCif", rs.getString("nifCif"));
        diccionario.put("nombre", rs.getString("nombre"));
        diccionario.put("direccionPostal", rs.getString("direccionPostal"));
        diccionario.put("direccionElectronica", rs.getString("direccionElectronica"));
        diccionario.put("telefono", rs.getString("telefono"));
        return diccionario;
    }
}
