package gestion.controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
			ps.setString(6, ingreso.getResponsable());
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
	public List<Ingreso> mostrarIngresos() throws Exception {
		List<Ingreso> lista = new ArrayList<Ingreso>();
		try {
			this.conectar();
			System.out.println(this.conectar);
			Statement st = this.conectar.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Ingreso;");
			while(rs.next()) {
				Ingreso ingreso = new Ingreso();
				ingreso.setDescription(rs.getString("descripcion_ingreso"));
				ingreso.setIngreso(rs.getDouble("valor_ingreso"));
				ingreso.setTipo(rs.getString("tipo_ingreso"));
				ingreso.setFecha(rs.getString("fecha_ingreso"));
				ingreso.setResponsable(rs.getString("responsable_ingreso"));
				lista.add(ingreso);
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
