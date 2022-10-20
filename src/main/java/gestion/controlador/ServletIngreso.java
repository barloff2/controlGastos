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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest peticion, HttpServletResponse respuesta) throws ServletException, IOException {
		
		//Tomar Datos
		String tipo = peticion.getParameter("tipo");
		double valor = Double.parseDouble(peticion.getParameter("valor"));
		String fecha = peticion.getParameter("fecha");
		String nombre_responsable = peticion.getParameter("nombre_responsable");
		String documento_responsable = peticion.getParameter("documento_responsable");
		String asunto = peticion.getParameter("asunto");
		
		//Instanciar Usuario
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre_responsable);
		usuario.setCedula(documento_responsable);
		
		//Instanciar Ingreso
		Ingreso ingreso = new Ingreso(valor,asunto,fecha,tipo,usuario);
		//Instanciar ingresoDao
		IngresoDAO ingresoDao = new DAOIngresoImpl();
		//Añadir Ingreso a base de datos.
		try {
			ingresoDao.addIngreso(ingreso);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		respuesta.setContentType("text/html");
		
		
		PrintWriter salida = respuesta.getWriter();
		
		//Instanciar Cuenta
		Cuenta cuenta = new Cuenta(ingreso);
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
		cuenta.añadirIngresos();
		salida.println("<h3>" + cuenta.getSaldo() + "<h3>");
		//Modificar Saldo
		try {
			cuentaDao.modificarSaldo(cuenta);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		//Formato de respuesta
		

		
        salida.println("<head>");
        salida.println("<meta charset=\"utf-8\">");
        salida.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=2\">");
        salida.println("<title>Registrar Ingresos</title>");
        salida.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\r\n"
                + "            integrity=\"sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi\" crossorigin=\"anonymous\">");
        salida.println("</head>");
		
		salida.println("<h1> <h1>");
		
		try {
			salida.println("Nuevo Saldo: " + cuentaDao.mostrarSaldo());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		salida.println("</br>");
		
		salida.println("Datos: ");
		
		salida.println("</br>");
		
		salida.println("<a href=Ingresos.html> Regresar a Ingresos </a></br>");
		
		salida.println("<a href=index.html> Regresar a Inicio </a>");
		
	}

}
