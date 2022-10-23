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
		List<Ingreso> listaI = new ArrayList<Ingreso>();
		IngresoDAO ingresoDao = new DAOIngresoImpl();
		try {
			listaI = ingresoDao.mostrarIngresos();
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}
		List<Gasto> listaG = new ArrayList<Gasto>();
		GastoDAO gastoDao = new DAOGastoImpl();
		try {
			listaG = gastoDao.mostrarGastos();
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}
		peticion.setAttribute("listaG", listaG);
		peticion.setAttribute("listaI", listaI);
		peticion.getRequestDispatcher("/Estado.jsp").forward(peticion, respuesta);

	}


}
