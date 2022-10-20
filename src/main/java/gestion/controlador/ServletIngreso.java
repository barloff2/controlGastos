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
		cuenta.añadirIngresos();
		
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
		salida.println("<mn-header></mn-header>")
		salida.println("<h1> Ingreso Exitoso <h1>");
		
		salida.println("Saldo actual: " + cuenta.getSaldo());
		
		salida.println("<head>");

		salida.println("<!DOCTYPE html>");
		salida.println("<html lang="">");
	   
		salida.println("<head>");
		   salida.println("<meta charset="utf-8">");
		   salida.println("<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">");
		   salida.println("<title>Registrar Ingresos</title>");
	   
		  salida.println("<script type=module src=main.js></script>");
	   
		   salida.println("<link rel="stylesheet" "+href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" "+
			   integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous"> ");
	   salida.println("</head>");
	   salida.println("<mn-header>");
	   salida.println("</mn-header>");
	   salida.println("<div class="alert alert-success" role="alert">
		   Ingreso Exitoso! </div>");
	   
	   salida.println("<ul class="list-group">");
	   salida.println(" <li class="list-group-item">Saldo actual: " + cuenta.getSaldo());
	   salida.println("</li>");
	   salida.println("<li class="list-group-item">Razon: ");
	   salida.println("</li>");
	   salida.println(" <li class="list-group-item">Fecha: ");
	   salida.println(" </li>");
	   salida.println("  <li class="list-group-item">Responsable: ");
	   salida.println(" </li>");
	   salida.println(" </ul>");

	   salida.println(" <div class="d-flex align-items-center my-2 my-lg-0 me-lg-auto text-white text-decoration-none">");
	   salida.println("</div>");
	   
	   salida.println("<div class="d-grid d-md-block">");
		   salida.println("<div class="btn-group" role="group">");
			   salida.println("<button class="btn btn-secondary" mr-2">"");
				   salida.println("<a href="Ingresos.html" class="nav-link text-blue" style="text-decoration:none">");
				   salida.println("<svg class="bi d-block mx-auto mb-1" width="20" height="15">");
				   salida.println("<use xlink:href="#speedometer2"></use>");
				   salida.println(" </svg> Ingresos ");
				   salida.println("</a>");
				   salida.println(" </button>");
				   salida.println(" </div>");
				   salida.println(" </div>");
				   salida.println("</form>");
				   salida.println(" </div>");
				   salida.println(" </main>");
				   salida.println(" <mn-footer></mn-footer>");
				   salida.println("  </body>");
				   salida.println(" </html>");
		
	}

}
