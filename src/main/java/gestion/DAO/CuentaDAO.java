package gestion.DAO;

import gestion.modelo.Cuenta;

public interface CuentaDAO {
	
	public void modificarSaldo(Cuenta cuenta) throws Exception;
	public double mostrarSaldo() throws Exception;
}
