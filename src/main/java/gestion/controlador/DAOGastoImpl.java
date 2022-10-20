package gestion.controlador;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import gestion.DAO.GastoDAO;
import gestion.modelo.Gasto;

public class DAOGastoImpl extends Conexion implements GastoDAO{

	@Override
	public void addGasto(Gasto gasto) throws Exception {
		this.conectar();
		try {
			PreparedStatement ps = this.conectar.prepareStatement("INSERT INTO Gasto VALUES(?,?,?,?,?,?);");
			//Insertar datos
			ps.setNull(1, 0);
			ps.setString(2, gasto.getTipo());
			ps.setDouble(3, gasto.getGasto());
			ps.setString(4, gasto.getDescription());
			ps.setString(5, gasto.getFecha());
			ps.setString(6, gasto.getUsuario().getCedula());
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
