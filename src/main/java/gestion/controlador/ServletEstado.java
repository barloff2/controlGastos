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
		// RequestDispatcher rd = peticion.getRequestDispatcher("Estado.html");

	}

	protected void processRequest(HttpServletRequest peticion, HttpServletResponse respuesta)
			throws ServletException, IOException {
		respuesta.setContentType("text/html;charset=UTF-8");
		String tipo = peticion.getParameter("tipo");
		String json = "";


		switch (tipo) {
			case "ingreso":
				List<Ingreso> listaI = new ArrayList();
				IngresoDAO ingresoDao = new DAOIngresoImpl();
				try {
					listaI = ingresoDao.mostrarIngresos();
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
				try {
	
				} catch (Exception e) {
					// TODO: handle exception
				}
				break;
			
			case "gasto":
				List<Gasto> listaG = new ArrayList();
				GastoDAO gastoDao = new DAOGastoImpl();
				try {
					listaG = gastoDao.mostrarGastos();
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
				try {
	
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				json = 
				break;
			default:
				break;
		}


		try (PrintWriter out = respuesta.getWriter()) {
			
			out.print(lista);
		}

	}

}
