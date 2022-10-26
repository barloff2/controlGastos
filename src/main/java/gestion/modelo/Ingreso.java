package gestion.modelo;


public class Ingreso {
	private double valor;
	private String description;
	private String fecha;
	private String tipo;
	private String responsable;
	
    public Ingreso(double valor, String description, String fecha, String tipo, String responsable) {
		this.valor = valor;
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

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
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
