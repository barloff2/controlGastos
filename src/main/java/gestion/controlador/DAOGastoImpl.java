package gestion.controlador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
			ps.setDouble(3, gasto.getValor());
			ps.setString(4, gasto.getDescription());
			ps.setString(5, gasto.getFecha());
			ps.setString(6, gasto.getResponsable());
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

	@Override
	public List<Gasto> mostrarGastos() throws Exception {
		List<Gasto> lista = new ArrayList<Gasto>();
		try {
			this.conectar();
			Statement st = this.conectar.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Gasto;");
			while(rs.next()) {
				Gasto gasto = new Gasto();
				gasto.setDescription(rs.getString("descripcion_gasto"));
				gasto.setValor(rs.getDouble("valor_gasto"));
				gasto.setTipo(rs.getString("tipo_gasto"));
				gasto.setFecha(rs.getString("fecha_gasto"));
				gasto.setResponsable(rs.getString("responsable_gasto"));
				lista.add(gasto);
			}
			rs.close();
			st.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			this.cerrarConexion();
		}
		return lista;
	}

}
