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
public class DAOCPU {

    public static String[] consultaObtenerTiposCPU() {
        String query =  "SELECT * FROM CPU";
        
        DBConnection conn = DBConnection.getInstance();
        conn.openConnection();
        var tiposCPU = new ArrayList<String>();
        
        try (PreparedStatement ps = conn.getStatement(query);) {
            ResultSet rs = ps.executeQuery();
            HashMap<String, Object> tipoCpu;
            while (rs.next()) {
                tipoCpu = procesarResultados(rs);
                tiposCPU.add(DAO.getJsonFromQuery(tipoCpu));
            }
        } catch (SQLException e) {
            Logger.getLogger(DAOCPU.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            conn.closeConnection();
        }
        
        String[] stringsJson = tiposCPU.toArray(new String[tiposCPU.size()]);
        return stringsJson;
    }

    private static HashMap<String, Object> procesarResultados(ResultSet rs) throws SQLException {
        var diccionario = new HashMap<String, Object>();
        diccionario.put("idTipoCPU", rs.getInt("idTipoCPU"));
        diccionario.put("nombreTipoCPU", rs.getString("nombreTipoCPU"));
        return diccionario;
    }
    
}
