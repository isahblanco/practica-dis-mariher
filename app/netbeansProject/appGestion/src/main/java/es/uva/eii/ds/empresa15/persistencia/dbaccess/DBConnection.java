package es.uva.eii.ds.empresa15.persistencia.dbaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Implementacion de DBConnection
 * 
 * @author mariher
 */
public class DBConnection {
    
    // Nivel de clase
    private static DBConnection theDBConnection;
    
    public static DBConnection getInstance() {
        if (theDBConnection == null) {
            Properties prop = new Properties();
            InputStream read; 
            String url, user, password;
            try {
                read = DBConnection.class.getResourceAsStream("config.db");
                prop.load(read);
                url = prop.getProperty("url");
                user = prop.getProperty("user");
                password = prop.getProperty("password");
                read.close(); 
                theDBConnection = new DBConnection(url, user, password);
                
            } catch (FileNotFoundException e) {
                System.err.println("DB configuration file not found.");
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, "DB configuration file not found.");       
            } catch (IOException e) {
                System.err.println("Couldn't read DB configuration file.");
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, "Couldn't read DB configuration file.");        
            }      
        }
        return theDBConnection;
    }

    // Nivel de instancia
    private Connection conn;
    private String url;
    private String user;
    private String password;

    private DBConnection(String url, String user, String password) {        
        this.url = url;
        this.user = user;
        this.password = password;
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver"); 
        }
        catch (ClassNotFoundException ex) {
            System.err.println("Derby driver not found.");
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, "Derby driver not found.");
        }
    }
    
    /**
     * Abre la conexion con la base de datos
     */
    public void openConnection() {
        try {
            conn = DriverManager.getConnection(url, user, password);
        }
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Cierra la conexion con la base de datos
     */
    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Devuelve el statement
     * @param s string con la consulta a la base de datos
     * @return el statement
     */
    public PreparedStatement getStatement(String s) {
        PreparedStatement statement = null;
        try {
                statement = conn.prepareStatement(s);
        } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return statement;
    }    
}
