package gestion.modelo;

public class Cuenta {
	private double saldo;
    private Gasto gasto;
    private Ingreso ingreso;
    
    public Cuenta(Ingreso ingreso) {
    	this.saldo = 0;
    	this.ingreso = ingreso;	
    }
    public Cuenta(Gasto gasto) {
    	this.saldo = 0;
    	this.gasto = gasto;	
    }
    public Cuenta() {
    	
    }
    public double getSaldo() {
		return this.saldo;
    }
    
    public void añadirIngresos() { 	
    	this.saldo += ingreso.getValor();
    }
    
    public void añadirGasto() {
    	if (this.saldo != 0 && this.saldo > gasto.getValor()) {
    		this.saldo -= gasto.getValor();
    	}
    }
	public Gasto getGasto() {
		return gasto;
	}
	public void setGasto(Gasto gasto) {
		this.gasto = gasto;
	}
	public Ingreso getIngreso() {
		return ingreso;
	}
	public void setIngreso(Ingreso ingreso) {
		this.ingreso = ingreso;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
    
	
}
    


