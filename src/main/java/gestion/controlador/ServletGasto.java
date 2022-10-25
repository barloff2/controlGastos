package gestion.controlador;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

import gestion.DAO.CuentaDAO;
import gestion.DAO.GastoDAO;
import gestion.DAO.IngresoDAO;
import gestion.modelo.Cuenta;
import gestion.modelo.Gasto;
import gestion.modelo.Ingreso;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class ServletEgreso
 */
@WebServlet("/ServletEgreso")
public class ServletGasto extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest peticion, HttpServletResponse respuesta) throws ServletException, IOException {
		// Tomar Datos
		String tipo = peticion.getParameter("tipo");
		double valor = Double.parseDouble(peticion.getParameter("valor"));
		String fecha = peticion.getParameter("fecha");
		String nombre_responsable = peticion.getParameter("nombre_responsable");
		String asunto = peticion.getParameter("asunto");

		//Instanciar Usuario
		
		//Instanciar Ingreso
		Gasto gasto = new Gasto(valor,asunto,fecha,tipo,nombre_responsable);
		//Instanciar ingresoDao
		GastoDAO gastoDao = new DAOGastoImpl();
		//Añadir Ingreso a base de datos.
		try {
			gastoDao.addGasto(gasto);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		//Instanciar Cuenta
		Cuenta cuenta = new Cuenta(gasto);
		//Instanciar cuentaDao
		CuentaDAO cuentaDao = new DAOCuentaImpl();
		//Actualizar Saldo en objeto Cuenta
		try {
			cuenta.setSaldo(cuentaDao.mostrarSaldo());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}
		//Metodo añadir Ingreso
		cuenta.añadirGasto();
		//Modificar Saldo
		try {
			cuentaDao.modificarSaldo(cuenta);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		//Formato de respuesta
		

		
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
		salida.println("<li class=\"list-group-item\">Razon: " + gasto.getDescription());
		salida.println("</li>");
		salida.println(" <li class=\"list-group-item\">Fecha: " + gasto.getFecha());
		salida.println(" </li>");
		salida.println("  <li class=\"list-group-item\">Responsable: " + gasto.getResponsable());
		salida.println(" </li>");
		salida.println(" </ul>");
		salida.println(" <mn-footer></mn-footer>");
		salida.println("  </body>");
		salida.println(" </html>");
		
	}
}
