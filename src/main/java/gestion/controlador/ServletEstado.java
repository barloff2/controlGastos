package gestion.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.json.JsonArray;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import gestion.DAO.GastoDAO;
import gestion.DAO.IngresoDAO;
import gestion.modelo.Gasto;
import gestion.modelo.Ingreso;

/**
 * Servlet implementation class ServletEstado
 */
@WebServlet("/ServletEstado")
public class ServletEstado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest peticion, HttpServletResponse respuesta)
			throws ServletException, IOException {	
		String tipo = peticion.getParameter("tipo");
		String json = "";
		Gson gson = new Gson();


		switch (tipo) {
			case "Ingresos":
				List<Ingreso> listaI = new ArrayList();
				IngresoDAO ingresoDao = new DAOIngresoImpl();
				try {
					listaI = ingresoDao.mostrarIngresos();
					
					for (Ingreso ingreso : listaI) {
						json += gson.toJson(ingreso);
						
					}
					try (PrintWriter out = respuesta.getWriter()){
						System.out.println(json);
					};
					
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
				try {
	
				} catch (Exception e) {
					// TODO: handle exception
				}
				break;
			
			case "Gastos":
				List<Gasto> listaG = new ArrayList();
				GastoDAO gastoDao = new DAOGastoImpl();
				try {
					listaG = gastoDao.mostrarGastos();
					for (Gasto gasto : listaG) {
						json += gson.toJson(gasto);
					}
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
				try {
	
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				break;
			default:
				break;
		}


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
		salida.println(" <li class=\"list-group-item\">Saldo actual: " + json);
		salida.println("</li>");
		salida.println("<li class=\"list-group-item\">Razon: ");
		salida.println("</li>");
		salida.println(" <li class=\"list-group-item\">Fecha: ");
		salida.println(" </li>");
		salida.println("  <li class=\"list-group-item\">Responsable: " );
		salida.println(" </li>");
		salida.println(" </ul>");
		salida.println(" <mn-footer></mn-footer>");
		salida.println("  </body>");
		salida.println(" </html>");

	}

	protected void processRequest(HttpServletRequest peticion, HttpServletResponse respuesta)
			throws ServletException, IOException {

	}

}
