package gestion.controlador;

import java.io.IOException;
import java.io.PrintWriter;

import gestion.modelo.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrimerServlet
 */
@WebServlet("/ServletIngreso")
public class ServletIngreso extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletIngreso() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest peticion, HttpServletResponse respuesta) throws ServletException, IOException {
		
		//Tomar Datos
		String tipo = peticion.getParameter("tipo");
		double valor = Double.parseDouble(peticion.getParameter("valor"));
		String fecha = peticion.getParameter("fecha");
		String nombre_responsable = peticion.getParameter("nombre_responsable");
		int documento_responsable =  Integer.parseInt(peticion.getParameter("documento_responsable"));
		String asunto = peticion.getParameter("asunto");
		
		//Crear Usuario
		Usuario usuario = new Usuario();

		usuario.setNombre(nombre_responsable);
		//Creacion Cuenta
		Cuenta cuenta = new Cuenta(usuario);
		//añadir Ingreso
		//Formato de respuesta
		
		respuesta.setContentType("text/html");
		
		
		PrintWriter salida = respuesta.getWriter();
		
		salida.println("<h1> Ingreso Exitoso <h1>");
		
		salida.println("Nuevo Saldo: " + cuenta.addIngresos(asunto, valor));
		
		salida.println("</br>");
		
		salida.println("Datos: ");
		
		salida.println("</br>");
		
		salida.println("<a href=Ingresos.html> Regresar a Ingresos </a></br>");
		
		salida.println("<a href=index.html> Regresar a Inicio </a>");
		
	}

}
