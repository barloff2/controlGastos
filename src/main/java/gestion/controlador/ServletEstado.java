package gestion.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

	protected void doGet(HttpServletRequest peticion, HttpServletResponse respuesta) throws ServletException, IOException {
		IngresoDAO ingresoDao = new DAOIngresoImpl();
		GastoDAO gastoDao = new DAOGastoImpl();
		try {
			ArrayList<Object> listaM = new ArrayList<Object>((ingresoDao.mostrarIngresos()));
			listaM.addAll(gastoDao.mostrarGastos());
			System.out.println(gastoDao.mostrarGastos());
			System.out.println(listaM);
			peticion.setAttribute("listaM", listaM);
			peticion.getRequestDispatcher("/Estado.jsp").forward(peticion, respuesta);
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}	

	}


}
