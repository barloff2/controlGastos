package gestion.modelo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import gestion.controlador.Conexion;

public class Cuenta {
	private Usuario usuario;
	private double saldo;
    private Gasto gasto;
    private Ingreso ingreso;
	Conexion con = new Conexion();
	Connection conect = con.conectar();
    
    public Cuenta(Usuario usuario, Ingreso ingreso) {
    	this.usuario = usuario;
    	this.saldo = 0;
    	this.ingreso = ingreso;	
    }
    public Cuenta(Usuario usuario, Gasto gasto) {
    	this.usuario = usuario;
    	this.saldo = 0;
    	this.gasto = gasto;	
    }
    public Cuenta() {
    	
    }
    public double getSaldo() {
    	Conexion con = new Conexion();
    	Connection conect = con.conectar();
		try {
			Statement st = conect.createStatement();
			String query = "SELECT saldo_cuenta FROM cuenta;";
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				this.saldo = rs.getDouble(2);
			}
			
			con.cerrarConexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: " + e.getMessage());
		}
		return this.saldo;
    }
    
    public String añadirIngresos() {
    	String mensaje = "";
		try {
			PreparedStatement ps = conect.prepareStatement("INSERT INTO Ingreso VALUES(?,?,?,?,?,?);");
			//Insertar datos
			ps.setNull(1, 0);
			ps.setString(2, ingreso.getTipo());
			ps.setDouble(3, ingreso.getIngreso());
			ps.setString(4, ingreso.getDescription());
			ps.setString(5, ingreso.getFecha());
			ps.setString(6, usuario.cedula);
			ps.execute();
			
			ps.close();
			con.cerrarConexion();
			mensaje = "añadido exitosamente. " + conect;
			//setSaldo(ingreso.getIngreso());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			mensaje = "Error: " + e.getMessage();
		}
		return mensaje;
    }
    
    public String añadirGasto() {
    	Conexion con = new Conexion();
    	Connection conect = con.conectar();
    	String mensaje = "";
    	saldo = getSaldo();
    	if(saldo != 0 && saldo > gasto.getGasto()) {
    		try {
    			PreparedStatement ps = conect.prepareStatement("INSERT INTO gasto VALUES(?,?,?,?,?);");
    			//Insertar datos
    			ps.setNull(1, 0);
    			ps.setString(2, gasto.getTipo());
    			ps.setDouble(3, gasto.getGasto());
    			ps.setString(4, gasto.getDescription());
    			ps.setString(5, gasto.getFecha());
    			ps.setString(6, usuario.cedula);
    			ps.execute();
    			
    			conect.close();
    			
    			mensaje = "añadido exitosamente.";
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			mensaje = "Error: " + e.getMessage();
    		}   	
    	} else {
    		mensaje = "No tiene saldo suficiente."; 
    	}
		return mensaje;
    }
	
    public void setSaldo(double ingreso) {
    	Conexion con = new Conexion();
    	Connection conect = con.conectar();
    	double saldo = getSaldo() + ingreso;
		try {
			PreparedStatement ps = conect.prepareStatement("Update Cuenta SET saldo_cuenta = ? WHERE numero_cuenta = 1;");
			//Insertar datos
			ps.setDouble(1, saldo);
			
			conect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: " + e.getMessage());
		} 
    }
	
	
	/*private double saldo; // Saldo de la cuenta
    private Usuario usuarioCuenta; // Usuario propietario de la cuenta
    private List<Gasto> gastos; // Lista de gastos
    private List<Ingreso>ingresos; // Lista de ingresos
    // Contructor del objeto cuenta. Le da un estado iniciar a la cuenta.
    public Cuenta(Usuario usuarioCuenta) {
        this.usuarioCuenta=usuarioCuenta;
        this.saldo=0;
        this.gastos=new ArrayList<Gasto>();
        this.ingresos=new ArrayList<Ingreso>();
    }
 
    // Establece el usuario de la cuenta
    public void setUsuarioCuenta(Usuario usuarioCuenta) {
        this.usuarioCuenta = usuarioCuenta;
    }
 
    // Establece el saldo de la cuenta.
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
     
    // Devuelve el saldo de la cuenta
    public double getSaldo() {
        return saldo;
    }
     
    // Devuelve el usuario de la cuenta
    public Usuario getUsuarioCuenta() {
        return usuarioCuenta;
    }
     
    // Devuelve la lista de gastos
    public List<Gasto> getGastos() {
        return gastos;
    }
     
    // Devuelve la lista de ingresos
    public List<Ingreso> getIngresos() {
        return ingresos;
    }
     
    // Agrega un ingreso a la lista.
    public double addIngresos(String description, double cantidad){
         
        // Se crea el ingreso y se pasa el importe y la descripcion.
        Ingreso nuevoIngreso = new Ingreso(cantidad,description);
        // Se agrega el ingreso a la lista
        this.ingresos.add(nuevoIngreso);
        // Se suma el saldo
        this.saldo=this.saldo+cantidad;
        // se devuelve el saldo
        return saldo;
    }
     
    // Agrega un gasto a la lista
    public double addGastos(String description, double cantidad){
         
        try{ // Intentamos
            // Restar el saldo
            this.saldo = this.saldo-cantidad;
             
            if(this.getSaldo()<0){ // Si el saldo es menor que cero
                // Lanzamos la excepción personalizada
                throw new GastoException();
            }
            // Al lanzar la excepción se ejecuta el catch.
        }catch(GastoException e){
            // Devolvemos un -1
            return -1;
        }
        // Si no ejecuta el catch ejecutará lo siguiente
        // Creamos un nuevo gasto
        Gasto nuevoGasto=new Gasto(cantidad,description);
        // Lo agregamos a la lista de gastos
        gastos.add(nuevoGasto);
        // Devolvemos el saldo
        return saldo;
    }
     
   /* @Override
    public String toString(){
        return "Hola " + this.usuarioCuenta.getNombre() + ", el saldo de tu "
                + "cuenta es " + this.saldo;
    }*/
}
    


