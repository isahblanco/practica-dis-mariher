package es.uva.eii.ds.empresa15.persistencia.daos;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.uva.eii.ds.empresa15.persistencia.dbaccess.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Utility class
 * Façade 
 * 
 * @author mariher
 */
public class DAOEmpleado {

    private DAOEmpleado() {
        throw new IllegalStateException("Utility class");
    }

    public static String consultaEmpleadoPorLoginYPassword(String nif, String password) {
        String query = "SELECT * "
                + "FROM Empleado e, Usuario u, RolesEnEmpresa r, VinculacionConLaEmpresa v, DisponibilidadEmpleado d "
                + "WHERE   e.NIF = u.NIFCIF AND " + "u.NIFCIF = r.EMPLEADO AND "
                + "        r.EMPLEADO = v.EMPLEADO AND v.EMPLEADO = d.EMPLEADO AND "
                + "        e.NIF = ? AND e.PASSWORD = ? AND "
                + "        r.COMIENZOENROL = (SELECT MAX(r2.COMIENZOENROL) FROM RolesENEmpresa r2 WHERE r2.EMPLEADO = r.EMPLEADO) AND "
                + "        v.INICIO = (SELECT MAX(v2.INICIO) FROM VinculacionConLaEmpresa v2 WHERE v2.EMPLEADO = v.EMPLEADO) AND "
                + "        d.COMIENZO = (SELECT MAX(d2.COMIENZO) FROM DisponibilidadEmpleado d2 WHERE d2.EMPLEADO = d.EMPLEADO)";

        DBConnection conn = DBConnection.getInstance();
        conn.openConnection();

        String stringJson = null;

        try (PreparedStatement ps = conn.getStatement(query);) {
            ps.setString(1, nif);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                HashMap<String, Object> empleado;
                empleado = procesarResultados(rs);
                stringJson = DAO.getJsonFromQuery(empleado);
            }
        } catch (SQLException e) {
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            conn.closeConnection();
        }
        return stringJson;
    }
    
    private static HashMap<String, Object> procesarResultados(ResultSet rs) throws SQLException {
        var diccionario = new HashMap<String, Object>();
        diccionario.put("nifCif", rs.getString("nifCif"));
        diccionario.put("nombre", rs.getString("nombre"));
        diccionario.put("direccionPostal", rs.getString("direccionPostal"));
        diccionario.put("direccionElectronica", rs.getString("direccionElectronica"));
        diccionario.put("telefono", rs.getString("telefono"));
        diccionario.put("fechaInicio", rs.getDate("fechaInicio"));
        diccionario.put("comienzoEnRol", rs.getDate("comienzoEnRol"));
        diccionario.put("rol", rs.getInt("rol"));
        diccionario.put("inicio", rs.getDate("inicio"));
        diccionario.put("vinculo", rs.getInt("vinculo"));
        diccionario.put("comienzo", rs.getDate("comienzo"));
        diccionario.put("finalPrevisto", rs.getDate("finalPrevisto"));
        diccionario.put("disponibilidad", rs.getInt("disponibilidad"));
        return diccionario;
    }

}
