package gestion.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import gestion.modelo.*;
import javax.servlet.Servlet;
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

    /**
     * Default constructor. 
     */
    public ServletIngreso() {
        // TODO Auto-generated constructor stub
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
		
		//Crear Usuario
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre_responsable);
		usuario.setCedula(documento_responsable);
		
		//Crear Ingreso
		Ingreso ingreso = new Ingreso(valor,asunto,fecha,tipo,usuario);
		
		
		//Creacion Cuenta
		Cuenta cuenta = new Cuenta(usuario, ingreso);
		
		cuenta = null;
		
		
		//Formato de respuesta
		
		respuesta.setContentType("text/html");
		
		
		PrintWriter salida = respuesta.getWriter();
		
        salida.println("<head>");
        salida.println("<meta charset=\"utf-8\">");
        salida.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=2\">");
        salida.println("<title>Registrar Ingresos</title>");
        salida.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\r\n"
                + "            integrity=\"sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi\" crossorigin=\"anonymous\">");
        salida.println("</head>");
		
		salida.println("<h1>" + cuenta.añadirIngresos() + "<h1>");
		
		salida.println("Nuevo Saldo: " + cuenta.getSaldo());
		
		salida.println("</br>");
		
		salida.println("Datos: ");
		
		salida.println("</br>");
		
		salida.println("<a href=Ingresos.html> Regresar a Ingresos </a></br>");
		
		salida.println("<a href=index.html> Regresar a Inicio </a>");
		
	}

}
