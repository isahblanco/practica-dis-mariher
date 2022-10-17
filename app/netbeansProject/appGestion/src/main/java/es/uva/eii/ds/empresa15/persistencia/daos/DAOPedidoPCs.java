package es.uva.eii.ds.empresa15.persistencia.daos;


import es.uva.eii.ds.empresa15.negocio.modelos.PedidoPCs;
import es.uva.eii.ds.empresa15.persistencia.dbaccess.DBConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Utility class
 * Façade
 * 
 * @author mariher
 */
public class DAOPedidoPCs {
    
    
    private DAOPedidoPCs() {
        throw new IllegalStateException("Utility class");
    }
    
    public static void consultaRegistrarPedido(String jsonStrPedido) {
        String query = "INSERT INTO PEDIDOPC VALUES(?,?,?,?,?,?)";
        
        DBConnection conn = DBConnection.getInstance();
        conn.openConnection();
         
        PedidoPCs pedido = new PedidoPCs(jsonStrPedido);
       
        try(PreparedStatement ps = conn.getStatement(query)) {
            
            int idPedido = pedido.getId();
            int cantidadSolicitada = pedido.getCantidadSolicitada();
            LocalDate fechaPedido = pedido.getFechaPedido();
            int estado = pedido.getEstado().ordinal()+1;
            int configuracionSolicitada = pedido.getConfiguracion().getIdConfiguracion();
            String encargadoPor = pedido.getCliente().getNifCif();
                        
            ps.setInt(1,idPedido);
            ps.setInt(2,cantidadSolicitada);
            ps.setDate(3,java.sql.Date.valueOf(fechaPedido));
            ps.setInt(4,estado);
            ps.setInt(5,configuracionSolicitada);
            ps.setString(6,encargadoPor);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            Logger.getLogger(DAOPedidoPCs.class.getName()).log(Level.SEVERE, null, e);
        } finally {
           conn.closeConnection();
        }
    }
}
