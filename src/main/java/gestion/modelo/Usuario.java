package gestion.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import gestion.controlador.Conexion;

public class Usuario {
	String nombre;
	String cedula;
	Connection conect;
	Conexion con = new Conexion();
	

	// Metodo constructor para dar un estado inicial al objeto Usuario.
	public Usuario() {
		this.nombre = "";
		this.cedula = "";
		
	}

	public Usuario(String nombre, String cedula) {
		this.nombre = nombre;
		this.cedula = cedula;
		
		conect = this.con.conectar();
		try {
			PreparedStatement ps = conect.prepareStatement("INSERT INTO usuario VALUES(?,?,?);");
			//Insertar datos
			ps.setNull(1, 0);
			ps.setString(2, cedula);
			ps.setString(3, nombre);
			ps.execute();
			
			conect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: " + e.getMessage());
		}
	}

	// Metodos setter (establecen valores)
	public void setNombre(String nombre) { // Establece el nombre
		this.nombre = nombre;
	}

	public void setCedula(String cedula) { // Establece el cedula
		this.cedula = cedula;
	}

	// Métodos getter (devuelven un valor).
	public String getNombre() { // Devuelve el nombre
		return this.nombre;
	}
	
	// Métodos getter (devuelven un valor).
	public String getCedula() { // Devuelve la cedula
		return this.cedula;
	}

	public List<String> getListadoNombres(String cedula) {
		List<String> nombres = null;
		conect = this.con.conectar();
		try {
			Statement st = conect.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM usuario;");
			while(rs.next()) {
				nombres.add(rs.getString(3));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return nombres;
		
	}

	// Metodo sobreescrito toString
	@Override
	public String toString() {
		return "Nombre: " + this.nombre + ".\n" + "cedula: " + this.cedula + ".\n";
	}

}
