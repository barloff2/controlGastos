package gestion.modelo;


public class Ingreso {
	private double ingreso;
	private String description;
	private String fecha;
	private String tipo;
	private String responsable;
	
    public Ingreso(double ingreso, String description, String fecha, String tipo, String responsable) {
		this.ingreso = ingreso;
		this.description = description;
		this.fecha = fecha;
		this.tipo = tipo;
		this.responsable = responsable;
	}


	public Ingreso() {
	}


	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getIngreso() {
		return ingreso;
	}

	public void setIngreso(double ingreso) {
		this.ingreso = ingreso;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public String getResponsable() {
		return responsable;
	}


	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

    

 
}
