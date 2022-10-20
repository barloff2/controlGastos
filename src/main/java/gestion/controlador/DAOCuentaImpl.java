package gestion.controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import gestion.DAO.CuentaDAO;
import gestion.modelo.Cuenta;

public class DAOCuentaImpl extends Conexion implements CuentaDAO {

	@Override
	public void modificarSaldo(Cuenta cuenta) throws Exception {
		this.conectar();
		try {
			PreparedStatement ps = this.conectar.prepareStatement("Update Cuenta SET saldo_cuenta = ? WHERE numero_cuenta = 1;");
			//Insertar datos
			ps.setDouble(1, cuenta.getSaldo());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: " + e.getMessage());
		} finally {
			this.cerrarConexion();
		}
	}

	@Override
	public double mostrarSaldo() throws Exception {
		double saldo = 0;
		this.conectar();
		try {
			Statement st = this.conectar.createStatement();
			String query = "SELECT saldo_cuenta FROM cuenta;";
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				saldo = rs.getDouble(1);
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			this.cerrarConexion();
		}
		return saldo;
	}

}
