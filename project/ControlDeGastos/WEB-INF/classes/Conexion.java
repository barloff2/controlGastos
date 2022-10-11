package controlador;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    Connection conectar = null;

    public Connection conectar() {
    	String url = "/Library/WebServer/Documents/project/ControlDeGastos/controlGastos.db";
        try {
            Class.forName("org.sqlite.JDBC");
            conectar = DriverManager.getConnection("jdbc:sqlite:" + url);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return conectar;
    }
    
}
