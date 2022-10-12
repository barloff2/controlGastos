package vista;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import modelo.Usuario;
import modelo.Cuenta;

/**
 * Servlet implementation class ServletResponsable
 */
@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest peticion, HttpServletResponse respuesta) throws ServletException, IOException {
		
		//Tomar Datos
		String nombre_usuario = peticion.getParameter("nombre");
		String cedula_usuario =  peticion.getParameter("cedula");
		
		//Crear Usuario
		Usuario usuario = new Usuario(nombre_usuario, cedula_usuario);
		Cuenta cuenta = new Cuenta(usuario);

		respuesta.setContentType("text/html");
		
		
		PrintWriter salida = respuesta.getWriter();
		
		salida.println("<h1> Ingreso Exitoso <h1>");
		
		
		salida.println("</br>");
		
		salida.println("Datos Ingresados correctamente");
		
		salida.println("</br></br>");
		
		salida.println("<a href=Usuario.html> Regresar a Usuarios</a></br></br>");
		
		salida.println("<a href=index.html> Regresar a Inicio </a>");
		
	}



}
