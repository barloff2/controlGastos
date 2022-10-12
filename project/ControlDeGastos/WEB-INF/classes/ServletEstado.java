package vista;

import java.io.IOException;
import java.sql.Connection;

//import com.co.gestion.controlador.Conexion;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletEstado
 */
@WebServlet("/ServletEstado")
public class ServletEstado extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest peticion, HttpServletResponse respuesta) throws ServletException, IOException {
		String cedula = peticion.getParameter("cedula");
	}


}
