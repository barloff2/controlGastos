package vista;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletEgreso
 */
@WebServlet("/ServletEgreso")
public class ServletEgreso extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest peticion, HttpServletResponse respuesta) throws ServletException, IOException {
		
	}
}
