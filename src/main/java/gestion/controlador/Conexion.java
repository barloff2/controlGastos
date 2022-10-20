package gestion.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection conectar = null;

    public Connection conectar() {
    	String url = "C:\\Users\\Stiven\\eclipse-workspace\\ControlGastos\\controlGastos.db";
        try {
            Class.forName("org.sqlite.JDBC");
            conectar = DriverManager.getConnection("jdbc:sqlite:" + url);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return conectar;
    }
    
    public void cerrarConexion() {
        try {
            conectar.close();
            conectar = null;
        } catch (SQLException e) {
        	System.out.println("Error: " + e.getMessage());
        }
    }
    
}
