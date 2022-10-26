package gestion.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    protected Connection conectar;
    private final String URL = "C:\\Users\\mjfc9\\Documents\\trabajoGit\\controlGastos\\controlGastos.db";

    public void conectar() {
        try {
            Class.forName("org.sqlite.JDBC");
            conectar = DriverManager.getConnection("jdbc:sqlite:" + URL);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void cerrarConexion() throws SQLException {
    	if (conectar != null && !conectar.isClosed()) {
    		conectar.close();
    	}
    }
    
}
