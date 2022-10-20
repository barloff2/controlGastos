package gestion.modelo;


public class Ingreso {
	private double ingreso;
	private String description;
	private String fecha;
	private String tipo;
	private Usuario usuario;
	
    public Ingreso(double ingreso, String description, String fecha, String tipo, Usuario usuario) {
        this.ingreso=ingreso;
        this.description=description;
        this.fecha = fecha;
        this.tipo = tipo;
        this.usuario = usuario;
        
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
    

 
}
