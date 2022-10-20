package gestion.controlador;

import java.io.IOException;
import java.io.PrintWriter;

import gestion.modelo.*;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
