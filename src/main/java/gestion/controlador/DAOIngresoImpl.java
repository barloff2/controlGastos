package gestion.controlador;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import gestion.DAO.IngresoDAO;
import gestion.modelo.Ingreso;

public class DAOIngresoImpl extends Conexion implements IngresoDAO {

	@Override
	public void addIngreso(Ingreso ingreso) throws Exception {
		this.conectar();
		try {
			PreparedStatement ps = this.conectar.prepareStatement("INSERT INTO Ingreso VALUES(?,?,?,?,?,?);");
			//Insertar datos
			ps.setNull(1, 0);
			ps.setString(2, ingreso.getTipo());
			ps.setDouble(3, ingreso.getIngreso());
			ps.setString(4, ingreso.getDescription());
			ps.setString(5, ingreso.getFecha());
			ps.setString(6, ingreso.getUsuario().getCedula());
			ps.execute();
			
			ps.close();
			//setSaldo(ingreso.getIngreso());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: " + e.getMessage());
		}finally {
			this.cerrarConexion();
		}
		
	}

}
