package gestion.controlador;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

import gestion.modelo.Cuenta;
import gestion.modelo.Usuario;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletEgreso
 */
@WebServlet("/ServletEgreso")
public class ServletEgreso extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest peticion, HttpServletResponse respuesta) throws ServletException, IOException {
		// Tomar Datos
		String tipo = peticion.getParameter("tipo");
		double valor = Double.parseDouble(peticion.getParameter("valor"));
		String fecha = peticion.getParameter("fecha");
		String nombre_responsable = peticion.getParameter("nombre_responsable");
		String documento_responsable = peticion.getParameter("documento_responsable");
		String asunto = peticion.getParameter("asunto");

		// Crear Usuario
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre_responsable);
		usuario.setCedula(documento_responsable);

		// Creacion Cuenta
		Cuenta cuenta = new Cuenta(usuario);
		// añadir Ingreso

		// Formato de respuesta

		respuesta.setContentType("text/html");

		PrintWriter salida = respuesta.getWriter();

		salida.println("<h1> Egreso Exitoso <h1>");

		salida.println("Nuevo Saldo: " + cuenta.addGastos(asunto, valor));

		salida.println("</br>");

		salida.println("Datos: ");

		salida.println("</br>");

		salida.println("<a href=Gastos.html> Regresar a Gastos </a></br>");

		salida.println("<a href=index.html> Regresar a Inicio </a>");

	}
}
