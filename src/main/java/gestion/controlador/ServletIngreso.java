package gestion.controlador;

import java.io.IOException;
import java.io.PrintWriter;

import gestion.DAO.CuentaDAO;
import gestion.DAO.IngresoDAO;
import gestion.modelo.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrimerServlet
 */
@WebServlet("/ServletIngreso")
public class ServletIngreso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletIngreso() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest peticion, HttpServletResponse respuesta)
			throws ServletException, IOException {

		// Tomar Datos
		String tipo = peticion.getParameter("tipo");
		double valor = Double.parseDouble(peticion.getParameter("valor"));
		String fecha = peticion.getParameter("fecha");
		String nombre_responsable = peticion.getParameter("nombre_responsable");
		String asunto = peticion.getParameter("asunto");


		// Instanciar Ingreso
		Ingreso ingreso = new Ingreso(valor, asunto, fecha, tipo, nombre_responsable);
		// Instanciar ingresoDao
		IngresoDAO ingresoDao = new DAOIngresoImpl();
		// Añadir Ingreso a base de datos.
		try {
			ingresoDao.addIngreso(ingreso);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Instanciar Cuenta
		Cuenta cuenta = new Cuenta(ingreso);
		// Instanciar cuentaDao
		CuentaDAO cuentaDao = new DAOCuentaImpl();
		// Actualizar Saldo en objeto Cuenta
		try {
			cuenta.setSaldo(cuentaDao.mostrarSaldo());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}
		// Metodo añadir Ingreso
		cuenta.añadirIngresos();
		// Modificar Saldo
		try {
			cuentaDao.modificarSaldo(cuenta);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Formato de respuesta
		PrintWriter salida = respuesta.getWriter();

		salida.println("<!DOCTYPE html>");
		salida.println("<head>");
		salida.println("<meta charset= \"utf-8\" >");
		salida.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">");

		salida.println("<title> Registrar Ingresos </title>");

		salida.println("<script type=module src=main.js></script>");

		salida.println(
				"<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css\" integrity=\"sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N\" crossorigin=\"anonymous\"> ");
		salida.println("</head>");
		salida.println("<mn-header>");
		salida.println("</mn-header>");
		salida.println("<div class=\"alert alert-success\" role=\"alert\"> Ingreso Exitoso! </div>");
		salida.println("<ul class=\"list-group\">");
		salida.println(" <li class=\"list-group-item\">Saldo actual: " + cuenta.getSaldo());
		salida.println("</li>");
		salida.println("<li class=\"list-group-item\">Razon: " + ingreso.getDescription());
		salida.println("</li>");
		salida.println(" <li class=\"list-group-item\">Fecha: " + ingreso.getFecha());
		salida.println(" </li>");
		salida.println("  <li class=\"list-group-item\">Responsable: " + ingreso.getResponsable());
		salida.println(" </li>");
		salida.println(" </ul>");
		salida.println(" <mn-footer></mn-footer>");
		salida.println("  </body>");
		salida.println(" </html>");

	}

}
