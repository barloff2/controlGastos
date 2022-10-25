package gestion.modelo;


public class Gasto{
	private double gasto;
	private String description;
	private String fecha;
	private String tipo;
	private String responsable;
	
    public Gasto (double gasto, String description, String fecha, String tipo, String usuario) {
        this.gasto=gasto;
        this.description=description;
        this.fecha = fecha;
        this.tipo = tipo;
        this.responsable = usuario;
    }

	public Gasto() {
		
	}

	public double getGasto() {
		return gasto;
	}

	public void setGasto(double gasto) {
		this.gasto = gasto;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
}

