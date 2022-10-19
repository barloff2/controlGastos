package gestion.controlador;


import java.io.IOException;
import java.sql.Connection;

import gestion.modelo.Cuenta;
import gestion.modelo.Usuario;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletEstado
 */
@WebServlet("/ServletEstado")
public class ServletEstado extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest peticion, HttpServletResponse respuesta) throws ServletException, IOException {
		String cedula = peticion.getParameter("cedula");
		Usuario usuario = new Usuario();
		Cuenta cuenta = new Cuenta(usuario);
		
	}


}
